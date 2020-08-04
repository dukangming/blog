package com.dkm.business.controller;

import com.dkm.server.domain.Chapter;
import com.dkm.server.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dkm
 * @create 2020-08-03 9:54
 */

@RestController
public class ChapterController {

    @Autowired
    public ChapterService chapterService;

    @RequestMapping("/chapter")
    public List<Chapter> chapter() {
        return chapterService.list();
    }
}
