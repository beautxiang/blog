package com.zhangxiang.controller;

import com.zhangxiang.model.Comment;
import com.zhangxiang.service.ArticleService;
import com.zhangxiang.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    // 评论一篇文章或评论
    @PostMapping("/article/{articleId}/comment")
    public HashMap articleLikeById(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer articleId) {

        String commentPid = request.getParameter("commentPid");
        String commentPersonName = request.getParameter("commentPersonName");
        String commentPersonEmail = request.getParameter("commentPersonEmail");
        String commentContent = request.getParameter("commentContent");
        String respondUser = request.getParameter("respondUser");
        int i;
        // 如果不是对评论进行评论
        if (commentPid == null || commentPid.equals("")) {
            i = commentService.commentArticleById(articleId, commentPersonName, commentPersonEmail, commentContent);
        }
        // 如果是对评论进行评论
        else {
            i = commentService.commentCommentById(articleId, commentPersonName, commentPersonEmail, commentContent, Integer.valueOf(commentPid), respondUser);
        }
        int i1 = articleService.updateCommentCount(articleId);
        HashMap map = new HashMap();
        map.put("isComment", i);
        map.put("articleCommentCount", i1);
        return map;
    }

    // 获取一篇文章下的所有评论
    @GetMapping("/article/{articleId}/comment")
    public List<Comment> selectCommentByArticleId(@PathVariable Integer articleId) {
        System.out.println("进到controller函数了");
        return commentService.selectCommentByArticleId(articleId);
    }


}
