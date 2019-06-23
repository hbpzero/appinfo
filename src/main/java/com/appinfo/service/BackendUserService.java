package com.appinfo.service;


import com.appinfo.pojo.BackendUser;

public interface BackendUserService {

    BackendUser findBackendLoginUser(String userCode, String userPassword);
}
