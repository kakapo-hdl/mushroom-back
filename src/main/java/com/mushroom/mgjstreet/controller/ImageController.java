package com.mushroom.mgjstreet.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api")
public class ImageController {

    @PostMapping("/UploadImage")
    public String UploadImage(@RequestParam(name = "Image",required = false) MultipartFile ImageFile, HttpServletRequest httpServletRequest){
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String RealPath = httpServletRequest.getServletContext().getRealPath("/");
        long size = ImageFile.getSize();
        try {
            InputStream inputStream = ImageFile.getInputStream();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(size);
        return ImageFile.getOriginalFilename();
    }
}
