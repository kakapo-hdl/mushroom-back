package com.mushroom.mgjstreet.service;

import com.mushroom.mgjstreet.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();
    int insertCategory(Category category);
    int delete(int id);
    int updateCategory(Category category);
    Category getCategoryById(int id);
}
