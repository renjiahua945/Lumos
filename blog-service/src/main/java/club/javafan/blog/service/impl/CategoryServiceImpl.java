package club.javafan.blog.service.impl;


import club.javafan.blog.common.util.PageQueryUtil;
import club.javafan.blog.common.util.PageResult;
import club.javafan.blog.domain.BlogCategory;
import club.javafan.blog.domain.example.BlogCategoryExample;
import club.javafan.blog.repository.BlogCategoryMapper;
import club.javafan.blog.repository.BlogMapper;
import club.javafan.blog.service.CategoryService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

/**
 * @author 敲代码的长腿毛欧巴(博客)
 * @date 2019/12/25 21:06
 * @desc 目录
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private BlogCategoryMapper blogCategoryMapper;
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public PageResult getBlogCategoryPage(PageQueryUtil pageUtil) {
        List<BlogCategory> categoryList = blogCategoryMapper.findCategoryList(pageUtil);
        int total = blogCategoryMapper.getTotalCategories(pageUtil);
        PageResult pageResult = new PageResult(categoryList, total, pageUtil.getLimit()
                , pageUtil.getPage());
        return pageResult;
    }

    @Override
    public int getTotalCategories() {
        return blogCategoryMapper.getTotalCategories(null);
    }

    @Override
    public Boolean saveCategory(String categoryName, String categoryIcon) {
        BlogCategoryExample example = new BlogCategoryExample();
        example.createCriteria()
                .andCategoryNameEqualTo(categoryName)
                .andIsDeletedEqualTo(NumberUtils.BYTE_ZERO);
        List<BlogCategory> blogCategories = blogCategoryMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(blogCategories)) {
            BlogCategory blogCategory = new BlogCategory();
            blogCategory.setCategoryName(categoryName);
            blogCategory.setCategoryIcon(categoryIcon);
            return blogCategoryMapper.insertSelective(blogCategory) > INTEGER_ZERO;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean updateCategory(Integer categoryId, String categoryName, String categoryIcon) {
        BlogCategory blogCategory = blogCategoryMapper.selectByPrimaryKey(categoryId);
        if (Objects.isNull(blogCategory)) {
            blogCategory.setCategoryIcon(categoryIcon);
            blogCategory.setCategoryName(categoryName);
            //修改分类实体
            blogMapper.updateBlogCategorys(categoryName, blogCategory.getCategoryId()
                    , new Integer[]{categoryId});
            return blogCategoryMapper.updateByPrimaryKeySelective(blogCategory) > INTEGER_ZERO;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean deleteBatch(Integer[] ids) {
        if (ArrayUtils.isEmpty(ids)) {
            return false;
        }
        //修改tb_blog表
        blogMapper.updateBlogCategorys("默认分类", INTEGER_ZERO, ids);
        //删除分类数据
        return blogCategoryMapper.deleteBatch(ids) > INTEGER_ZERO;
    }

    @Override
    public List<BlogCategory> getAllCategories() {
        return blogCategoryMapper.findCategoryList(null);
    }

}
