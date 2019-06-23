package com.appinfo.dao;

import com.appinfo.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    public List<AppCategory> findLevel1();
    public List<AppCategory> findLevel2(@Param("level1")Integer level1);
    public List<AppCategory> findLevel3(@Param("level2")Integer level2);
    public AppCategory findLevelByid(@Param("id") Integer id);

}
