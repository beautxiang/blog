package com.zhangxiang.controller;

import com.zhangxiang.model.Message;
import com.zhangxiang.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/message")
    public List<Message> selectAllMessage() {
        return messageService.selectAllMessage();
    }

    @PostMapping("/message")
    public int addMessage(HttpServletRequest request) {
        String messageUserName = request.getParameter("messageUserName");
        String messageUserEmail = request.getParameter("messageUserEmail");
        String messageContent = request.getParameter("messageContent");
        return messageService.addMessage(messageUserName, messageUserEmail, messageContent);
    }

}
