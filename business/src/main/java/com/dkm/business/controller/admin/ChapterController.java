package com.dkm.business.controller.admin;

import com.dkm.server.domain.Chapter;
import com.dkm.server.dto.ChapterDto;
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
@RequestMapping("/admin")
public class ChapterController {

    @Autowired
    public ChapterService chapterService;

    @RequestMapping(value="/chapter",produces= {"application/json;charset=UTF-8"})
    public List<ChapterDto> chapter() {
        return chapterService.list();
    }
}
