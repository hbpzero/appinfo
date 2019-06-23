package com.appinfo.dao;


import com.appinfo.pojo.BackendAppInfo;
import com.appinfo.pojo.BackendUser;
import com.appinfo.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BackendAppInfoMapper {

    //前后台登陆
     DevUser login(@Param("devCode") String devCode, @Param("devPassword") String devPassword);
    BackendUser backendLogin(@Param("userCode") String userCode, @Param("userPassword") String userPassword);
    //展示列表
    List<BackendAppInfo> getAppList(@Param("softwareName") String softwareName,
                                    @Param("flatformId") Integer flatformId,
                                    @Param("categoryLevel1") Integer categoryLevel1,
                                    @Param("categoryLevel2") Integer categoryLevel2,
                                    @Param("categoryLevel3") Integer categoryLevel3,
                                    @Param("startRow") Integer startRow,
                                    @Param("pageSize") Integer pageSize
    );
    Integer getAppCount(@Param("softwareName") String softwareName,
                        @Param("flatformId") Integer flatformId,
                        @Param("categoryLevel1") Integer categoryLevel1,
                        @Param("categoryLevel2") Integer categoryLevel2,
                        @Param("categoryLevel3") Integer categoryLevel3);
    //点击审核键显示app信息
    BackendAppInfo getAppById(@Param("id") Integer appId);
    //审核app
    Integer updataAppInfo(@Param("id") Integer id, @Param("status") Integer status);
    //获取第一分类
    List<BackendAppInfo> findL1list();
    //获取第二分类
    List<BackendAppInfo> findL2list();
    //获取第三分类
    List<BackendAppInfo> findL3list();
    //获取平台属性
    List<BackendAppInfo> findflatformList();
}
