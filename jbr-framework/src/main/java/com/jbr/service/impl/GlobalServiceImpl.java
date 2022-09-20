/**
 * @author : zxw
 * @date : 2022-09-20 14:52
 * @version : 1.0
 **/
package com.jbr.service.impl;

import com.jbr.domain.entity.Global;
import com.jbr.mapper.GlobalMapper;
import com.jbr.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlobalServiceImpl implements GlobalService {
    @Autowired
    private GlobalMapper globalMapper;
    @Override
    public List<Global> getGlobal() {
        return globalMapper.getGlobal();
    }
}
