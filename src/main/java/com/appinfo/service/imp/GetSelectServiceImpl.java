package com.appinfo.service.imp;


import com.appinfo.dao.BackendAppInfoMapper;
import com.appinfo.pojo.BackendAppInfo;
import com.appinfo.service.GetSelectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GetSelectServiceImpl implements GetSelectService {
    @Resource
    private BackendAppInfoMapper backendAppInfoMapper;
    @Override
    //获取平台属性
    public List<BackendAppInfo> getflatformList(){

        return backendAppInfoMapper.findflatformList();
    }
    @Override
    //获取第一级分类
    public List<BackendAppInfo> getL1List(){

        return backendAppInfoMapper.findL1list();
    }
    @Override
    //获取第二季分类
    public List<BackendAppInfo> getL2List(){

        return backendAppInfoMapper.findL2list();
    }
    @Override
    //获取第三级分类
    public List<BackendAppInfo> getL3List() {

        return backendAppInfoMapper.findL3list();
    }
}
