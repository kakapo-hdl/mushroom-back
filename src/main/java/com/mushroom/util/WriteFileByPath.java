package com.mushroom.util;

import com.mushroom.mgjstreet.entity.CommonValue;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
@Component
public class WriteFileByPath {
    public String WriteFileByPath(MultipartFile multipartFile,String path) throws IOException {
        String imageName = UUID.randomUUID().toString()+ new SimpleDateFormat("yyyyMMddHHmmss").format((new Date()))+".jpg";
        String savePath =CommonValue.BASE_PATH+path+imageName;
        String imageType = multipartFile.getContentType();
        System.out.println(savePath);
        byte[] bytes = multipartFile.getBytes();
        try {
            File file = new File(savePath);
            if(!file.exists()){
                File parentFile  = new File(file.getParent());
                parentFile.mkdirs();
                parentFile.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return path+imageName;
    }
}
