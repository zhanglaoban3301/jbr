package com.jbr.service;

import com.jbr.domain.entity.Global;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zxw
 */

public interface GlobalService {
    /**
     * 获取全局变量
     * @return
     */
    List<Global> getGlobal();
}
