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
    private String path = "D://img/20220908151905im_01.jpg";
    @Resource
    private HttpServletResponse response;
    @GetMapping(value="/retimg" ,produces = "image/jpeg")
    public void getImage() throws IOException {
        OutputStream os = null;
        try {
//        读取图片
            BufferedImage image = ImageIO.read(new FileInputStream(new File(path)));
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
