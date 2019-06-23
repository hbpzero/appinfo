package com.appinfo.controller;


import com.appinfo.pojo.BackendUser;
import com.appinfo.service.BackendUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/backend")
public class BackendUserController {
    @Resource
    private BackendUserService backendUserService;
    //跳转登陆页面
    @RequestMapping(value = "/login.html")
    public String Login(){return "backendlogin";}
    //跳转后台页面
    @RequestMapping(value = "/main.html")
    public String main(HttpSession session, HttpServletRequest request){
        //先验证登陆
        BackendUser currentLoginUser = (BackendUser) session.getAttribute("backendUser");
        if (currentLoginUser==null){
            request.setAttribute("message","请先登录！");
            //跳转登录页面
            return "backendlogin";
        }else{
        return "backend/main";}
    }
    //登陆
    @RequestMapping(value = "/doLogin.html")
    public String doLogin(@RequestParam(value = "userCode") String userCode,
                          @RequestParam(value = "userPassword") String userPassword,
                          HttpSession session, HttpServletRequest request){

        BackendUser backenduser = backendUserService.findBackendLoginUser(userCode,userPassword);

        if (backenduser!=null){
            //重定向后台主页
            session.setAttribute("backendUser",backenduser);
            return "redirect:/backend/main.html";
        }
        else {
            //密码错误时回到登陆页面
            request.setAttribute("message","用户名或密码不正确!");
            return "backendlogin";}


        //request.setAttribute("message","用户名或密码不正确!");
        //转发


    }

    //注销
    @RequestMapping(value = "/logout.html")
    public String logout( HttpSession session,HttpServletRequest request){
        session.invalidate();//会话失效
        request.setAttribute("message","注销成功!");
        return "backendlogin";
    }

}
