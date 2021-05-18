package com.zhangxiang.service;

import com.zhangxiang.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {
    List<Category> selectAllCategories();

    Category findCategoryById(Integer categoryId);

    int deleteCategory(Integer categoryId);

    int addCategory(String path, String categoryName);

    int updateCategoryById(Integer categoryId, String categoryName, String categoryPhoto);

    int updateCategoryById(Integer categoryId, String categoryName);
}
