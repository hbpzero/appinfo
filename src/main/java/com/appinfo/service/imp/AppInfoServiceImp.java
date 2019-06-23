package com.appinfo.service.imp;

import com.appinfo.dao.AppInfoMapper;
import com.appinfo.pojo.*;
import com.appinfo.service.AppInfoService;
import com.appinfo.util.PageSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class AppInfoServiceImp implements AppInfoService {
    @Resource
    AppInfoMapper appInfoMapper;

    public PageSupport<AppList> findAppInfobypage(Integer pageIndex, Integer pageSize, String appName, Integer status, Integer flatformId, Integer level1, Integer level2, Integer level3,Integer devId) {
        List<AppList> appLists=new ArrayList<AppList>();

        PageSupport<AppList> pageSupport=new PageSupport<>();
        List<AppCategory> appCategorys=appInfoMapper.findCategoryInfo();
        List<AppVersion> appVersions=appInfoMapper.findVersion();
        List<DataDictionary> dataDictionaries=appInfoMapper.findDictionary();
        int totalCount=appInfoMapper.getAppInfoCount(appName,status,flatformId,level1,level2,level3,devId);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        pageSupport.setCurrentPageNo(pageIndex);
        if (totalCount>0){
            List<AppInfo> appInfos=appInfoMapper.findAppInfoByPage(pageSupport.getStartRow(),pageSize,appName,status,flatformId,level1,level2,level3,devId);

            for (int i=0;i<appInfos.size();i++){
                AppList appList=new AppList();
                appList.setApkName(appInfos.get(i).getApkName());
                appList.setDownloads(appInfos.get(i).getDownloads());
                appList.setId(appInfos.get(i).getId());
                appList.setSoftwareName(appInfos.get(i).getSoftwareName());
                appList.setSoftwareSize(appInfos.get(i).getSoftwareSize());
                appList.setStatusName(findStatusName(appInfos.get(i).getStatus(),dataDictionaries));
                appList.setCategoryLevel1Name(findLevelName(appInfos.get(i).getCategoryLevel1(),appCategorys));
                appList.setCategoryLevel2Name(findLevelName(appInfos.get(i).getCategoryLevel2(),appCategorys));
                appList.setCategoryLevel3Name(findLevelName(appInfos.get(i).getCategoryLevel3(),appCategorys));
                appList.setFlatformName(findFlatformName(appInfos.get(i).getFlatformId(),dataDictionaries));
                appList.setStatus(appInfos.get(i).getStatus());
                appList.setVersionId(appInfos.get(i).getVersionId());
                Integer a=appInfos.get(i).getVersionId();
                if (a!=null){
                    appList.setVersionNo(findVersionNo(a,appVersions));
                }
                appLists.add(i,appList);
            }
            pageSupport.setList(appLists);
        }
        return pageSupport;
    }

    @Override
    public List<AppCategory> findCategoryInfo() {
        return  appInfoMapper.findCategoryInfo();
    }


    @Override
    public List<DataDictionary> findDictionary() {
        return appInfoMapper.findDictionary();
    }

    public int findNewestVersion(Integer id){ return  appInfoMapper.findNewestVersion(id); }

    @Override
    public int setNewVersion(Integer id, Integer versionId) {
        return appInfoMapper.setNewVersionId(id,versionId);
    }

    @Override
    public int findApkName(String name) {
        return appInfoMapper.findApkName(name);
    }

    @Override
    public int addAppInfo(String softwareName, String APKName, String supportROM, String interfaceLanguage, double softwareSize, Integer devId, String appInfo, Integer status, Integer flatformId, Integer categoryLevel3, Integer categoryLevel2, Integer categoryLevel1, Integer downloads, String logoPicPath, String logoLocPath) {
        return appInfoMapper.addAppInfo(softwareName,APKName,supportROM,interfaceLanguage,softwareSize,devId,appInfo,status,flatformId,categoryLevel3,categoryLevel2,categoryLevel1,downloads,logoPicPath,logoLocPath);
    }

    @Override
    public AppInfo findAppById(Integer id) {
        return appInfoMapper.findAppById(id);
    }

    @Override
    public int modifyapp(Integer id, Integer userId, String softwareName, String supportROM, String interfaceLanguage, double softwareSize, String appInfo, Integer flatformId, Integer categoryLevel3, Integer categoryLevel2, Integer categoryLevel1, Integer downloads, String logoPicPath,String logoLocPath,Integer status) {
        return appInfoMapper.modifysave(id,userId,softwareName,supportROM,interfaceLanguage,softwareSize,appInfo,flatformId
        ,categoryLevel3,categoryLevel2,categoryLevel1,downloads,logoPicPath,logoLocPath,status);
    }

    @Override
    public int getAppStatus(Integer id) {
        return appInfoMapper.getSaleStatus(id);
    }

    @Override
    public int switchSale(Integer id, Integer status) {
        return appInfoMapper.switchSale(id,status);
    }

    @Override
    public int delPic(Integer id) {
        return appInfoMapper.delPic(id);
    }

    //通过所有的状态id与app信息中的状态id对比找到相应的状态名
    public String findStatusName(int a,List<DataDictionary> dataDictionaries){
        for (int b=0;b<dataDictionaries.size();b++){
            if (dataDictionaries.get(b).getTypeCode().equals("APP_STATUS")) {
                if (dataDictionaries.get(b).getValueId() == a)
                    return dataDictionaries.get(b).getValueName();
            }

        }
        return "";
    }
    //通过分类id与app信息中的分类等级id对比找出相应的三级分类名
    public String findLevelName(int id, List<AppCategory> appCategorys){
        for (int b=0;b<appCategorys.size();b++){
            if (appCategorys.get(b).getId()==id)
                return appCategorys.get(b).getCategoryName();
        }
        return "";
    }
    //通过所有平台id与app信息中的平台id对比找出对应的平台名
    public String findFlatformName(int flatFormId,List<DataDictionary> dataDictionaries) {
        for (int b = 0; b < dataDictionaries.size(); b++) {
            if (dataDictionaries.get(b).getTypeCode().equals("APP_FLATFORM")) {
                if (dataDictionaries.get(b).getValueId() == flatFormId)
                    return dataDictionaries.get(b).getValueName();
            }
        }
        return "";
    }
    //通过对比版本表中的id与app信息中的版本id对比找出对应的版本号
    public String findVersionNo(int versionId,List<AppVersion> appVersions) {
        for (int b = 0; b < appVersions.size(); b++) {
            if (appVersions.get(b).getId()==versionId) {
                return appVersions.get(b).getVersionNo();
            }
        }
        return "";
    }

}

