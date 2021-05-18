package com.zhangxiang.service.impl;

import com.zhangxiang.mapper.ArticleMapper;
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

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Category> selectAllCategories() {
        return categoryMapper.selectAllCategories();
    }


    @Override
    public Category findCategoryById(Integer categoryId) {
        return categoryMapper.findCategoryById(categoryId);
    }

    @Override
    public int deleteCategory(Integer categoryId) {
        articleMapper.updateCategoriesToZero(categoryId);
        return categoryMapper.deleteCategoryById(categoryId);
    }

    @Override
    public int addCategory(String path, String categoryName) {
        Category category = new Category(categoryName, path);
        return categoryMapper.addCategory(category);
    }

    @Override
    public int updateCategoryById(Integer categoryId, String categoryName, String categoryPhoto) {
        Category category = new Category(categoryId, categoryName, categoryPhoto);
        return categoryMapper.updateNamePhotoCategoryById(category);
    }

    @Override
    public int updateCategoryById(Integer categoryId, String categoryName) {
        Category category = new Category(categoryId, categoryName);
        return categoryMapper.updateNameCategoryById(category);
    }

}
