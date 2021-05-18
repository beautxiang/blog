package com.zhangxiang.service.impl;

import com.zhangxiang.mapper.AdminMapper;
import com.zhangxiang.model.Admin;
import com.zhangxiang.service.AdminService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findAdminByName(String adminName) {

        return adminMapper.findAdminByName(adminName);
    }
}
