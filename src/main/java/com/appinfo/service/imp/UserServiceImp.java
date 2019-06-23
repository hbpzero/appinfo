package com.appinfo.service.imp;

import com.appinfo.dao.AppInfoMapper;
import com.appinfo.dao.AppVersionMapper;
import com.appinfo.pojo.AppInfo;
import com.appinfo.pojo.AppVersion;
import com.appinfo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Resource
    AppInfoMapper appInfoMapper;
    @Resource
    AppVersionMapper appVersionMapper;



    /***********************************************
    * */
    @Override
    public List<AppVersion> QueryAppversionByappId(AppVersion version) {
        return  appVersionMapper.QueryAppversionByappId(version);
    }

    @Override
    public AppInfo QueryAppInfoById(Integer id) {
        return  appInfoMapper.QueryAppInfoById(id);

    }

    @Override
    public void findCategory(AppInfo appInfo) {
       appInfo.setCategoryLevel1Name(appInfoMapper.findCategory(appInfo.getCategoryLevel1()));
       appInfo.setCategoryLevel2Name(appInfoMapper.findCategory(appInfo.getCategoryLevel2()));
       appInfo.setCategoryLevel3Name(appInfoMapper.findCategory(appInfo.getCategoryLevel3()));
       //platform,status
        appInfo.setFlatformName(appInfoMapper.findPlatformOrStatus(appInfo.getFlatformId(),"所属平台"));
        appInfo.setStatusName(appInfoMapper.findPlatformOrStatus(appInfo.getStatus(),"APP状态"));
    }

    @Override
    public void findVersionStatus(AppVersion appVersion) {
         appVersion.setPublishStatusName(appVersionMapper.findVersionStatus(appVersion.getPublishStatus()));
    }

    @Override
    public AppVersion QueryLatestAppversionByappId(Integer id) {
        return appVersionMapper.QueryLatestAppversionByappId(id);
    }

    @Override
    public Integer versionAdd(AppVersion appVersion) {
         return appVersionMapper.versionAdd(appVersion);
    }

    @Override
    public Integer versionUpdate(AppVersion appVersion) {
        return  appVersionMapper.versionUpdate(appVersion);
    }

    @Override
    public void deleteApp(Integer id, Integer appid) {
        appInfoMapper.appDelete(id);
        appVersionMapper.appveriosnDelete(appid);
    }
  //****************************************************************************************************
}
