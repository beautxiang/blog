package com.zhangxiang.mapper;

import com.zhangxiang.model.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> selectAllCategories();

    Category findCategoryById(Integer categoryId);
}
