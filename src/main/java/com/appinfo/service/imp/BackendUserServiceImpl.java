package com.appinfo.service.imp;


import com.appinfo.dao.BackendAppInfoMapper;
import com.appinfo.pojo.BackendUser;
import com.appinfo.service.BackendUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BackendUserServiceImpl implements BackendUserService {

    @Resource
    private BackendAppInfoMapper backendAppInfoMapper;
    @Override
    public BackendUser findBackendLoginUser(String userCode, String userPassword) {


        //调用Dao查询数据库
        return backendAppInfoMapper.backendLogin(userCode,userPassword);

    }
}
