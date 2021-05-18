package com.zhangxiang.mapper;

import com.zhangxiang.model.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    Admin findAdminByName(String adminName);
}
