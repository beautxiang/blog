package com.zhangxiang.service.impl;

import com.zhangxiang.mapper.CommentMapper;
import com.zhangxiang.model.Category;
import com.zhangxiang.model.Comment;
import com.zhangxiang.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int commentArticleById(Integer articleId, String commentPersonName, String commentPersonEmail, String commentContent) {
        Comment comment = new Comment(articleId, commentPersonName, commentPersonEmail, commentContent, new Date());
        return commentMapper.commentArticleById(comment);
    }

    @Override
    public int commentCommentById(Integer articleId, String commentPersonName, String commentPersonEmail, String commentContent, Integer commentPid, String respondUser) {

        Comment comment = new Comment(commentPid, articleId, commentPersonName, commentPersonEmail, commentContent, respondUser, new Date());
        return commentMapper.commentCommentById(comment);
    }

    @Override
    public List<Comment> selectCommentByArticleId(Integer articleId) {
        List<Comment> comments = commentMapper.selectCommentByArticleId(articleId);
        return comments;
    }

    @Override
    public List<Comment> selectComments() {
        return commentMapper.selectComments();
    }

    @Override
    public int deleteCommentById(Integer commentId) {
        return commentMapper.deleteCommentById(commentId);
    }

}
