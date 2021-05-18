package com.zhangxiang.service;

import com.zhangxiang.model.Admin;

public interface AdminService {
    Admin findAdminByName(String adminName);
}
