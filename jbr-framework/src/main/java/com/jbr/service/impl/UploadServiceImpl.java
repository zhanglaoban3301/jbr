/**
 * @author : zxw
 * @date : 2022-09-08 16:33
 * @version : 1.0
 **/
package com.jbr.service.impl;

import com.jbr.service.UploadService;
import com.jbr.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
@Service
public class UploadServiceImpl implements UploadService {
    /**上传地址*/
    @Value("${file_upload_path}")
    private String dirPath;

    @Override
    public HashMap uploadImg(List<MultipartFile> fileList, HttpServletRequest request) {
        if (UploadUtil.checkImg(fileList)){
            HashMap hashMap=UploadUtil.upload(fileList,request,dirPath);
            return hashMap;
        }else {
            HashMap hashMap=new HashMap();
            hashMap.put("error","请上传bmp/gif/jpg/png格式的图片");
            return hashMap;
        }
    }

    @Override
    public boolean deleteImg(String pathName) {
        System.out.println("path"+pathName);
        boolean flag = false;
        //根据路径创建文件对象
        File file = new File(pathName);
        System.out.println("file:::"+file);
        //路径是个文件且不为空时删除文件
        if(file.isFile()&&file.exists()){
            flag = file.delete();
        }
        //删除失败时，返回false
        return flag;
    }
}
