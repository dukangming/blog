package com.dkm.business.controller.admin;

import com.dkm.server.dto.CourseDto;
import com.dkm.server.dto.PageDto;
import com.dkm.server.dto.ResponseDto;
import com.dkm.server.service.CourseService;
import com.dkm.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @author dkm
 */

@RestController
@RequestMapping("/admin/course")
public class CourseController {

    private static final Logger LOG = LoggerFactory.getLogger(CourseController.class);
    public static final String BUSINESS_NAME = "课程";

    @Resource
    public CourseService courseService;
    //@RequestBody接收json 默认接收formdata

    /**
     * 列表查询
     */
    @PostMapping(value="/list",produces= {"application/json;charset=UTF-8"})
    public ResponseDto list(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
        courseService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    @PostMapping(value="/save",produces= {"application/json;charset=UTF-8"})
    public ResponseDto save(@RequestBody CourseDto courseDto) {
        // 保存校验
        ValidatorUtil.require(courseDto.getName(), "名称");
        ValidatorUtil.length(courseDto.getName(), "名称", 1, 50);
        ValidatorUtil.length(courseDto.getSummary(), "概述", 1, 2000);
        ValidatorUtil.length(courseDto.getImage(), "封面", 1, 100);

        ResponseDto responseDto = new ResponseDto();
        courseService.save(courseDto);
        responseDto.setContent(courseDto);
        return responseDto;
    }

    /**
     * 删除
     */
    @DeleteMapping(value="/delete/{id}",produces= {"application/json;charset=UTF-8"})
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        courseService.delete(id);
        return responseDto;
    }
}


