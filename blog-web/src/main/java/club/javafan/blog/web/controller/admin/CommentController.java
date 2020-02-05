package club.javafan.blog.web.controller.admin;


import club.javafan.blog.common.Result.ResponseResult;
import club.javafan.blog.common.util.PageQueryUtil;
import club.javafan.blog.common.util.PageResult;
import club.javafan.blog.service.CommentService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author 不会敲代码的小白(博客)
 * @date 2019/12/28 21:22
 * @desc 评论管理
 */
@Controller
@RequestMapping("/admin")
public class CommentController {

    @Resource
    private CommentService commentService;

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
            return ResponseResult.failResult("审核失败");
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
