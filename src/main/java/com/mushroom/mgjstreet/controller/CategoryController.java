package com.mushroom.mgjstreet.controller;

import com.mushroom.mgjstreet.entity.Category;
import com.mushroom.mgjstreet.entity.CommonValue;
import com.mushroom.mgjstreet.service.CategoryService;
import com.mushroom.util.Result;
import com.mushroom.util.WriteFileByPath;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Category")
public class CategoryController {
    private final CategoryService categoryService;
    private final WriteFileByPath writeFileByPath;

    public CategoryController(CategoryService categoryService, WriteFileByPath writeFileByPath) {
        this.categoryService = categoryService;
        this.writeFileByPath = writeFileByPath;
    }


    @GetMapping("/GetAllCategory")
    public Result GetAllCategory(){
        List<Category> allCategory = categoryService.getAllCategory();
        return Result.ok(allCategory);
    }

    @PostMapping("/Insert")
    public Result InsertCategory(Category category , @RequestParam(value = "imageFile",required = false) MultipartFile file){
        String savePath="";
        if(file!=null){
            try {
                savePath = writeFileByPath.WriteFileByPath(file, CommonValue.CATEGORY_IMAGE_PATH );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        category.setImageUrl(savePath);
        categoryService.insertCategory(category);

        return Result.ok();
    }

    @DeleteMapping("/Delete")
    public Result DeleteCategory( @RequestParam(value = "id",required = true) Integer id){
        int flag = categoryService.delete(id);
        if(flag == 1){
            return Result.ok("删除成功!");
        }else {
            return Result.error("delete Action fail!");
        }

    }

    @PostMapping("/UpdateOrCreate")
    public Result UpdateCategory( Category category ,  @RequestParam(value = "imageFile",required = false) MultipartFile file){
        String savePath="";
        int actionFlag=0;
        if(file!=null){
            try {
                savePath = writeFileByPath.WriteFileByPath(file, CommonValue.CATEGORY_IMAGE_PATH );
                category.setImageUrl(savePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        category.setUpdateDate(new Date());
        if(category.getId()==null){
            category.setCreateDate(new Date());
            actionFlag = categoryService.insertCategory(category);
        }else{
            actionFlag  = categoryService.updateCategory(category);
        }

        if(actionFlag == 1 ){
            return Result.ok();
        }else {
            return Result.error("action success!");
        }
    }

}
