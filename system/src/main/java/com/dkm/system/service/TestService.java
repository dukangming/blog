package com.dkm.system.service;

import com.dkm.system.domain.Test;
import com.dkm.system.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dkm
 * @create 2020-08-03 11:09
 */
@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public List<Test> list(){
        return testMapper.list();
    }
}
