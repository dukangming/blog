package com.dkm.server.service;

import com.dkm.server.domain.Section;
import com.dkm.server.domain.SectionExample;
import com.dkm.server.dto.SectionDto;
import com.dkm.server.dto.PageDto;
import com.dkm.server.enums.SectionChargeEnum;
import com.dkm.server.mapper.SectionMapper;
import com.dkm.server.util.CopyUtil;
import com.dkm.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * @author dkm
 * @create 2020-08-03 11:09
 */

@Service
public class SectionService {

    @Resource
    private SectionMapper sectionMapper;

    /**
     * 列表查询
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        SectionExample sectionExample = new SectionExample();
        sectionExample.setOrderByClause("sort asc");
        List<Section> sectionList = sectionMapper.selectByExample(sectionExample);
        PageInfo<Section> pageInfo = new PageInfo<>(sectionList);
        pageDto.setTotal(pageInfo.getTotal());
        List<SectionDto> sectionDtoList = CopyUtil.copyList(sectionList,SectionDto.class);
        pageDto.setList(sectionDtoList);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(SectionDto sectionDto) {
        Section section = new Section();
        BeanUtils.copyProperties(sectionDto,section);
        if (StringUtils.isEmpty(sectionDto.getId())) {
            this.insert(section);
        } else {
            this.update(section);
        }
    }

    /**
     * 新增
     */
    private void insert(Section section) {

        Date now = new Date();
        section.setCreatedAt(now);
        section.setUpdatedAt(now);


        section.setId(UuidUtil.getShortUuid());
        section.setCharge(SectionChargeEnum.CHARGE.getCode());

        sectionMapper.insert(section);
    }

    /**
     * 更新
     */
    private void update(Section section) {

        section.setUpdatedAt(new Date());
        sectionMapper.updateByPrimaryKey(section);
    }

    /**
     * 删除
     */
    public void delete(String id) {
        sectionMapper.deleteByPrimaryKey(id);
    }
}
