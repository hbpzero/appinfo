package com.appinfo.controller;

import com.appinfo.pojo.AppCategory;
import com.appinfo.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Resource
    CategoryService categoryService;
    @RequestMapping(value = "/getlevel1",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object getlevel1(){
        List<AppCategory> level1 =categoryService.findlevel1();
        return  level1;
    }
    @RequestMapping(value = "/getlevel2",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object getlevel2(@RequestParam(value = "queryCategoryLevel1") Integer level1){
        List<AppCategory> level2 =categoryService.findlevel2(level1);
        return  level2;
    }
    @RequestMapping(value = "/getlevel3",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object getlevel3(@RequestParam(value = "queryCategoryLevel2") Integer level2){
        List<AppCategory> level3 =categoryService.findlevel3(level2);
        return  level3;
    }
    @RequestMapping(value = "/loadName",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object findName(@RequestParam(value = "pid") Integer id){
        AppCategory appCategory =categoryService.findLevelById(id);
        return appCategory;
    }
}
