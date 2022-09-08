/**
 * @author : zxw
 * @date : 2022-09-08 16:31
 * @version : 1.0
 **/
package com.jbr.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;


public interface UploadService {
    /**
     * 上传图片
     * @param fileList
     * @param request
     * @return
     */
    public HashMap uploadImg(List<MultipartFile> fileList, HttpServletRequest request);

    /**
     * 删除图片
     * @param pathName
     * @return
     */
    public boolean deleteImg(String pathName);
}
