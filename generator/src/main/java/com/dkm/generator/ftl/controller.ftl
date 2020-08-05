package com.dkm.${module}.controller.admin;

import com.dkm.server.dto.${Domain}Dto;
import com.dkm.server.dto.PageDto;
import com.dkm.server.dto.ResponseDto;
import com.dkm.server.service.${Domain}Service;
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
@RequestMapping("/admin/${domain}")
public class ${Domain}Controller {

    private static final Logger LOG = LoggerFactory.getLogger(${Domain}Controller.class);
    public static final String BUSINESS_NAME = "${tableNameCn}";

    @Autowired
    public ${Domain}Service ${domain}Service;
    //@RequestBody接收json 默认接收formdata

    /**
     * 列表查询
     */
    @PostMapping(value="/list",produces= {"application/json;charset=UTF-8"})
    public ResponseDto ${domain}(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
        ${domain}Service.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    @PostMapping(value="/save",produces= {"application/json;charset=UTF-8"})
    public ResponseDto save(@RequestBody ${Domain}Dto ${domain}Dto) {

        // 保存校验


        ResponseDto responseDto = new ResponseDto();
        ${domain}Service.save(${domain}Dto);
        responseDto.setContent(${domain}Dto);
        return responseDto;
    }

    /**
     * 删除
     */
    @DeleteMapping(value="/delete/{id}",produces= {"application/json;charset=UTF-8"})
    public ResponseDto delete(@PathVariable String id) {
        LOG.info("id:{}",id);
        ResponseDto responseDto = new ResponseDto();
        ${domain}Service.delete(id);
        return responseDto;
    }
}
