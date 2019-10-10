package com.codegym.controller;

import com.codegym.model.MyFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class MyUploadController {

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFile(MyFile myFile, Model model) {
        model.addAttribute("message", "Upload success");

        try {
            MultipartFile multipartFile = myFile.getMultipartFile();
            String fileName = multipartFile.getOriginalFilename();
            File file = new File(this.getFolderUpload(), fileName);
            multipartFile.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Upload failed");
        }
        return "result";
    }
    public File getFolderUpload() {
        File folderUpload = new File("/home/min2208/Documents/case-study/src/main/webapp/WEB-INF/images");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }

}
