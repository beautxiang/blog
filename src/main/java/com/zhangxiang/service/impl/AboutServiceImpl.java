package com.zhangxiang.service.impl;

import com.zhangxiang.mapper.AboutMapper;
import com.zhangxiang.model.About;
import com.zhangxiang.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AboutServiceImpl implements AboutService {

    @Autowired
    private AboutMapper aboutMapper;

    @Override
    public About getAbout() {
        return aboutMapper.getAbout();
    }

    @Override
    public int updateAbout(HttpServletRequest request) {
        String aboutTitle = request.getParameter("aboutTitle");
        String aboutContent = request.getParameter("aboutContent");
        String aboutSubscript = request.getParameter("aboutSubscript");
        About about = new About(aboutTitle, aboutContent, aboutSubscript);

        return aboutMapper.updateAbout(about);
    }

}
