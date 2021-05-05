package com.zhangxiang.mapper;

import com.zhangxiang.model.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {
    List<Message> selectAllMessage();

    int addMessage(Message message);
}
