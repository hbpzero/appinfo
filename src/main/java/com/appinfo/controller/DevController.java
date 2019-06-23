package com.appinfo.controller;


import com.appinfo.pojo.DevUser;
import com.appinfo.service.DevUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/dev")
public class DevController {

    @Resource
    private DevUserService devuserservice;


    @RequestMapping(value = "/login.html")
    public String Login(){return "devlogin";}

    @RequestMapping(value = "/main.html")
    public String main(){
        return "developer/main";
    }


    @RequestMapping(value = "/doLogin.html")
    public String doLogin(@RequestParam(value = "devCode") String devCode,
                          @RequestParam(value = "devPassword") String devPassword,
                          HttpSession session, HttpServletRequest request){

        DevUser devuser = devuserservice.findLoginUser(devCode, devPassword);

        if (devuser!=null){
            //重定向主页
            session.setAttribute("devuser",devuser);
            return "redirect:/dev/main.html";
        }else {
            request.setAttribute("message","用户名或密码不正确!");
            return "devlogin";
        }



    }

    //局部异常处理
    //@ExceptionHandler
    public String handleException(Exception e, HttpServletRequest request){
        request.setAttribute("message",e.getMessage());
        return "devlogin";
    }


    @RequestMapping(value = "/logout.html")
    public String logout( HttpSession session,HttpServletRequest request){
        session.invalidate();//会话失效
        request.setAttribute("message","注销成功!");
        return "devlogin";
    }


}
