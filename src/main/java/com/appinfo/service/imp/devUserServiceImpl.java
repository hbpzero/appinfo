package com.appinfo.service.imp;


import com.appinfo.dao.BackendAppInfoMapper;
import com.appinfo.pojo.DevUser;
import com.appinfo.service.DevUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class devUserServiceImpl implements DevUserService {

    @Resource
    private BackendAppInfoMapper backendAppInfoMapper;

    @Override
    public DevUser findLoginUser(String devCode, String devPassword) {
        //获得连接对象

        try{
            //调用Dao查询数据库
            return backendAppInfoMapper.login(devCode,devPassword);
        }finally {

        }
    }
}
