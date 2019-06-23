package com.appinfo.service.imp;


import com.appinfo.dao.BackendAppInfoMapper;
import com.appinfo.pojo.BackendAppInfo;
import com.appinfo.service.BackendAppInfoService;
import com.appinfo.util.PageSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BackendAppInfoServiceImpl implements BackendAppInfoService {

    @Resource
    BackendAppInfoMapper backendAppInfoMapper;
    @Override
    public PageSupport<BackendAppInfo> findAppInfoByPage(String softwareName, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3, Integer pageIndex, Integer pageSize) {

        PageSupport<BackendAppInfo> pageSupport=new PageSupport<>();
        Integer totalCount = backendAppInfoMapper.getAppCount(softwareName,flatformId,categoryLevel1,categoryLevel2,categoryLevel3);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        pageSupport.setCurrentPageNo(pageIndex);

        if (totalCount>0){
            List<BackendAppInfo> list = backendAppInfoMapper.getAppList(softwareName,flatformId,categoryLevel1,categoryLevel2,categoryLevel3, pageSupport.getStartRow(), pageSize);
            pageSupport.setList(list);
        }
        return pageSupport;
    }




    @Override
    public BackendAppInfo findAppById(Integer appId){

        try{
            BackendAppInfo backendAppInfo = backendAppInfoMapper.getAppById(appId);
            return backendAppInfo;
        }finally {

        }

    }
    public Integer updataAppInfo(Integer id,Integer status){
        Integer count=1;
        count=backendAppInfoMapper.updataAppInfo(id,status);
        return count;
    }
}
