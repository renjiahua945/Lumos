package club.javafan.blog.web.controller.admin;

import club.javafan.blog.common.Result.ResponseResult;
import club.javafan.blog.common.util.PageQueryUtil;
import club.javafan.blog.common.util.PageResult;
import club.javafan.blog.service.CategoryService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author 敲代码的长腿毛欧巴(博客)
 * @date 2019/12/28 21:02
 * @desc 目录管理
 */
@Controller
@RequestMapping("/admin")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ModelAndView categoryPage() {
        ModelAndView modelAndView = new ModelAndView("admin/category");
        modelAndView.addObject("path", "categories");
        return modelAndView;
    }

    /**
     * 分类列表
     */
    @RequestMapping(value = "/categories/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult list(@RequestParam Integer page,@RequestParam Integer limit) {
        if (Objects.isNull(page) || Objects.isNull(limit)) {
            return ResponseResult.failResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(page,limit);
        PageResult blogCategoryPage = categoryService.getBlogCategoryPage(pageUtil);
        return ResponseResult.successResult("成功！").setData(blogCategoryPage);
    }

    /**
     * 分类添加
     */
    @RequestMapping(value = "/categories/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult save(@RequestParam("categoryName") String categoryName,
                       @RequestParam("categoryIcon") String categoryIcon) {
        ResponseResult result = checkParams(categoryName, categoryIcon);
        if (!result.isSuccess()){
            return result;
        }
        Boolean aBoolean = categoryService.saveCategory(categoryName, categoryIcon);
        if (aBoolean) {
            return ResponseResult.successResult("成功！");
        } else {
            return ResponseResult.failResult("分类名称重复");
        }
    }


    /**
     * 分类修改
     */
    @RequestMapping(value = "/categories/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult update(@RequestParam("categoryId") Integer categoryId,
                         @RequestParam("categoryName") String categoryName,
                         @RequestParam("categoryIcon") String categoryIcon) {
        ResponseResult result = checkParams(categoryName, categoryIcon);
        if (!result.isSuccess()){
            return result;
        }
        Boolean aBoolean = categoryService.updateCategory(categoryId, categoryName, categoryIcon);
        if (aBoolean) {
            return ResponseResult.successResult("成功！！");
        } else {
            return ResponseResult.failResult("分类名称重复");
        }
    }



    /**
     * 分类删除
     */
    @RequestMapping(value = "/categories/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult delete(@RequestBody Integer[] ids) {
        if (ArrayUtils.isEmpty(ids)) {
            return ResponseResult.failResult("参数异常！");
        }
        Boolean aBoolean = categoryService.deleteBatch(ids);
        if (aBoolean) {
            return ResponseResult.successResult("成功！");
        } else {
            return ResponseResult.failResult("删除失败");
        }
    }
    private ResponseResult checkParams(@RequestParam("categoryName") String categoryName
            , @RequestParam("categoryIcon") String categoryIcon) {
        if (StringUtils.isEmpty(categoryName)) {
            return ResponseResult.failResult("请输入分类名称！");
        }
        if (StringUtils.isEmpty(categoryIcon)) {
            return ResponseResult.failResult("请选择分类图标！");
        }
        return ResponseResult.successResult();
    }

}
