package com.zhangxiang.mapper;

import com.zhangxiang.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    int commentArticleById(Comment comment);

    int commentCommentById(Comment comment);

    List<Comment> selectCommentByArticleId(Integer articleId);
}
