package com.appinfo.controller;

import com.appinfo.pojo.DataDictionary;
import com.appinfo.service.DataDictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/dataDictionary")
public class DataDictionaryController {
    @Resource
    DataDictionaryService dataDictionaryService;

    @RequestMapping(value = "/platform")
    @ResponseBody
    public Object getFlatform(){
        List<DataDictionary> flatform=dataDictionaryService.getFlatform();
        return flatform;
    }

}
