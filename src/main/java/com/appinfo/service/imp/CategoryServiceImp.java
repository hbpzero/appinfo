package com.appinfo.service.imp;

import com.appinfo.dao.CategoryMapper;
import com.appinfo.pojo.AppCategory;
import com.appinfo.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CategoryServiceImp implements CategoryService {
    @Resource
    CategoryMapper categoryMapper;

    @Override
    public List<AppCategory> findlevel1() {
        return categoryMapper.findLevel1();
    }

    @Override
    public List<AppCategory> findlevel2(Integer level1) {
        return categoryMapper.findLevel2(level1);
    }

    @Override
    public List<AppCategory> findlevel3(Integer level2) {
        return categoryMapper.findLevel3(level2);
    }

    @Override
    public AppCategory findLevelById(Integer id) {
        return categoryMapper.findLevelByid(id);
    }
}
