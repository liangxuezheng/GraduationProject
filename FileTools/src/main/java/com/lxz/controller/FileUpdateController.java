package com.lxz.controller;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class FileUpdateController {

    @RequestMapping("/sss")
    public String sss(String user_phone){
        System.out.println("sss*******"+user_phone);
        return user_phone;
    }
    //上架商品
    @RequestMapping("/file_update")
    public String file_update(MultipartFile file, HttpServletRequest request){
        String readPath="";
            //缩略图
            //得到后缀
            String oldName=file.getOriginalFilename();
            String newName= UUID.randomUUID()+oldName.substring(oldName.lastIndexOf("."));
            String url=request.getSession().getServletContext().getRealPath("src");
        System.out.println(url);
            String savePath=url.substring(0, url.indexOf("\\file"))+"/imgs/"+newName;
            File out_file=new File(savePath);
            if (!out_file.getParentFile().exists()){

                out_file.getParentFile().mkdirs();
            }
            //上传---缩略图
            try {
                Thumbnails.of(file.getInputStream()).size(130,130).toFile(out_file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        System.out.println(request.getContextPath());
            readPath=request.getScheme()+"://"+"localhost"+":"+request.getServerPort()+"/imgs/"+newName;
        System.out.println(readPath);
       return readPath;
    }


}
