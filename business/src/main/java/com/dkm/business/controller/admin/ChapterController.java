package com.dkm.business.controller.admin;

import com.dkm.server.dto.PageDto;
import com.dkm.server.service.ChapterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dkm
 * @create 2020-08-03 9:54
 */

@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    private static final Logger LOG = LoggerFactory.getLogger(ChapterController.class);

    @Autowired
    public ChapterService chapterService;
//@RequestBody接收json
    @RequestMapping(value="/list",produces= {"application/json;charset=UTF-8"})
    public PageDto chapter(@RequestBody PageDto pageDto) {
        LOG.info("pageDto:{}",pageDto);
        chapterService.list(pageDto);
        return pageDto;
    }
}
