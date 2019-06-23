package com.appinfo.dao;

import com.appinfo.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppVersionMapper {
        public List<AppVersion>  QueryAppversionByappId(AppVersion appVersion);
        public  String findVersionStatus(@Param("id") Integer id);
        public AppVersion QueryLatestAppversionByappId(@Param("id") Integer id);
        public  int  versionAdd(AppVersion appVersion);
        public int versionUpdate(AppVersion appVersion);
        public int appveriosnDelete(@Param("appId") Integer appId);
}
