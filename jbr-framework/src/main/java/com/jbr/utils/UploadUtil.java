/**
 * @author : zxw
 * @date : 2022-09-08 16:28
 * @version : 1.0
 **/
package com.jbr.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;

/**
 * 图片上传工具类
 *
 * @author Fetter
 * @version v1.0
 * @date 2021/10/18 9:46
 */
public class UploadUtil {
    /**
     * 检查是否是 bmp/gif/jpg/png图片
     * @param fileList
     * @return
     */
    public static Boolean checkImg(List<MultipartFile> fileList) {
        if (fileList.isEmpty()) {
            return false;
        } else {
            for (MultipartFile file : fileList) {
                try {
                    //通过ImageIO检查是否是 bmp/gif/jpg/png图片
                    Image image = ImageIO.read(file.getInputStream());
                    return image != null;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }
    }

    /**
     * 图片上传
     * @param fileList
     * @param request
     * @param dirPath
     * @return
     */
    public static HashMap<String, Object> upload(List<MultipartFile> fileList, HttpServletRequest request, String dirPath){
        //定义URI地址
        String fileDownloadUri="";
        String fileNamePlus="";
        HashMap<String,Object> urlMap=new HashMap<>();
        for (MultipartFile file: fileList) {
            // 获取文件名
            String fileName = file.getOriginalFilename();
            //创建文件
            File dest = new File(dirPath+fileName);
            if(dest.exists()){
                urlMap.put("source",dirPath+fileName);
                continue;
            }
            //判断文件父目录是否存在
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs(); //这里因为创建的是多级目录，所以需要使用mkdirs()方法。使用mkdir()方法则文件夹创建不成功，会报找不到路径错误。
            }
            try {
                //将文件内容写入创建的文件中
                file.transferTo(dest);
                //获得本机Ip（获取的是服务器的Ip）
                InetAddress inetAddress=InetAddress.getLocalHost();
                String ip=inetAddress.getHostAddress();
                //URL地址的格式：http://ip:port/app/文件路径
                fileDownloadUri=request.getScheme()+"://"+ ip+":"+request.getServerPort()+"/app/upload/"+fileName;
                fileNamePlus=dirPath+fileName;
//                if (fileDownloadUri==""){
//                    fileDownloadUri=request.getScheme()+"://"+ ip+":"+request.getServerPort()+"/app/upload/"+fileName;
//                    fileNamePlus=dirPath+fileName;
//                }else {
//                    fileDownloadUri=fileDownloadUri+","+request.getScheme()+"://"+ ip+":"+request.getServerPort()+"/app/upload/"+fileName;
//                    fileNamePlus=dirPath+fileName+","+dirPath+fileName;
//                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            urlMap.put("source",fileNamePlus);
            urlMap.put("target",fileDownloadUri);
        }
        //返回Url地址，以逗号分隔
        System.out.println(urlMap);
        return urlMap;
    }

    /**
     * 删除单个文件
     * @param pathName  删除文件路径名
     * @return
     */
    public static boolean deleteFiles(String pathName){
        boolean flag = false;
        //根据路径创建文件对象
        File file = new File(pathName);
        //路径是个文件且不为空时删除文件
        if(file.isFile()&&file.exists()){
            flag = file.delete();
        }
        //删除失败时，返回false
        return flag;
    }
}
