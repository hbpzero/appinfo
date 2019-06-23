package com.appinfo.controller;


import com.appinfo.pojo.BackendAppInfo;
import com.appinfo.service.GetSelectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/flatform")
public class GetSelectController {

    @Resource
    GetSelectService getSelectService;
    //属性列表
    @RequestMapping(value = "/getFlatformList.json", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object getflatformList() {
        List<BackendAppInfo> flatformlist = getSelectService.getflatformList();
        return flatformlist;
    }
    //一级分类列表
    @RequestMapping(value = "/getCL1List.json", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object getCL1List() {
        List<BackendAppInfo> CategoryLevel1 = getSelectService.getL1List();
        return CategoryLevel1;
    }
//二级分类
    @RequestMapping(value = "/getCL2List.json", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object getCL2List() {
        List<BackendAppInfo> CategoryLevel2 = getSelectService.getL2List();
        return CategoryLevel2;
    }
//三级分类
    @RequestMapping(value = "/getCL3List.json", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object getCL3List() {
        List<BackendAppInfo> CategoryLevel3 = getSelectService.getL3List();
        return CategoryLevel3;
    }

}
