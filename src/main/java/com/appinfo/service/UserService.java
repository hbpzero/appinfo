package com.appinfo.service;

import com.appinfo.dao.AppVersionMapper;
import com.appinfo.pojo.AppInfo;
import com.appinfo.pojo.AppVersion;

import java.util.List;

public interface UserService {

    List<AppVersion> QueryAppversionByappId(AppVersion version);
 //****************************************
   AppInfo QueryAppInfoById(Integer id);
   //Appinfo  Category,Status,Flatform
    void  findCategory(AppInfo appInfo);
    //Appversion Status
    void  findVersionStatus(AppVersion appVersion);
    AppVersion  QueryLatestAppversionByappId(Integer id);
    Integer versionAdd(AppVersion appVersion);
    Integer versionUpdate(AppVersion appVersion);
    void    deleteApp(Integer id, Integer appid);
    //*****************************************
}
