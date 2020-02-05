package club.javafan.blog.web.controller.admin;


import club.javafan.blog.common.Result.ResponseResult;
import club.javafan.blog.common.util.PageQueryUtil;
import club.javafan.blog.common.util.PageResult;
import club.javafan.blog.service.TagService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author 不会敲代码的小白(博客)
 * @date 2019/12/28 21:39
 * @desc 标签管理
 */
@Controller
@RequestMapping("/admin")
public class TagController {

    @Resource
    private TagService tagService;

    @GetMapping("/tags")
    public ModelAndView tagPage() {
        ModelAndView modelAndView = new ModelAndView("admin/tag");
        modelAndView.addObject("path", "tags");
        return modelAndView;
    }

    @GetMapping("/tags/list")
    @ResponseBody
    public ResponseResult list(@RequestParam Integer page,@RequestParam Integer limit) {
        PageQueryUtil pageUtil = new PageQueryUtil(page,limit);
        PageResult blogTagPage = tagService.getBlogTagPage(pageUtil);
        return ResponseResult.successResult().setData(blogTagPage);
    }


    @PostMapping("/tags/save")
    @ResponseBody
    public ResponseResult save(@RequestParam("tagName") String tagName) {
        if (StringUtils.isEmpty(tagName)) {
            return ResponseResult.failResult("参数异常！");
        }
        if (tagService.saveTag(tagName)) {
            return ResponseResult.successResult("成功！");
        } else {
            return ResponseResult.failResult("标签名称重复");
        }
    }

    @PostMapping("/tags/delete")
    @ResponseBody
    public ResponseResult delete(@RequestBody Integer[] ids) {
        if (ArrayUtils.isEmpty(ids)) {
            return ResponseResult.failResult("参数异常！");
        }
        if (tagService.deleteBatch(ids)) {
            return ResponseResult.successResult("成功！");
        } else {
            return ResponseResult.failResult("有关联数据请勿强行删除");
        }
    }


}
