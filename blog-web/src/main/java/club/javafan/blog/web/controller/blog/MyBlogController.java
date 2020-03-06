package club.javafan.blog.web.controller.blog;


import club.javafan.blog.common.Result.ResponseResult;
import club.javafan.blog.common.qquserinfo.QQUserInfo;
import club.javafan.blog.common.sennsor.AipContentCensorBuilder;
import club.javafan.blog.common.util.PageResult;
import club.javafan.blog.common.util.PatternUtil;
import club.javafan.blog.domain.BlogComment;
import club.javafan.blog.domain.BlogLink;
import club.javafan.blog.domain.vo.BlogDetailVO;
import club.javafan.blog.domain.vo.QQUserInfoVO;
import club.javafan.blog.domain.vo.SimpleBlogListVO;
import club.javafan.blog.service.*;
import com.google.common.cache.Cache;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * @author 敲代码的长腿毛欧巴(博客)
 * @date 2019/12/30 23:41
 * @desc 博客
 */
@Controller
public class MyBlogController {
    @Resource
    private BlogService blogService;
    @Resource
    private TagService tagService;
    @Resource
    private LinkService linkService;
    @Resource
    private CommentService commentService;
    @Resource
    private ConfigService configService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private QQUserInfo qqUserInfo;
    @Resource
    private Cache<String,Object> guavaCache;
    /**
     * 首页
     *
     * @return
     */
    @GetMapping({"/", "/index", "index.html"})
    public ModelAndView index(HttpServletRequest request) {
        return this.page(10);
    }
    /**
     * 首页 分页数据
     *
     * @return
     */
    @GetMapping({"/page/{pageNum}"})
    public ModelAndView page(@PathVariable("pageNum") int pageNum) {
        PageResult blogPageResult = blogService.getBlogsForIndexPage(1, pageNum);
        ModelAndView modelAndView = new ModelAndView("blog/amaze/index");
        if (isNull(blogPageResult)) {
            modelAndView.setViewName("error/error_404");
            return modelAndView;
        }
        modelAndView.addObject("blogPageResult", blogPageResult);
        modelAndView.addObject("newBlogs", blogService.getBlogListForIndexPage(1));
        modelAndView.addObject("hotBlogs", blogService.getBlogListForIndexPage(0));
        modelAndView.addObject("hotTags", tagService.getBlogTagCountForIndex());
        modelAndView.addObject("pageName", "首页");
        modelAndView.addObject("configurations", configService.getAllConfigs());
        return modelAndView;
    }

    /**
     * Categories页面(包括分类数据和标签数据)
     *
     * @return
     */
    @GetMapping({"/categories"})
    public ModelAndView categories() {
        ModelAndView modelAndView = new ModelAndView("blog/amaze/category");
        modelAndView.addObject("hotTags", tagService.getBlogTagCountForIndex());
        modelAndView.addObject("categories", categoryService.getAllCategories());
        modelAndView.addObject("pageName", "分类页面");
        modelAndView.addObject("configurations", configService.getAllConfigs());
        return modelAndView;
    }

    /**
     * 详情页
     *
     * @return
     */
    @GetMapping({"/blog/{blogId}", "/article/{blogId}"})
    public ModelAndView detail(@PathVariable("blogId") Long blogId
            , @RequestParam(value = "commentPage", required = false, defaultValue = "1") Integer commentPage) {
        ModelAndView modelAndView = new ModelAndView("blog/amaze/detail");
        Object blog = guavaCache.getIfPresent(String.valueOf(blogId));
        if (nonNull(blog)){
            modelAndView.addObject("blogDetailVO", (BlogDetailVO)blog);
            modelAndView.addObject("commentPageResult", commentService.getCommentPageByBlogIdAndPageNum(blogId, commentPage));
            System.out.println(guavaCache.stats());
        }
        if (isNull(blog)){
            BlogDetailVO blogDetailVO = blogService.getBlogDetail(blogId);
            if (nonNull(blogDetailVO)){
                modelAndView.addObject("blogDetailVO", blogDetailVO);
                modelAndView.addObject("commentPageResult", commentService.getCommentPageByBlogIdAndPageNum(blogId, commentPage));
                guavaCache.put(String.valueOf(blogId),blogDetailVO);
            }
        }
        modelAndView.addObject("pageName", "详情");
        modelAndView.addObject("configurations", configService.getAllConfigs());
        return modelAndView;
    }

    /**
     * 标签列表页
     *
     * @return
     */
    @GetMapping({"/tag/{tagName}"})
    public ModelAndView tag(@PathVariable("tagName") String tagName) {
        return tag(tagName, 1);
    }

    /**
     * 标签列表页
     *
     * @return
     */
    @GetMapping({"/tag/{tagName}/{page}"})
    public ModelAndView tag(@PathVariable("tagName") String tagName, @PathVariable("page") Integer page) {
        ModelAndView modelAndView = new ModelAndView("blog/amaze/list");
        PageResult blogPageResult = blogService.getBlogsPageByTag(tagName, page);
        modelAndView.addObject("blogPageResult", blogPageResult);
        modelAndView.addObject("pageName", "标签");
        modelAndView.addObject("pageUrl", "tag");
        modelAndView.addObject("keyword", tagName);
        modelAndView.addObject("newBlogs", blogService.getBlogListForIndexPage(1));
        modelAndView.addObject("hotBlogs", blogService.getBlogListForIndexPage(0));
        modelAndView.addObject("hotTags", tagService.getBlogTagCountForIndex());
        modelAndView.addObject("configurations", configService.getAllConfigs());
        return modelAndView;
    }

    /**
     * 分类列表页
     *
     * @return
     */
    @GetMapping({"/category/{categoryName}"})
    public ModelAndView category(@PathVariable("categoryName") String categoryName) {
        return category(categoryName, 1);
    }

    /**
     * 分类列表页
     *
     * @return
     */
    @GetMapping({"/category/{categoryName}/{page}"})
    public ModelAndView category(@PathVariable("categoryName") String categoryName
            , @PathVariable("page") Integer page) {
        ModelAndView modelAndView = new ModelAndView("blog/amaze/list");
        PageResult blogPageResult = blogService.getBlogsPageByCategory(categoryName, page);
        modelAndView.addObject("blogPageResult", blogPageResult);
        modelAndView.addObject("pageName", "分类");
        modelAndView.addObject("pageUrl", "category");
        modelAndView.addObject("keyword", categoryName);
        List<SimpleBlogListVO> blogListForIndexPage = blogService.getBlogListForIndexPage(1);
        modelAndView.addObject("newBlogs", blogListForIndexPage);
        modelAndView.addObject("hotBlogs", blogService.getBlogListForIndexPage(0));
        modelAndView.addObject("hotTags", tagService.getBlogTagCountForIndex());
        modelAndView.addObject("configurations", configService.getAllConfigs());
        return modelAndView;
    }

    /**
     * 搜索列表页
     *
     * @return
     */
    @GetMapping({"/search/{keyword}"})
    public ModelAndView search(@PathVariable("keyword") String keyword) {
        return search(keyword, 1);
    }

    /**
     * 搜索列表页
     *
     * @return
     */
    @GetMapping({"/search/{keyword}/{page}"})
    public ModelAndView search(@PathVariable("keyword") String keyword, @PathVariable("page") Integer page) {
        PageResult blogPageResult = blogService.getBlogsPageBySearch(keyword, page);
        ModelAndView modelAndView = new ModelAndView("blog/amaze/list");
        modelAndView.addObject("blogPageResult", blogPageResult);
        modelAndView.addObject("pageName", "搜索");
        modelAndView.addObject("pageUrl", "search");
        modelAndView.addObject("keyword", keyword);
        modelAndView.addObject("newBlogs", blogService.getBlogListForIndexPage(1));
        modelAndView.addObject("hotBlogs", blogService.getBlogListForIndexPage(0));
        modelAndView.addObject("hotTags", tagService.getBlogTagCountForIndex());
        modelAndView.addObject("configurations", configService.getAllConfigs());
        return modelAndView;
    }


    /**
     * 友情链接页
     *
     * @return
     */
    @GetMapping({"/link"})
    public ModelAndView link() {
        ModelAndView modelAndView = new ModelAndView("blog/amaze/link");
        modelAndView.addObject("pageName", "友情链接");
        Map<Byte, List<BlogLink>> linkMap = linkService.getLinksForLinkPage();
        if (linkMap != null) {
            //判断友链类别并封装数据 0-友链 1-推荐 2-个人网站
            if (linkMap.containsKey((byte) 0)) {
                modelAndView.addObject("favoriteLinks", linkMap.get((byte) 0));
            }
            if (linkMap.containsKey((byte) 1)) {
                modelAndView.addObject("recommendLinks", linkMap.get((byte) 1));
            }
            if (linkMap.containsKey((byte) 2)) {
                modelAndView.addObject("personalLinks", linkMap.get((byte) 2));
            }
        }
        modelAndView.addObject("configurations", configService.getAllConfigs());
        return modelAndView;
    }

    /**
     * 评论操作
     */
    @PostMapping(value = "/blog/comment")
    @ResponseBody
    public ResponseResult comment(HttpServletRequest request, HttpSession session,
                                  @RequestParam Long blogId, @RequestParam String verifyCode,
                                  @RequestParam String email, @RequestParam String qNumber,
                                  @RequestParam String nickName, @RequestParam String headImg,
                                  @RequestParam String websiteUrl, @RequestParam String commentBody) {
        if (StringUtils.isEmpty(verifyCode)) {
            return ResponseResult.failResult("验证码不能为空");
        }
        String kaptchaCode = session.getAttribute("verifyCode") + "";
        if (StringUtils.isEmpty(kaptchaCode)) {
            return ResponseResult.failResult("非法请求");
        }
        if (!verifyCode.equals(kaptchaCode)) {
            return ResponseResult.failResult("验证码错误");
        }
        String ref = request.getHeader("Referer");
        if (StringUtils.isEmpty(ref)) {
            return ResponseResult.failResult("非法请求");
        }
        if (null == blogId || blogId < 0) {
            return ResponseResult.failResult("非法请求");
        }
        if (StringUtils.isEmpty(email)) {
            return ResponseResult.failResult("请输入邮箱地址");
        }
        if (!PatternUtil.isEmail(email)) {
            return ResponseResult.failResult("请输入正确的邮箱地址");
        }
        if (nickName.trim().length() > 50) {
            return ResponseResult.failResult("昵称非法");
        }
        if (qNumber.trim().length() > 20) {
            return ResponseResult.failResult("qq号非法");
        }
        if (headImg.trim().length() > 200 || !PatternUtil.isURL(headImg)) {
            return ResponseResult.failResult("头像非法");
        }
        if (StringUtils.isEmpty(commentBody)) {
            return ResponseResult.failResult("请输入评论内容");
        }
        if (commentBody.trim().length() > 200) {
            return ResponseResult.failResult("评论内容过长");
        }
        BlogComment comment = new BlogComment();
        comment.setBlogId(blogId);
        comment.setEmail(email);
        comment.setQNumber(qNumber);
        comment.setNickName(nickName);
        comment.setHeadImg(headImg);
        if (PatternUtil.isURL(websiteUrl)) {
            comment.setWebsiteUrl(websiteUrl);
        }
        comment.setCommentBody(commentBody);
        comment.setCommentCreateTime(new Date());
        AipContentCensorBuilder.SensorResult results = AipContentCensorBuilder.judgeText(comment.toString());
        if (!results.getCode().equals(NumberUtils.INTEGER_ZERO)) {
            return ResponseResult.successResult().setData(false);
        }
        Boolean aBoolean = commentService.addComment(comment);
        return ResponseResult.successResult().setData(aBoolean);
    }

    /**
     * 关于页面 以及其他配置了subUrl的文章页
     *
     * @return
     */
    @GetMapping({"/{subUrl}"})
    public ModelAndView detail(@PathVariable("subUrl") String subUrl) {
        ModelAndView modelAndView = new ModelAndView("blog/amaze/detail");
        BlogDetailVO blogDetailVO = blogService.getBlogDetailBySubUrl(subUrl);
        if (isNull(blogDetailVO)) {
            modelAndView.setViewName("error/error_400");
            return modelAndView;
        }
        modelAndView.addObject("blogDetailVO", blogDetailVO);
        modelAndView.addObject("pageName", subUrl);
        modelAndView.addObject("configurations", configService.getAllConfigs());
        return modelAndView;
    }
    @RequestMapping("/blog/comment/getUserInfo")
    @ResponseBody
    public QQUserInfoVO getUserInfo(@RequestParam String qq) throws Exception {
        QQUserInfoVO qqUserInfo = this.qqUserInfo.getQQUserInfo(qq);
        return qqUserInfo;
    }
}
