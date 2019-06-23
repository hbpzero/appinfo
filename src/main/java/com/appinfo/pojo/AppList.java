package com.appinfo.pojo;

public class AppList {
    private String softwareName;
    private String apkName;
    private  double softwareSize;
    private String categoryLevel1Name;
    private String categoryLevel2Name;
    private String categoryLevel3Name;
    private Integer categoryLevel1;
    private Integer categoryLevel2;
    private Integer categoryLevel3;
    private String flatformName;
    private Integer flatformId;
    private String statusName;
    private String versionNo;
    private Integer id;
    private Integer downloads;
    private Integer status;
    private Integer versionId;
    private String logoPicPath;
    private String logoLocPath;
    private String supportROM;
    private String interfaceLanguage;
    private String appInfo;

    public AppList(){}
    public AppList(String softwareName, String apkName, double softwareSize, String categoryLevel1Name, String categoryLevel2Name, String categoryLevel3Name, String flatformName, String statusName, String versionNo, Integer id, Integer downloads, Integer status, Integer versionId, String logoPicPath, String logoLocPath,String supportROM,String interfaceLanguage,Integer flatformId,Integer categoryLevel1,Integer categoryLevel2,Integer categoryLevel3,String appInfo) {
        this.softwareName = softwareName;
        this.apkName = apkName;
        this.softwareSize = softwareSize;
        this.categoryLevel1Name = categoryLevel1Name;
        this.categoryLevel2Name = categoryLevel2Name;
        this.categoryLevel3Name = categoryLevel3Name;
        this.flatformName = flatformName;
        this.statusName = statusName;
        this.versionNo = versionNo;
        this.id = id;
        this.downloads = downloads;
        this.status = status;
        this.versionId = versionId;
        this.logoPicPath = logoPicPath;
        this.logoLocPath = logoLocPath;
        this.supportROM=supportROM;
        this.interfaceLanguage=interfaceLanguage;
        this.flatformId=flatformId;
        this.categoryLevel1=categoryLevel1;
        this.categoryLevel2=categoryLevel2;
        this.categoryLevel3=categoryLevel3;
        this.appInfo=appInfo;
    }

    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo;
    }

    public Integer getCategoryLevel1() {
        return categoryLevel1;
    }

    public void setCategoryLevel1(Integer categoryLevel1) {
        this.categoryLevel1 = categoryLevel1;
    }

    public Integer getCategoryLevel2() {
        return categoryLevel2;
    }

    public void setCategoryLevel2(Integer categoryLevel2) {
        this.categoryLevel2 = categoryLevel2;
    }

    public Integer getCategoryLevel3() {
        return categoryLevel3;
    }

    public void setCategoryLevel3(Integer categoryLevel3) {
        this.categoryLevel3 = categoryLevel3;
    }

    public Integer getFlatformId() {
        return flatformId;
    }

    public void setFlatformId(Integer flatformId) {
        this.flatformId = flatformId;
    }

    public String getInterfaceLanguage() {
        return interfaceLanguage;
    }

    public void setInterfaceLanguage(String interfaceLanguage) {
        this.interfaceLanguage = interfaceLanguage;
    }

    public String getSupportROM() {
        return supportROM;
    }

    public void setSupportROM(String supportROM) {
        this.supportROM = supportROM;
    }

    public String getLogoPicPath() {
        return logoPicPath;
    }

    public void setLogoPicPath(String logoPicPath) {
        this.logoPicPath = logoPicPath;
    }

    public String getLogoLocPath() {
        return logoLocPath;
    }

    public void setLogoLocPath(String logoLocPath) {
        this.logoLocPath = logoLocPath;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFlatformName() {
        return flatformName;
    }

    public void setFlatformName(String flatformName) {
        this.flatformName = flatformName;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getApkName() {
        return apkName;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName;
    }

    public double getSoftwareSize() {
        return softwareSize;
    }

    public void setSoftwareSize(double softwareSize) {
        this.softwareSize = softwareSize;
    }

    public String getCategoryLevel1Name() {
        return categoryLevel1Name;
    }

    public void setCategoryLevel1Name(String categoryLevel1Name) {
        this.categoryLevel1Name = categoryLevel1Name;
    }

    public String getCategoryLevel2Name() {
        return categoryLevel2Name;
    }

    public void setCategoryLevel2Name(String categoryLevel2Name) {
        this.categoryLevel2Name = categoryLevel2Name;
    }

    public String getCategoryLevel3Name() {
        return categoryLevel3Name;
    }

    public void setCategoryLevel3Name(String categoryLevel3Name) {
        this.categoryLevel3Name = categoryLevel3Name;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }
}
