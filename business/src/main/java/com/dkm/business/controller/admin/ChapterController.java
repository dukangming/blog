package com.dkm.business.controller.admin;

import com.dkm.server.dto.ChapterDto;
import com.dkm.server.dto.PageDto;
import com.dkm.server.dto.ResponseDto;
import com.dkm.server.service.ChapterService;
import com.dkm.server.util.UuidUtil;
import com.dkm.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author dkm
 * @create 2020-08-03 9:54
 */

@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    private static final Logger LOG = LoggerFactory.getLogger(ChapterController.class);
    public static final String BUSINESS_NAME = "大章";

    @Autowired
    public ChapterService chapterService;
//@RequestBody接收json
    @PostMapping(value="/list",produces= {"application/json;charset=UTF-8"})
    public ResponseDto chapter(@RequestBody PageDto pageDto) {
        LOG.info("pageDto:{}",pageDto);
        ResponseDto responseDto = new ResponseDto();
        chapterService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping(value="/save",produces= {"application/json;charset=UTF-8"})
    public ResponseDto save(@RequestBody ChapterDto chapterDto) {

        // 保存校验
        ValidatorUtil.require(chapterDto.getName(), "名称");
        ValidatorUtil.require(chapterDto.getCourseId(), "课程ID");
        ValidatorUtil.length(chapterDto.getCourseId(), "课程ID", 1, 8);


        ResponseDto responseDto = new ResponseDto();
        chapterService.save(chapterDto);
        responseDto.setContent(chapterDto);
        return responseDto;
    }

    @DeleteMapping(value="/delete/{id}",produces= {"application/json;charset=UTF-8"})
    public ResponseDto save(@PathVariable String id) {
        LOG.info("id:{}",id);
        ResponseDto responseDto = new ResponseDto();
        chapterService.delete(id);
        return responseDto;
    }
}
