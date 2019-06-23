package com.appinfo.service;


import com.appinfo.pojo.BackendAppInfo;

import java.util.List;

public interface GetSelectService {
    //获取平台属性
    List<BackendAppInfo> getflatformList();
    //获取第一级分类
    List<BackendAppInfo> getL1List();
    //获取第二季分类
    List<BackendAppInfo> getL2List();
    //获取第三级分类
    List<BackendAppInfo> getL3List();

}
