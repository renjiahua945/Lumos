package club.javafan.blog.web.controller.admin;


import club.javafan.blog.common.mail.MailService;
import club.javafan.blog.common.result.ResponseResult;
import club.javafan.blog.common.util.PageQueryUtil;
import club.javafan.blog.common.util.PageResult;
import club.javafan.blog.domain.BlogComment;
import club.javafan.blog.service.CommentService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author 敲代码的长腿毛欧巴(博客)
 * @date 2019/12/28 21:22
 * @desc 评论管理
 */
@Controller
@RequestMapping("/admin")
public class CommentController {
    /**
     * 注入评论服务
     */
    @Resource
    private CommentService commentService;
    /**
     * 注入MailService
     */
    @Autowired
    private MailService mailService;

    @GetMapping("/comments/list")
    @ResponseBody
    public ResponseResult list(@RequestParam Integer page, @RequestParam Integer limit) {
        if (Objects.isNull(page) || Objects.isNull(limit)) {
            return ResponseResult.failResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(page,limit);
        PageResult commentsPage = commentService.getCommentsPage(pageUtil);
        return ResponseResult.successResult("成功！").setData(commentsPage);
    }

    @PostMapping("/comments/checkDone")
    @ResponseBody
    public ResponseResult checkDone(@RequestBody Integer[] ids) {
        if (ArrayUtils.isEmpty(ids)) {
            return ResponseResult.failResult("参数异常！");
        }
        Boolean aBoolean = commentService.checkDone(ids);
        if (aBoolean) {
            return ResponseResult.successResult("成功！");
        } else {
            return ResponseResult.failResult("已经审核过，或者审核失败！");
        }
    }

    @PostMapping("/comments/reply")
    @ResponseBody
    public ResponseResult checkDone(@RequestParam("commentId") Long commentId,
                            @RequestParam("replyBody") String replyBody) {
        if (Objects.isNull(commentId)|| commentId < 1 || StringUtils.isEmpty(replyBody)) {
            return ResponseResult.failResult("参数异常！");
        }
        Boolean reply = commentService.reply(commentId, replyBody);
        if (reply) {
            BlogComment comment = commentService.getComment(commentId);
            //异步发送邮件
            mailService.sendSimpleMail(comment.getEmail(), "尊敬的用户: " + comment.getNickName() + ",您的评论收到了新的回复"
                    , "博客作者回复了您的评论：\" " + comment.getCommentBody() + "\"" + replyBody, null);
            return ResponseResult.successResult("成功！");
        } else {
            return ResponseResult.failResult("回复失败");
        }
    }

    @PostMapping("/comments/delete")
    @ResponseBody
    public ResponseResult delete(@RequestBody Integer[] ids) {
        if (ArrayUtils.isEmpty(ids)) {
            return ResponseResult.failResult("参数异常！");
        }
        Boolean aBoolean = commentService.deleteBatch(ids);
        if (aBoolean) {
            return ResponseResult.successResult("成功！");
        } else {
            return ResponseResult.failResult("刪除失败");
        }
    }

    @GetMapping("/comments")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("admin/comment");
        modelAndView.addObject("path", "comments");
        return modelAndView;
    }


}
