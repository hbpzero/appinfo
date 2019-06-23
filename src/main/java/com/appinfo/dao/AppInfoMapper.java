package com.appinfo.dao;

import com.appinfo.pojo.AppCategory;
import com.appinfo.pojo.AppInfo;
import com.appinfo.pojo.AppVersion;
import com.appinfo.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapper {
    //查询符合条件1页的app信息
    public List<AppInfo> findAppInfoByPage(@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize,
                                           @Param("appName") String appName,@Param("status") Integer status,@Param("flatformId") Integer flatformId,
                                           @Param("level1") Integer level1,@Param("level2") Integer level2,@Param("level3") Integer level3,@Param("devId") Integer devId);
    //获取符合查询条件的结果数量
    public int getAppInfoCount(@Param("appName") String appName,@Param("status") Integer status,@Param("flatformId") Integer flatformId,
                               @Param("level1") Integer level1,@Param("level2") Integer level2,@Param("level3") Integer level3,@Param("devId") Integer devId);
    //查找分类名和相对应的ID
    public List<AppCategory> findCategoryInfo();
    //查找所有状态列表及相应的id
    public List<DataDictionary> findDictionary();
    //查找版本号和其对应的ID
    public List<AppVersion> findVersion();
    //通过apk的名称查询是否存在
    public int findApkName(@Param("APKName") String apkName);
    //新增app信息
    public int addAppInfo(@Param("softwareName") String softwareName,@Param("APKName") String APKName,
                          @Param("supportROM") String supportROM,@Param("interfaceLanguage") String interfaceLanguage,
                          @Param("softwareSize") double softwareSize,@Param("devId") Integer devId,
                          @Param("appInfo") String appInfo, @Param("status") Integer status,
                          @Param("flatformId") Integer flatformId,@Param("categoryLevel3")Integer categoryLevel3,
                          @Param("categoryLevel2")Integer categoryLevel2, @Param("categoryLevel1")Integer categoryLevel1,
                          @Param("downloads") Integer downloads,
                          @Param("logoPicPath")String logoPicPath,@Param("logoLocPath")String logoLocPath);
    //通过ID查找app信息
    public AppInfo findAppById(@Param("id") Integer id);
    //修改对应的ID的app信息
    public int modifysave(@Param("id") Integer id,@Param("devUser") Integer userId,
                          @Param("softwareName") String softwareName,@Param("supportROM") String supportROM,
                          @Param("interfaceLanguage") String interfaceLanguage, @Param("softwareSize") double softwareSize,
                          @Param("appInfo") String appInfo,@Param("flatformId") Integer flatformId,
                          @Param("categoryLevel3")Integer categoryLevel3, @Param("categoryLevel2")Integer categoryLevel2,
                          @Param("categoryLevel1")Integer categoryLevel1, @Param("downloads") Integer downloads,
                          @Param("logoPicPath")String logoPicPath,@Param("logoLocPath") String logoLocPath,
                          @Param("status")Integer status);
    //获取app的上下架状态
    public int getSaleStatus(@Param("id") Integer id);
    //切换上下架的状态
    public int switchSale(@Param("id") Integer id,@Param("status") Integer status);
    //删除logo路径
    public int delPic(@Param("id") Integer id);
    //查询对应app最新的版本号
    public int findNewestVersion(@Param("id") Integer id);
    //插入新版本的id到信息表中
    public int setNewVersionId(@Param("id") Integer id,@Param("versionId") Integer versionId);


    public  AppInfo QueryAppInfoById(@Param("id")Integer id );
    //数据字典查找
    public  String findPlatformOrStatus(@Param("id")Integer id,@Param("type")String type);
    public  String findCategory(@Param("id")Integer id);
    public  int appDelete(@Param("id")Integer id);

}
