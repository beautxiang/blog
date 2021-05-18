package com.zhangxiang.controller;

import com.zhangxiang.mapper.AboutMapper;
import com.zhangxiang.model.About;
import com.zhangxiang.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class AboutController {

    @Autowired
    private AboutService aboutService;

    @GetMapping("/admin/about")
    public About getAbout() {
        return aboutService.getAbout();
    }

    @PostMapping("/admin/about/update")
    public HashMap<String, String> updateAbout(HttpServletRequest request) {
        HashMap<String, String> map = new HashMap<>();
        int i = aboutService.updateAbout(request);
        System.out.println(i);
        if (i == 0) {
            map.put("msg", "修改失败");
        } else {
            map.put("msg", "修改关于成功");
        }
        return map;
    }

}
