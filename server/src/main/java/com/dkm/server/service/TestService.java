package com.dkm.server.service;

import com.dkm.server.domain.Test;
import com.dkm.server.domain.TestExample;
import com.dkm.server.mapper.TestMapper;
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

    public List<Test> list() {
        TestExample testExample = new TestExample();
        testExample.createCriteria().andIdEqualTo("11");
        testExample.setOrderByClause("id desc");
        return testMapper.selectByExample(testExample);
    }
}
