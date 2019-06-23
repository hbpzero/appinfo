package com.appinfo.pojo;

public class BackendAppInfo {

    private int id;
    private String softwareName;
    private String APKName;
    private float softwareSize;
    private Integer flatformId;
    private String	flatformName;//data_dictionary->app_flatform
    private Integer	categoryLevel1;
    private Integer  categoryLevel2;
    private Integer  categoryLevel3;
    private String	categoryLevel1Name;//app_category_>id
    private String  categoryLevel2Name;
    private String  categoryLevel3Name;
    private Integer status;
    private String	statusName;//data_dictionary->appstatus
    private Integer	downloads;
    private Integer versionId;
    private String	versionNo;//app_verson->id
    private String supportRom;
    private String interfaceLanguage;
    private String appInfo1;
    private String logoPicPath;
    private Integer versionSize;
    private String versionInfo;
    private String downloadLink;
    private String apkFileName;

    public String getSupportRom() {
        return supportRom;
    }

    public void setSupportRom(String supportRom) {
        this.supportRom = supportRom;
    }

    public String getInterfaceLanguage() {
        return interfaceLanguage;
    }

    public void setInterfaceLanguage(String interfaceLanguage) {
        this.interfaceLanguage = interfaceLanguage;
    }

    public String getAppInfo1() {
        return appInfo1;
    }

    public void setAppInfo(String appInfo1) {
        this.appInfo1 = appInfo1;
    }

    public String getLogoPicPath() {
        return logoPicPath;
    }

    public void setLogoPicPath(String logoPicPath) {
        this.logoPicPath = logoPicPath;
    }

    public Integer getVersionSize() {
        return versionSize;
    }

    public void setVersionSize(Integer versionSize) {
        this.versionSize = versionSize;
    }

    public String getVersionInfo() {
        return versionInfo;
    }

    public void setVersionInfo(String versionInfo) {
        this.versionInfo = versionInfo;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }
    public String getApkFileName() {
        return apkFileName;
    }

    public void setApkFileName(String apkFileName) {
        this.apkFileName = apkFileName;
    }

    public BackendAppInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getAPKName() {
        return APKName;
    }

    public void setAPKName(String APKName) {
        this.APKName = APKName;
    }

    public float getSoftwareSize() {
        return softwareSize;
    }

    public void setSoftwareSize(float softwareSize) {
        this.softwareSize = softwareSize;
    }

    public Integer getFlatformId() {
        return flatformId;
    }

    public void setFlatformId(Integer flatformId) {
        this.flatformId = flatformId;
    }

    public String getFlatformName() {
        return flatformName;
    }

    public void setFlatformName(String flatformName) {
        this.flatformName = flatformName;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "id=" + id +
                ", softwareName='" + softwareName + '\'' +
                ", APKName='" + APKName + '\'' +
                ", softwareSize=" + softwareSize +
                ", flatformId=" + flatformId +
                ", flatformName='" + flatformName + '\'' +
                ", categoryLevel1=" + categoryLevel1 +
                ", categoryLevel2=" + categoryLevel2 +
                ", categoryLevel3=" + categoryLevel3 +
                ", categoryLevel1Name='" + categoryLevel1Name + '\'' +
                ", categoryLevel2Name='" + categoryLevel2Name + '\'' +
                ", categoryLevel3Name='" + categoryLevel3Name + '\'' +
                ", status=" + status +
                ", statusName='" + statusName + '\'' +
                ", downloads=" + downloads +
                ", versionId=" + versionId +
                ", versionNo='" + versionNo + '\'' +
                ", supportRom='" + supportRom + '\'' +
                ", interfaceLanguage='" + interfaceLanguage + '\'' +
                ", appInfo='" + appInfo1 + '\'' +
                ", logoPicPath='" + logoPicPath + '\'' +
                ", versionSize=" + versionSize +
                ", versionInfo='" + versionInfo + '\'' +
                ", downloadLink='" + downloadLink + '\'' +

                ", apkFileName='" + apkFileName + '\'' +
                '}';
    }

    public BackendAppInfo(int id, String softwareName, String APKName, float softwareSize, Integer flatformId, String flatformName, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3, String categoryLevel1Name, String categoryLevel2Name, String categoryLevel3Name, Integer status, String statusName, Integer downloads, Integer versionId, String versionNo, String supportRom, String interfaceLanguage, String appInfo1, String logoPicPath, Integer versionSize, String versionInfo, String downloadLink,String apkFileName) {
        this.id = id;
        this.softwareName = softwareName;
        this.APKName = APKName;
        this.softwareSize = softwareSize;
        this.flatformId = flatformId;
        this.flatformName = flatformName;
        this.categoryLevel1 = categoryLevel1;
        this.categoryLevel2 = categoryLevel2;
        this.categoryLevel3 = categoryLevel3;
        this.categoryLevel1Name = categoryLevel1Name;
        this.categoryLevel2Name = categoryLevel2Name;
        this.categoryLevel3Name = categoryLevel3Name;
        this.status = status;
        this.statusName = statusName;
        this.downloads = downloads;
        this.versionId = versionId;
        this.versionNo = versionNo;
        this.supportRom = supportRom;
        this.interfaceLanguage = interfaceLanguage;
        this.appInfo1 = appInfo1;
        this.logoPicPath = logoPicPath;
        this.versionSize = versionSize;
        this.versionInfo = versionInfo;
        this.downloadLink = downloadLink;
        this.apkFileName=apkFileName;
    }
}
