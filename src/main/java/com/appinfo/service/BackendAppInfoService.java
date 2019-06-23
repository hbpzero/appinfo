package com.appinfo.service;


import com.appinfo.pojo.BackendAppInfo;
import com.appinfo.util.PageSupport;

public interface BackendAppInfoService {
    PageSupport<BackendAppInfo> findAppInfoByPage(String SoftwareName,
                                                  Integer FlatformId,
                                                  Integer CategoryLevel,
                                                  Integer CategoryLeve2,
                                                  Integer CategoryLeve3,
                                                  Integer pageIndex, Integer pageSize);
    BackendAppInfo findAppById(Integer appId);

    Integer updataAppInfo(Integer id, Integer status);
}
