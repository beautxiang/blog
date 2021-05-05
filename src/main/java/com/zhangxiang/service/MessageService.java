package com.zhangxiang.service;

import com.zhangxiang.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> selectAllMessage();

    int addMessage(String messageUserName, String messageUserEmail, String messageContent);
}
