package club.javafan.blog.web.controller.admin;


import club.javafan.blog.common.result.ResponseResult;
import club.javafan.blog.common.util.BlogUtils;
import club.javafan.blog.common.util.PageQueryUtil;
import club.javafan.blog.common.util.PageResult;
import club.javafan.blog.domain.Blog;
import club.javafan.blog.service.BlogService;
import club.javafan.blog.service.CategoryService;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import static java.util.Objects.isNull;

/**
 * @author 敲代码的长腿毛欧巴(博客)
 * @date 2019/12/25 22:21
 * @desc 后台
 */
@Controller
@RequestMapping("/admin")
public class BlogController {
    /**
     *  博客service
     */
    @Resource
    private BlogService blogService;
    /**
     *  目录service
     */
    @Resource
    private CategoryService categoryService;
    /**
     *  文件上传路径
     */
    @Value("${file.file-path}")
    private String FILE_PATH;

    @GetMapping("/blogs/list")
    @ResponseBody
    public ResponseResult list(@RequestParam Map<String, Object> params) {
        if (MapUtils.isEmpty(params) || StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResponseResult.failResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil();
        pageUtil.putAll(params);
        PageResult pageResult = blogService.getBlogsPage(pageUtil);
        return ResponseResult.successResult("成功！").setData(pageResult);
    }


    @GetMapping("/blogs")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("admin/blog");
        modelAndView.addObject("path", "blogs");
        return modelAndView;
    }

    @GetMapping("/blogs/edit")
    public ModelAndView edit() {
        ModelAndView modelAndView = new ModelAndView("admin/edit");
        modelAndView.addObject("path", "edit");
        modelAndView.addObject("categories", categoryService.getAllCategories());
        return modelAndView;
    }

    @GetMapping("/blogs/edit/{blogId}")
    public ModelAndView edit(@PathVariable("blogId") Long blogId) {
        ModelAndView modelAndView = new ModelAndView("error/error_400");
        modelAndView.addObject("path", "edit");
        Blog blog = blogService.getBlogById(blogId);
        if (isNull(blog)) {
            return modelAndView;
        }
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("categories", categoryService.getAllCategories());
        modelAndView.setViewName("admin/edit");
        return modelAndView;
    }

    @PostMapping("/blogs/save")
    @ResponseBody
    public ResponseResult save(Blog blog) {
        ResponseResult result = checkBlogParams(blog);
        if (!result.isSuccess()){
            return result;
        }
        ResponseResult responseResult = blogService.saveBlog(blog);
        return responseResult;
    }


    @PostMapping("/blogs/update")
    @ResponseBody
    public ResponseResult update(@RequestParam Blog blog) {
        if (isNull(blog.getBlogId())) {
            return ResponseResult.failResult("失败，该文章不存在！");
        }
        ResponseResult result = checkBlogParams(blog);
        if (!result.isSuccess()){
            return result;
        }
        ResponseResult responseResult = blogService.updateBlog(blog);
        return responseResult;
    }

    @PostMapping("/blogs/md/uploadfile")
    public void uploadFileByEditormd(HttpServletRequest request
            , HttpServletResponse response
            , @RequestParam(name = "editormd-image-file") MultipartFile file) throws Exception {
        try {
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            //生成文件名称通用方法
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Random r = new Random();
            StringBuilder tempName = new StringBuilder();
            tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
            String newFileName = tempName.toString();
            //创建文件
            File destFile = new File(FILE_PATH + newFileName);
            String fileUrl = BlogUtils.getHost(new URI(request.getRequestURL() + ""))
                    + "/upload/" + newFileName;
            File fileDirectory = new File(FILE_PATH);
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdir()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                }
            }
            file.transferTo(destFile);
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");
            response.getWriter().write("{\"success\": 1, \"message\":\"success\",\"url\":\"" + fileUrl + "\"}");
        } catch (UnsupportedEncodingException e) {
            response.getWriter().write("{\"success\":0}");
        } catch (IOException e) {
            response.getWriter().write("{\"success\":0}");
        }
    }

    @PostMapping("/blogs/delete")
    @ResponseBody
    public ResponseResult delete(@RequestBody Integer[] ids) {
        if (ArrayUtils.isEmpty(ids)) {
            return ResponseResult.failResult("参数异常！");
        }
        Boolean aBoolean = blogService.deleteBatch(ids);
        if (aBoolean) {
            return ResponseResult.successResult("删除成功！");
        } else {
            return ResponseResult.failResult("删除失败");
        }
    }

    private ResponseResult checkBlogParams(Blog blog) {
        if (StringUtils.isEmpty(blog.getBlogTitle())) {
            return ResponseResult.failResult("请输入文章标题");
        }
        if (blog.getBlogTitle().trim().length() > 150) {
            return ResponseResult.failResult("标题过长");
        }
        if (StringUtils.isEmpty(blog.getBlogTags())) {
            return ResponseResult.failResult("请输入文章标签");
        }
        if (blog.getBlogTags().trim().length() > 150) {
            return ResponseResult.failResult("标签过长");
        }
        if (blog.getBlogSubUrl().trim().length() > 150) {
            return ResponseResult.failResult("路径过长");
        }
        if (StringUtils.isEmpty(blog.getBlogContent())) {
            return ResponseResult.failResult("请输入文章内容");
        }
        if (blog.getBlogContent().trim().length() > 100000) {
            return ResponseResult.failResult("文章内容过长");
        }
        if (StringUtils.isEmpty(blog.getBlogCoverImage())) {
            return ResponseResult.failResult("封面图不能为空");
        }
        return ResponseResult.successResult();
    }
}
