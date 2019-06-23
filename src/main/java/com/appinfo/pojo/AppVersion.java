package com.appinfo.pojo;

import java.util.Date;

public class AppVersion {
    private Integer id;
    private Integer appId;
    private String versionNo;
    private String versionInfo;
    private Integer publishStatus;
    private String downloadLink;
    private double versionSize;
    private Integer integercreatedBy;
    private Date creationDate;
    private Integer IntegermodifyBy;
    private Date modifyDate;
    private String apkLocPath;
    private String apkFileName;
    //新增
    private  String softwareName;
    private String publishStatusName;
    private String appInfo;



    public AppVersion() {
    }

    public AppVersion(String versionNo, Integer publishStatus, String downloadLink,String apkFileName, double versionSize, Date modifyDate, String softwareName) {
        this.versionNo = versionNo;
        this.publishStatus = publishStatus;
        this.downloadLink = downloadLink;
        this.apkFileName = apkFileName;
        this.versionSize = versionSize;
        this.modifyDate = modifyDate;
        this.softwareName = softwareName;
    }
    public AppVersion(String versionNo, Integer publishStatus, String appInfo,String downloadLink,String apkFileName, double versionSize, Date modifyDate, String softwareName) {
        this.versionNo = versionNo;
        this.appInfo=appInfo;
        this.publishStatus = publishStatus;
        this.downloadLink = downloadLink;
        this.apkFileName = apkFileName;
        this.versionSize = versionSize;
        this.modifyDate = modifyDate;
        this.softwareName = softwareName;
    }

    @Override
    public String toString() {
        return "AppVersion{" +
                "id=" + id +
                ", appId=" + appId +
                ", versionNo='" + versionNo + '\'' +
                ", versionInfo='" + versionInfo + '\'' +
                ", publishStatus=" + publishStatus +
                ", downloadLink='" + downloadLink + '\'' +
                ", versionSize=" + versionSize +
                ", integercreatedBy=" + integercreatedBy +
                ", creationDate=" + creationDate +
                ", IntegermodifyBy=" + IntegermodifyBy +
                ", modifyDate=" + modifyDate +
                ", softwareName='" + softwareName + '\'' +
                ", apkLocPath='" + apkLocPath + '\'' +
                ", apkFileName='" + apkFileName + '\'' +
                '}';
    }

    public String getPublishStatusName() {
        return publishStatusName;
    }

    public void setPublishStatusName(String publishStatusName) {
        this.publishStatusName = publishStatusName;
    }

    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public AppVersion(Integer appId) {
        this.appId = appId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getVersionInfo() {
        return versionInfo;
    }

    public void setVersionInfo(String versionInfo) {
        this.versionInfo = versionInfo;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public double getVersionSize() {
        return versionSize;
    }

    public void setVersionSize(double versionSize) {
        this.versionSize = versionSize;
    }

    public Integer getIntegercreatedBy() {
        return integercreatedBy;
    }

    public void setIntegercreatedBy(Integer integercreatedBy) {
        this.integercreatedBy = integercreatedBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getIntegermodifyBy() {
        return IntegermodifyBy;
    }

    public void setIntegermodifyBy(Integer integermodifyBy) {
        IntegermodifyBy = integermodifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getApkLocPath() {
        return apkLocPath;
    }

    public void setApkLocPath(String apkLocPath) {
        this.apkLocPath = apkLocPath;
    }

    public String getApkFileName() {
        return apkFileName;
    }

    public void setApkFileName(String apkFileName) {
        this.apkFileName = apkFileName;
    }


}
