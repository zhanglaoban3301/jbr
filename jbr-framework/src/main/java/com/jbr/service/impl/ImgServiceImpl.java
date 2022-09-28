/**
 * @author : zxw
 * @date : 2022-09-26 16:49
 * @version : 1.0
 **/
package com.jbr.service.impl;

import com.jbr.domain.entity.Img;
import com.jbr.mapper.ImgMapper;
import com.jbr.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {
    @Autowired
    private ImgMapper imgMapper;
    @Override
    public List<Img> getImgs() {
        return imgMapper.getImgs();
    }

    @Override
    public Integer deleteImg() {
        return imgMapper.deleteimg();
    }

    @Override
    public Integer insertImg(String src) {
        return imgMapper.insertimg(src);
    }


}
