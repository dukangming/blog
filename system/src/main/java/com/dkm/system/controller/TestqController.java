package com.dkm.system.controller;

import com.dkm.system.domain.Test;
import com.dkm.system.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dkm
 * @create 2020-08-03 11:28
 */

@RestController
public class TestqController {
    @Resource
    private TestService testService;

    @RequestMapping("/test222")
    public List<Test> test() {
        return testService.list();
    }
}
