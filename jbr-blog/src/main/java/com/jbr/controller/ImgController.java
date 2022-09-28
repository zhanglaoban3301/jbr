/**
 * @author : zxw
 * @date : 2022-09-26 17:18
 * @version : 1.0
 **/
package com.jbr.controller;

import com.jbr.domain.entity.Img;
import com.jbr.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImgController {
    @Autowired
    private ImgService imgService;
    @GetMapping("/getimgs")
    public List<Img> getImgs(){
        return imgService.getImgs();
    }

    @GetMapping("/deleteimgs")
    public Integer deleteImgs(){
        return imgService.deleteImg();
    }
    @GetMapping("/insertimgs")
    public Integer insertImg(String src){
        return imgService.insertImg(src);
    }
}
