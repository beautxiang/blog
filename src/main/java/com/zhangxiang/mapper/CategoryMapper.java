package com.zhangxiang.mapper;

import com.zhangxiang.model.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> selectAllCategories();

    Category findCategoryById(Integer categoryId);

    int deleteCategoryById(Integer categoryId);

    int addCategory(Category category);
    
    int updateNamePhotoCategoryById(Category category);

    int updateNameCategoryById(Category category);
}
