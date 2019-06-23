package com.appinfo.service;


import com.appinfo.pojo.DevUser;

public interface DevUserService {
    DevUser findLoginUser(String devCode, String devPassword);
}
