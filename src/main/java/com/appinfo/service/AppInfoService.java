package com.appinfo.service;

import com.appinfo.pojo.*;
import com.appinfo.util.PageSupport;

import java.util.List;

public interface AppInfoService  {
    //查询app信息，并把相关的信息放入到applist类中
    public PageSupport<AppList> findAppInfobypage(Integer pageIndex, Integer pageSize, String appName,
                                                  Integer status, Integer flatformId,
                                                  Integer level1, Integer level2, Integer level3,Integer devId);
    //查询分类的id和对应的名字
    public List<AppCategory>findCategoryInfo();
    //查询状态的id和类型和名字
    public List<DataDictionary>findDictionary();
    //通过apk名字查询是否存在
    public int findApkName(String name);
    //新增app信息
    public int addAppInfo(String softwareName,String APKName,
                          String supportROM,String interfaceLanguage,
                          double softwareSize,Integer devId,
                          String appInfo,Integer status,
                          Integer flatformId,Integer categoryLevel3,
                          Integer categoryLevel2,Integer categoryLevel1,
                          Integer downloads,
                          String logoPicPath,String logoLocPath);
    //通过id查询app信息
    public AppInfo findAppById(Integer id);
    //修改相应id的app信息
    public int modifyapp(Integer id,Integer userId, String softwareName, String supportROM,
                         String interfaceLanguage,double softwareSize, String appInfo,Integer flatformId,
                        Integer categoryLevel3, Integer categoryLevel2, Integer categoryLevel1, Integer downloads,
                         String logoPicPath,String logoLocPath,Integer status);
    //获取app的状态
    public int getAppStatus(Integer id);
    //切换上下架状态
    public int switchSale(Integer id,Integer status);
    //删除logo路径
    public int delPic(Integer id);
    //查询最新版本的id
    public int findNewestVersion(Integer id);
    //插入新版本id到app信息表
    public int setNewVersion(Integer id,Integer versionId);
}
