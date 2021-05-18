package com.zhangxiang.model;

import javax.xml.crypto.Data;
import java.util.Date;

public class Comment {
    private Integer commentId;

    private Integer commentPid;

    private Integer articleId;

    private String commentPersonName;

    private String commentPersonEmail;

    private String commentContent;

    private String respondUser;

    private Date commentCreationTime;

    private Article article;

    public Comment() {
    }

    public Comment(Integer articleId, String commentPersonName, String commentPersonEmail, String commentContent, Date commentCreationTime) {
        this.articleId = articleId;
        this.commentPersonName = commentPersonName;
        this.commentPersonEmail = commentPersonEmail;
        this.commentContent = commentContent;
        this.commentCreationTime = commentCreationTime;
    }

    public Comment(Integer commentPid, Integer articleId, String commentPersonName, String commentPersonEmail, String commentContent, String respondUser, Date commentCreationTime) {
        this.commentPid = commentPid;
        this.articleId = articleId;
        this.commentPersonName = commentPersonName;
        this.commentPersonEmail = commentPersonEmail;
        this.commentContent = commentContent;
        this.respondUser = respondUser;
        this.commentCreationTime = commentCreationTime;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentPid() {
        return commentPid;
    }

    public void setCommentPid(Integer commentPid) {
        this.commentPid = commentPid;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getCommentPersonName() {
        return commentPersonName;
    }

    public void setCommentPersonName(String commentPersonName) {
        this.commentPersonName = commentPersonName;
    }

    public String getCommentPersonEmail() {
        return commentPersonEmail;
    }

    public void setCommentPersonEmail(String commentPersonEmail) {
        this.commentPersonEmail = commentPersonEmail;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getRespondUser() {
        return respondUser;
    }

    public void setRespondUser(String respondUser) {
        this.respondUser = respondUser;
    }

    public Date getCommentCreationTime() {
        return commentCreationTime;
    }

    public void setCommentCreationTime(Date commentCreationTime) {
        this.commentCreationTime = commentCreationTime;
    }
}
