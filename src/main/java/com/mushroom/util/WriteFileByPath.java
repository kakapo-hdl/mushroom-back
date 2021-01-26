package com.mushroom.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
@Component
public class WriteFileByPath {
    public String WriteFileByPath(MultipartFile multipartFile,String path) throws IOException {
        String folderName = "/headImage";
        String imageName = UUID.randomUUID().toString()+new Date();
        String imageType = multipartFile.getContentType();
        path = path+folderName+imageName+imageType;
        System.out.println(path);
        byte[] bytes = multipartFile.getBytes();
        try {
            File file = new File(path);
            if(!file.exists()){
                File parentFile  = new File(file.getParent());
                parentFile.mkdir();
                parentFile.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return path;
    }
}
