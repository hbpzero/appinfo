package com.appinfo.controller;


import com.appinfo.pojo.BackendAppInfo;
import com.appinfo.pojo.BackendUser;
import com.appinfo.service.BackendAppInfoService;
import com.appinfo.util.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/app")
public class BackendAppInfoController {
    @Resource
    private BackendAppInfoService backendAppInfoService;

    //app审核列表
    @RequestMapping(value = "/list.html")
    public String list(@RequestParam(value = "querySoftwareName",required = false) String softwareName,
                       @RequestParam(value = "queryFlatformId",required = false)Integer flatformId,
                       @RequestParam(value = "queryCategoryLevel1",required = false)Integer categoryLevel1,
                       @RequestParam(value = "queryCategoryLevel2",required = false)Integer categoryLevel2,
                       @RequestParam(value = "queryCategoryLevel3",required = false)Integer categoryLevel3,
                       @RequestParam(value = "pageIndex",required = false,defaultValue = "1")Integer pageIndex,
                       @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize, Model model){

        PageSupport<BackendAppInfo> pageSupport = backendAppInfoService.findAppInfoByPage(softwareName, flatformId,categoryLevel1,
                categoryLevel2,categoryLevel3, pageIndex, pageSize);
        model.addAttribute("pageSupport",pageSupport);
        return "backend/applist";
    }

    //点击审核查看App信息
    @RequestMapping(value = "/checkApp.html/{appinfoid}")
    public String viewApp(@PathVariable(value ="appinfoid")Integer appinfoid, Model model, HttpServletRequest request, HttpSession session){
        //验证登陆
        BackendUser currentLoginUser = (BackendUser) session.getAttribute("backendUser");
        if (currentLoginUser==null){
            request.setAttribute("message","请先登录！");
            //跳转登录页面
            return "backendlogin";
        }
        //根据ID查看app属性
        BackendAppInfo backendAppInfo=backendAppInfoService.findAppById(appinfoid);
        model.addAttribute("backendAppInfo",backendAppInfo);
        return "backend/appcheck";
    }

    //通过点击审核通过或不通过获取ID和status修改数据库
    @RequestMapping(value = "/checksave.html")
    public String saveApp(@RequestParam(value = "id")Integer id,
                          @RequestParam(value = "status")Integer status,
                          HttpServletRequest request, HttpSession session){
        //验证登陆
        BackendUser currentLoginUser = (BackendUser) session.getAttribute("backendUser");

        if (currentLoginUser==null){
            request.setAttribute("message","请先登录！");
            //跳转登录页面
            return "backendlogin";
        }

        Integer count = backendAppInfoService.updataAppInfo(id,status);
        if(count>0){
            return "redirect:/app/list.html";}
        request.setAttribute("message","审核失败！");
        return "backend/appcheck";
    }
}
