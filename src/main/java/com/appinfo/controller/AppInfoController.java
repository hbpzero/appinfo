package com.appinfo.controller;

import com.appinfo.pojo.*;
import com.appinfo.service.AppInfoService;
import com.appinfo.service.UserService;
import com.appinfo.util.PageSupport;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping(value = "/app")
public class AppInfoController {
    @Resource
    AppInfoService appInfoService;
    @Resource
    UserService userService;
    //查询app信息并跳转到app信息列表界面
    @RequestMapping(value = "/list")
    public String applist(@RequestParam(value = "queryCategoryLevel1",required = false) Integer queryCategoryLevel1,
                          @RequestParam(value = "queryCategoryLevel2",required = false) Integer queryCategoryLevel2,
                          @RequestParam(value = "queryCategoryLevel3",required = false) Integer queryCategoryLevel3,
                          @RequestParam(value = "queryFlatformId",required = false) Integer queryFlatformId,
                          @RequestParam(value = "queryStatus",required = false) Integer queryStatus,
                          @RequestParam(value = "querySoftwareName",required = false) String querySoftwareName,
                          @RequestParam(value = "pageIndex",required = false,defaultValue = "1")Integer pageIndex,
                          @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize, Model model,
                          HttpServletRequest request, HttpSession session
                          ){
        DevUser devUser=(DevUser)session.getAttribute("devuser");
        if (devUser==null){//验证是否登录了
            request.setAttribute("message","请先登陆");
            return "devlogin";
        }
        Integer devId=devUser.getId();//获取用户ID
        //获取分类查询中需要的相关数据
        List<DataDictionary> dataDictionaries=appInfoService.findDictionary();
        List<AppCategory> appCategory=appInfoService.findCategoryInfo();
        //查询一页量的app信息，默认一页10行
        PageSupport<AppList> pageSupport=appInfoService.findAppInfobypage(pageIndex,pageSize,querySoftwareName,queryStatus,
                queryFlatformId,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3,devId);
        model=getListResource(dataDictionaries,appCategory,model);
        //将页面查询部分需要的资源传到前端
        model.addAttribute("pages",pageSupport);
        model.addAttribute("appInfoList",pageSupport.getList());
        return "developer/appinfolist";
    }

    //跳转到新增app基础信息页面
    @RequestMapping(value = "/addnewapp")
    public String addapp(Model model,HttpServletRequest request, HttpSession session){
        DevUser devUser=(DevUser)session.getAttribute("devuser");
        if (devUser==null){//判断是否登录了
            request.setAttribute("message","请先登陆");
            return "devlogin";
        }
        return "developer/appinfoadd";
    }

    //验证apk名是否存在
    @RequestMapping(value = "/findapkname")
    @ResponseBody
    public Object findapkname(@RequestParam("apkName") String apkName){
        Map<String,Object> json=new HashMap<>();
        if (apkName==null || apkName==""){
            json.put("APKName","empty");
            return json;
        }else {
            int result=appInfoService.findApkName(apkName);
            if (result==0)
                json.put("APKName","noexist");
            else if (result ==1)
                json.put("APKName","exist");
            return json;
        }

    }

    //执行新增app信息并上传logo到upload文件夹中
    @RequestMapping(value = "/addappInfo")
    public String addAppInfo(@RequestParam("softwareName") String softwareName,@RequestParam("apkName") String apkName,
                             @RequestParam("supportROM") String supportROM,@RequestParam("interfaceLanguage") String interfaceLanguage,
                             @RequestParam("softwareSize") double softwareSize,@RequestParam("downloads") Integer downloads,
                             @RequestParam("flatformId") Integer flatformId,@RequestParam("categoryLevel1") Integer categoryLevel1,
                             @RequestParam("categoryLevel2") Integer categoryLevel2,@RequestParam("categoryLevel3") Integer categoryLevel3,
                             @RequestParam("status") Integer status,@RequestParam("appInfo") String appInfo,
                             @RequestParam(value = "a_logoPicPath",required = false) MultipartFile multipartFile,
                             HttpServletRequest request, HttpSession session){
            String logicPath="";//存放相对路径
            String localPath="";//存放绝对路径
            DevUser devUser=(DevUser)session.getAttribute("devuser");
            if (!multipartFile.isEmpty()){//存在文件
                String path=session.getServletContext().getRealPath(File.separator+"statics"+File.separator+"upload"+File.separator);//根据相对路径获取绝对路径
                File rootpath=new File(path);
                rootpath.mkdirs();//创建绝对路径

                if (multipartFile.getSize()>5000*1024){//判断图片 大小
                    request.setAttribute("message","上传的文件应小于5MB！");
                    return "developer/appinfoadd";
                }

                String filename=multipartFile.getOriginalFilename();//获取文件名
                String suffix= FilenameUtils.getExtension(filename);//获取文件后缀

                if(!"jpg".equals(suffix) && !"png".equals(suffix) && !"bmp".equals(suffix) && !"gif".equals(suffix)&& !"jpeg".equals(suffix)){//判断文件格式
                    request.setAttribute("message","文件格式不正确！");
                    return "developer/appinfoadd";
                }

                String newFileName= UUID.randomUUID().toString().replace("-","");//使用唯一识别码作为文件名
                File resultFile=new File(rootpath,newFileName+"."+suffix);//绝对路径+文件名+点+后缀
                logicPath=File.separator+"statics"+File.separator+"upload"+File.separator+newFileName+"."+suffix;//相对路径
                try {
                    multipartFile.transferTo(resultFile);//保存文件
                } catch (IOException e) {
                    e.printStackTrace();
                }
                localPath=session.getServletContext().getRealPath(logicPath);//绝对路径

            }
            int result=appInfoService.addAppInfo(softwareName,apkName,supportROM,interfaceLanguage,softwareSize,devUser.getId(),appInfo,status,flatformId,categoryLevel3,
            categoryLevel2,categoryLevel1,downloads,logicPath,localPath);//新增app
             if (result>0){
                    request.setAttribute("message","增加成功");
                     return "redirect:/app/list";
             }
            else {
                 request.setAttribute("message","增加失败");
                return "developer/appinfoadd";
            }

    }

    //获取对应id的app信息并跳转到修改界面
    @RequestMapping(value = "/appinfomodify")
    public String modifyapp(@RequestParam("id")Integer id,Model model, HttpServletRequest request, HttpSession session){
        DevUser devUser=(DevUser)session.getAttribute("devuser");
        if (devUser==null){//验证是否登录了
            request.setAttribute("message","请先登陆");
            return "devlogin";
        }
        List<DataDictionary> dataDictionaries=appInfoService.findDictionary();
        List<AppCategory> appCategory=appInfoService.findCategoryInfo();
        String levelname1="";
        String levelname2="";
        String levelname3="";
        String statusName="";
        String flatformName="";

        AppInfo appInfo=appInfoService.findAppById(id);
        for (int i=0;i<dataDictionaries.size();i++){//确认app信息中相对的状态名和平台名
            if (dataDictionaries.get(i).getTypeCode().equals("APP_STATUS")){
                if (dataDictionaries.get(i).getValueId()==appInfo.getStatus())
                    statusName=dataDictionaries.get(i).getValueName();
            }else if (dataDictionaries.get(i).getTypeCode().equals("APP_FLATFORM")){
                if (dataDictionaries.get(i).getValueId()==appInfo.getFlatformId())
                    flatformName=dataDictionaries.get(i).getValueName();
            }
        }
        for(int i=0;i<appCategory.size();i++){//获取app的三级分类名
            if (appCategory.get(i).getId()==appInfo.getCategoryLevel1()){
                levelname1=appCategory.get(i).getCategoryName();
            }else if (appCategory.get(i).getId()==appInfo.getCategoryLevel2()){
                levelname2=appCategory.get(i).getCategoryName();
            }else if (appCategory.get(i).getId()==appInfo.getCategoryLevel3()){
                levelname3=appCategory.get(i).getCategoryName();
            }
        }
        //将界面需要的相关信息存入到appList中
        AppList appList=new AppList(appInfo.getSoftwareName(),appInfo.getApkName(),appInfo.getSoftwareSize(),
                levelname1,levelname2,levelname3,flatformName,statusName,"",appInfo.getId(),appInfo.getDownloads(),
                appInfo.getStatus(),appInfo.getVersionId(),appInfo.getLogoPicPath(),appInfo.getLogoLocPath(),
                appInfo.getSupportROM(),appInfo.getInterfaceLanguage(),appInfo.getFlatformId(),appInfo.getCategoryLevel1(),
                appInfo.getCategoryLevel2(),appInfo.getCategoryLevel3(),appInfo.getAppInfo());
        //将applist传到前端
        model.addAttribute("appInfo",appList);

        return "developer/appinfomodify";
    }
    //修改app基础信息
    @RequestMapping(value = "/appinfomodifysave")
    public String appmodifysave(@RequestParam("softwareName") String softwareName, @RequestParam("supportROM") String supportROM,
                                @RequestParam("interfaceLanguage") String interfaceLanguage, @RequestParam("softwareSize") double softwareSize,
                                @RequestParam("downloads") Integer downloads, @RequestParam("flatformId") Integer flatformId,
                                @RequestParam("categoryLevel1") Integer categoryLevel1, @RequestParam("categoryLevel2") Integer categoryLevel2,
                                @RequestParam("categoryLevel3") Integer categoryLevel3, @RequestParam("appInfo") String appInfo,
                                @RequestParam("id")Integer id,@RequestParam(value = "status",required = false)Integer status,
                                @RequestParam(value = "attach",required = false) MultipartFile multipartFile,
                                HttpServletRequest request, HttpSession session,Model model){
        DevUser devUser=(DevUser) session.getAttribute("devuser");
        String logicPath="";//新的相对路径
        String localPath="";//新的绝对路径
        if (devUser==null){//验证是否登录了
            request.setAttribute("message","请先登陆");
            return "devlogin";
        }
        int userId=devUser.getId();
        int result=0;
        if (!multipartFile.isEmpty()){//存在文件，进行上传操作
            String path=session.getServletContext().getRealPath(File.separator+"statics"+File.separator+"upload"+File.separator);//根据相对路径获取绝对路径
            File rootpath=new File(path);
            rootpath.mkdirs();//创建绝对路径
            if (multipartFile.getSize()>5000*1024){//判断图片 大小
                model.addAttribute("message","上传的文件应小于5MB！");
                return "developer/appinfomodify";
            }
            String filename=multipartFile.getOriginalFilename();//获取文件名
            String suffix= FilenameUtils.getExtension(filename);//获取文件后缀
            if(!"jpg".equals(suffix) && !"png".equals(suffix) && !"bmp".equals(suffix) && !"gif".equals(suffix)&& !"jpeg".equals(suffix)){//判断文件格式
                model.addAttribute("message","文件格式不正确！");
                return "developer/appinfomodify";
            }
            String newFileName= UUID.randomUUID().toString().replace("-","");//使用唯一识别码作为文件名
            File resultFile=new File(rootpath,newFileName+"."+suffix);//绝对路径+文件名+点+后缀
            logicPath=File.separator+"statics"+File.separator+"upload"+File.separator+newFileName+"."+suffix;//相对路径
            try {
                multipartFile.transferTo(resultFile);//保存文件
            } catch (IOException e) {
                e.printStackTrace();
            }
            localPath=session.getServletContext().getRealPath(logicPath);//绝对路径

        }
        if (status!=null)//判断是以什么状态修改基础信息，若是未通过审核的状态则需要修改状态
            result=appInfoService.modifyapp(id,userId,softwareName,supportROM,interfaceLanguage,softwareSize
                    ,appInfo,flatformId,categoryLevel3,categoryLevel2,categoryLevel1,downloads,logicPath,localPath,status);
        else
            result=appInfoService.modifyapp(id,userId,softwareName,supportROM,interfaceLanguage,softwareSize
                    ,appInfo,flatformId,categoryLevel3,categoryLevel2,categoryLevel1,downloads,logicPath,localPath,0);
        if(result>0){//判断修改结果
            model.addAttribute("message","修改成功");
            return  "redirect:/app/list";
        }else {
            model.addAttribute("message","修改失败");
            return  "developer/appinfomodify";
        }

    }
    //切换上架下架状态
    @RequestMapping(value = "/sale")
    @ResponseBody
    public Object swithchSale(@RequestParam("appId") Integer id,HttpServletRequest request, HttpSession session){
        DevUser devUser=(DevUser)session.getAttribute("devuser");
        if (devUser==null){//验证登录
            request.setAttribute("message","请先登陆");
            return "devlogin";
        }
        int status=appInfoService.getAppStatus(id);//获取APP当前的状态
        int result=0;
        Map<String,Object> json=new HashMap<>();
        if (status==4){//已上架切换成已下架
            result=appInfoService.switchSale(id,5);
        }else if (status==5 || status ==2){//已下架或审核成功切换成已上架
            result=appInfoService.switchSale(id,4);
        }
        if (result>0){
            json.put("errorCode","0");
            json.put("resultMsg","success");
        }else {
            json.put("errorCode","0");
            json.put("resultMsg","failed");
        }
        return json;
    }

    //删除路径
    @RequestMapping(value = "/delpic")
    @ResponseBody
    public Object delPic(@RequestParam("id") Integer id){
        Map<Object,String>json=new HashMap<Object, String>();
        int result=appInfoService.delPic(id);
        if (result>0){
            json.put("result","success");
        }else {
            json.put("result","failed");
        }
        return json;
    }
    //获取查询界面需要相应的分类表
    public Model getListResource(List<DataDictionary> dataDictionaries,List<AppCategory> appCategory,Model model){

        List<DataDictionary> flatFormList=new ArrayList<DataDictionary>();
        List<DataDictionary> statusList=new ArrayList<DataDictionary>();
        List<AppCategory> categoryLevel1List=new ArrayList<AppCategory>();
        for (int i=0;i<dataDictionaries.size();i++){
            if (dataDictionaries.get(i).getTypeCode().equals("APP_FLATFORM"))
                flatFormList.add(dataDictionaries.get(i));
            else if (dataDictionaries.get(i).getTypeCode().equals("APP_STATUS"))
                statusList.add(dataDictionaries.get(i));
        }
        for (int i=0;i<appCategory.size();i++){
            if (appCategory.get(i).getParentId()==null)
                categoryLevel1List.add(appCategory.get(i));
        }
        model.addAttribute("flatFormList",flatFormList);
        model.addAttribute("statusList",statusList);
        model.addAttribute("categoryLevel1List",categoryLevel1List);
        return model;
    }


    //查询指定app的详细信息
    @RequestMapping("/appinfo")
    public String appinfo(@RequestParam("appinfoid")Integer id, Model model){

        //查询app的基础信息
        AppInfo appInfo =userService.QueryAppInfoById(id);
        userService.findCategory(appInfo);
        List<AppVersion> VersionList = new ArrayList<AppVersion>();

        //查询app的版本历史信息
        AppVersion appVersion=new AppVersion(id);
        VersionList = userService.QueryAppversionByappId(appVersion);
        for (AppVersion v:VersionList
        ) {
            userService.findVersionStatus(v);
        }
        //将相关信息传递到前端
        model.addAttribute("appInfo",appInfo);
        model.addAttribute("appVersionList",VersionList);
        return "developer/appinfoview";
    }

    //查询app的历史版本信息并跳转到新增版本界面
    @RequestMapping(value = "/version")
    public  String appversion(@RequestParam("id")Integer id, Model model,HttpSession devUserSession){

        AppVersion appVersion=new AppVersion(id);
        model.addAttribute("appId",id);
        List<AppVersion> VersionList = new ArrayList<AppVersion>();
        //查询指定app的历史版本信息
        VersionList = userService.QueryAppversionByappId(appVersion);
//        for (AppVersion v:VersionList) {
//            System.out.println(v);
//        }
        //将相关信息传递到前端
        model.addAttribute("appVersionList",VersionList);
        return "developer/appversionadd";
    }

    //app版本新增处理
    @RequestMapping(value = "/addversionsave")
    public String addversionsave(AppVersion appVersion,
                                 @RequestParam("file") MultipartFile multipartFile,HttpServletRequest request, HttpSession session,Model model) {
        //上传文件
        String path = session.getServletContext().getRealPath(File.separator + "statics" + File.separator + "upload" + File.separator);
        File rootPath = new File(path);
        rootPath.mkdirs();
        System.out.println("使用相对路径获绝对路径:" + path);
        String filename = multipartFile.getOriginalFilename();
        String suffix = FilenameUtils.getExtension(filename);
        String newFileName =multipartFile.getOriginalFilename();
        File saveFile = new File(rootPath, newFileName);
        if(!"apk".equals(suffix) ){//判断文件格式
            request.setAttribute("message","文件格式不正确！");
            return "developer/appinfoadd";
        }
        appVersion.setApkLocPath(File.separator+"statics"+File.separator+"upload"+File.separator+newFileName+"."+suffix);
        try {
            multipartFile.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/app/version";
        }
        //新增版本
        userService.versionAdd(appVersion);
        //查询新增后的最新版本号
        int newVersionId=appInfoService.findNewestVersion(appVersion.getAppId());
        //将新版本号加入到app表
        int result=appInfoService.setNewVersion(appVersion.getAppId(),newVersionId);
        if (result>0){
            request.setAttribute("message","上传成功");
        }
        return "redirect:/app/list";
    }
    //APP最新版本查看以编辑界面
    @RequestMapping(value = "/versionmodify")
    public  String appversionmodify(@RequestParam("aid") Integer aid, Model model,HttpSession devUserSession){
        AppVersion appVersion=new AppVersion(aid);
        List<AppVersion> VersionList = new ArrayList<AppVersion>();
        //查询指定id历史版本信息
        VersionList = userService.QueryAppversionByappId(appVersion);
//        for (AppVersion v:VersionList) {
//            userService.findVersionStatus(v);
//        }
        //查询指定id的最新版本信息
        appVersion=userService.QueryLatestAppversionByappId(aid);
        userService.findVersionStatus(appVersion);
        //传递相关数据到前端
        model.addAttribute("appVersionList",VersionList);
        model.addAttribute("appVersion",appVersion);
        return "developer/appversionmodify";
    }
    //APP最新版本编辑处理
    @RequestMapping(value = "/versionmodifysave")
    public  String  addversionsave(AppVersion appVersion,HttpServletRequest request){
        userService.versionUpdate(appVersion);
        return "redirect:/app/list";

    }
    //删除
    @RequestMapping(value = "/deleteapp")
    @ResponseBody
    public Object  deleteApp(@RequestParam(value = "id")Integer id){
        userService.deleteApp(id,id);
        Map<Object,String>json=new HashMap<Object, String>();
        json.put("delResult","true");
        return  json;
    }
}
