package com.zhangxiang.service;

import com.zhangxiang.model.About;

import javax.servlet.http.HttpServletRequest;

public interface AboutService {
    About getAbout();

    int updateAbout(HttpServletRequest request);
}
