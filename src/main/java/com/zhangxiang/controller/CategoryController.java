package com.zhangxiang.controller;

import com.zhangxiang.model.Article;
import com.zhangxiang.model.Category;
import com.zhangxiang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/list")
    public List<Category> returnAllCategories() {
        return categoryService.selectAllCategories();
    }




}
