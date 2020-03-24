package com.crazy.article.controller;

import com.crazy.article.result.ImageResult;
import com.crazy.core.constant.Constant;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
/**
 * @author shiyi
 * @version 1.0
 * @date 2020-3-24 17:01
 * 获取文件，然后保存起来
 */
@RestController
@RequestMapping("/upload")
public class FileController {

    @PostMapping("/img")
    public ImageResult uploadImg(@RequestParam("file") MultipartFile file){
        try {
            if (file.isEmpty()) {
                return ImageResult.fail("文件为空");
            }
            String fileName = file.getOriginalFilename();
            assert fileName != null;
            String suffixName = fileName.substring(fileName.indexOf("."));
            fileName = String.valueOf(System.currentTimeMillis());
            File imageFile = new File(Constant.IMG_PATH + fileName + suffixName);
            if (!imageFile.exists()) {
                imageFile.getParentFile().mkdir();
                imageFile.createNewFile();
            }
            file.transferTo(imageFile);
            String url = Constant.IMG_PATH + fileName + suffixName;
            return ImageResult.success(url);
        } catch (IOException e) {
            e.printStackTrace();
            return ImageResult.fail(e.getMessage());
        }
    }
}
