package com.dkm.system.controller;

import com.dkm.server.domain.Test;
import com.dkm.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dkm
 * @create 2020-08-03 9:54
 */

@RestController
public class TestController {

    @Autowired
    public TestService testService;

    @RequestMapping(value="/test",produces= {"application/json;charset=UTF-8"})
    public List<Test> test() {
        return testService.list();
    }

    @RequestMapping("/test2")
    public String test2() {
        return "666";
    }
}
