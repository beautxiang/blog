package com.zhangxiang.model;

public class Category {
    private Integer categoryId;

    private String categoryName;

    private String categoryPhoto;

    public Category() {
    }

    public Category(String categoryName, String categoryPhoto) {
        this.categoryName = categoryName;
        this.categoryPhoto = categoryPhoto;
    }

    public Category(Integer categoryId, String categoryName, String categoryPhoto) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryPhoto = categoryPhoto;
    }

    public Category(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryPhoto() {
        return categoryPhoto;
    }

    public void setCategoryPhoto(String categoryPhoto) {
        this.categoryPhoto = categoryPhoto;
    }
}
