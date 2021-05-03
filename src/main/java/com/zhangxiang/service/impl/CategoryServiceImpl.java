package com.zhangxiang.service.impl;

import com.zhangxiang.mapper.CategoryMapper;
import com.zhangxiang.model.Category;
import com.zhangxiang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> selectAllCategories() {
        return categoryMapper.selectAllCategories();
    }

}
