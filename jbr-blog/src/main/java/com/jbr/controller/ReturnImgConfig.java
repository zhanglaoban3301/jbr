/**
 * @author : zxw
 * @date : 2022-09-08 15:24
 * @version : 1.0
 **/
package com.jbr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;

@RestController
public class ReturnImgConfig {

    @Resource
    private HttpServletResponse response;
    @GetMapping(value="/retimg" ,produces = "image/jpeg")
    public void getImage(String path) throws IOException {
        OutputStream os = null;
        try {
            BufferedImage image = null;
            //读取图片
            try{
                image = ImageIO.read(new FileInputStream(new File(path)));
            }catch(Exception e){
                System.out.println("没有读取到在"+path+"位置上的图片");
            }
            response.setContentType("image/jpeg");
            os = response.getOutputStream();
            if (image != null) {
                ImageIO.write(image, "jpg", os);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                os.flush();
                os.close();
            }
        }
    }
}
