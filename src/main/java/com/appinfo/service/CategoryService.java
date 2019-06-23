package com.appinfo.service;

import com.appinfo.pojo.AppCategory;

import java.util.List;


public interface CategoryService {
    public List<AppCategory> findlevel1();
    public List<AppCategory> findlevel2(Integer level1);
    public List<AppCategory> findlevel3(Integer level2);
    public AppCategory findLevelById(Integer id);
}
