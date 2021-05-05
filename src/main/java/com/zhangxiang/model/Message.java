package com.zhangxiang.model;

import java.util.Date;

public class Message {
    private Integer messageId;

    private String messageUserName;

    private String messageUserEmail;

    private String messageContent;

    private Date messageCreationTime;


    public Message() {
    }

    public Message(String messageUserName, String messageUserEmail, String messageContent, Date messageCreationTime) {
        this.messageUserName = messageUserName;
        this.messageUserEmail = messageUserEmail;
        this.messageContent = messageContent;
        this.messageCreationTime = messageCreationTime;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageUserName() {
        return messageUserName;
    }

    public void setMessageUserName(String messageUserName) {
        this.messageUserName = messageUserName;
    }

    public String getMessageUserEmail() {
        return messageUserEmail;
    }

    public void setMessageUserEmail(String messageUserEmail) {
        this.messageUserEmail = messageUserEmail;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getMessageCreationTime() {
        return messageCreationTime;
    }

    public void setMessageCreationTime(Date messageCreationTime) {
        this.messageCreationTime = messageCreationTime;
    }
}

