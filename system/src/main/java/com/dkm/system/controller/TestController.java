package com.dkm.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dkm
 * @create 2020-08-03 9:54
 */

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "success";
    }
}
