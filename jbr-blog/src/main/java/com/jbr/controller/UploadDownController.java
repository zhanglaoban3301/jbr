/**
 * @author : zxw
 * @date : 2022-09-08 14:22
 * @version : 1.0
 **/
package com.jbr.controller;

import com.jbr.domain.pojo.RespBean;
import com.jbr.service.ImgService;
import com.jbr.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController

public class UploadDownController {
    @Autowired
    private UploadService uploadService;
    @Autowired
    private ImgService imgService;
    /**
     * 上传图片
     * @param request
     * @return
     * @throws IOException
     */

    @PostMapping("/upload")
    public RespBean uploadImg(@RequestParam("file") List<MultipartFile> fileList, HttpServletRequest request) {

        return RespBean.success("上传成功",uploadService.uploadImg(fileList, request));
    }
    @GetMapping("/deleteImg")
    public RespBean deleteImg(@RequestParam String path){


        boolean b = uploadService.deleteImg(path);
        if(b){
            return RespBean.success("删除图片成功");
        }
        return RespBean.error("删除失败");
    }


}
