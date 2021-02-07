package com.mushroom.mgjstreet.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mushroom.mgjstreet.entity.Category;
import com.mushroom.mgjstreet.entity.CommonValue;
import com.mushroom.mgjstreet.mapper.CategoryMapper;
import com.mushroom.mgjstreet.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<Category> getAllCategory() {
        QueryWrapper<Category> qw = new QueryWrapper<>();
        List<Category> categories = categoryMapper.selectList(qw);
        categories.forEach(item->{

            if(item.getImageUrl()!=null){
            if(!item.getImageUrl().equals("")){
                item.setImageUrl(CommonValue.SERVER_URL+item.getImageUrl());
            }
            }
        });
        List<Category> categoriesOne = categories.stream().filter((Category c) ->
                c.getParentId() == 0).collect(Collectors.toList());
        categoriesOne.forEach(item->{
            List<Category> categoryTwo = categories.stream().filter((Category c) ->
                    c.getParentId() == item.getId()).collect(Collectors.toList());
            categoryTwo.forEach(itemTwo ->{
                List<Category> categoryThree = categories.stream().filter((Category c) ->
                        c.getParentId() == itemTwo.getId()).collect(Collectors.toList());
                itemTwo.setChildren(categoryThree);
            });
            item.setChildren(categoryTwo);
        });

        return categoriesOne;
    }

    @Override
    public int insertCategory(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public int delete(int id) {
        return categoryMapper.deleteById(id);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateById(category);
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryMapper.selectById(id);
    }

}
