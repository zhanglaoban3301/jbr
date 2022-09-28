package com.jbr.service;

import com.jbr.domain.entity.Img;

import java.util.List;

/**
 * @author zxw
 */
public interface ImgService {
     List<Img> getImgs();
     Integer deleteImg();
     Integer insertImg(String src);
}
