package club.javafan.blog.service;


import club.javafan.blog.common.util.PageQueryUtil;
import club.javafan.blog.common.util.PageResult;
import club.javafan.blog.domain.BlogComment;

public interface CommentService {
    /**
     * 添加评论
     *
     * @param blogComment
     * @return
     */
    Boolean addComment(BlogComment blogComment);

    /**
     * 根据Id查询评论
     *
     * @param blogCommentId 评论id
     * @return
     */
    BlogComment getComment(Long blogCommentId);

    /**
     * 后台管理系统中评论分页功能
     *
     * @param pageUtil
     * @return
     */
    PageResult getCommentsPage(PageQueryUtil pageUtil);

    int getTotalComments();

    /**
     * 批量审核
     *
     * @param ids
     * @return
     */
    Boolean checkDone(Integer[] ids);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    Boolean deleteBatch(Integer[] ids);

    /**
     * 添加回复
     *
     * @param commentId
     * @param replyBody
     * @return
     */
    Boolean reply(Long commentId, String replyBody);

    /**
     * 根据文章id和分页参数获取文章的评论列表
     *
     * @param blogId
     * @param page
     * @return
     */
    PageResult getCommentPageByBlogIdAndPageNum(Long blogId, int page);
}
