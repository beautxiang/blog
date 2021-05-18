package com.zhangxiang.service;

import com.zhangxiang.model.Category;
import com.zhangxiang.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {
    int commentArticleById(Integer articleId, String commentPersonName, String commentPersonEmail, String commentContent);

    int commentCommentById(Integer articleId, String commentPersonName, String commentPersonEmail, String commentContent, Integer commentPid, String respondUser);

    List<Comment> selectCommentByArticleId(Integer articleId);

    List<Comment> selectComments();

    int deleteCommentById(Integer commentId);
}
