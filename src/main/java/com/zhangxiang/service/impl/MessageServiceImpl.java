package com.zhangxiang.service.impl;

import com.zhangxiang.mapper.MessageMapper;
import com.zhangxiang.model.Message;
import com.zhangxiang.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> selectAllMessage() {
        return messageMapper.selectAllMessage();
    }

    @Override
    public int addMessage(String messageUserName, String messageUserEmail, String messageContent) {
        Message message = new Message(messageUserName, messageUserEmail, messageContent, new Date());
        return messageMapper.addMessage(message);
    }

}
