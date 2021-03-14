package com.sarthaksavasil.notificationtracker;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Data {
    private String dataId;
    private String packageName;
    private String title;
    private String decription;


    public Data(){
        //this constructor is required
    }

    public Data(String dataId, String packageName, String title, String decription) {
        this.dataId = dataId;
        this.packageName = packageName;
        this.title = title;
        this.decription=decription;
    }

    public String getDataId() {
        return dataId;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getTitle() {
        return title;
    }
    public String getDecription() {
        return decription;
    }
}