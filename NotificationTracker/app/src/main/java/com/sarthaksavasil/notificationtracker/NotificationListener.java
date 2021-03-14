package com.sarthaksavasil.notificationtracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NotificationListener extends NotificationListenerService {
    DatabaseReference databaseDataL;
    Context context;
    String titleData="", textData="";
    long time=0;
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn){
        databaseDataL = FirebaseDatabase.getInstance().getReference("data");


        // Implement what you want here


        String packageName = sbn.getPackageName();
        Bundle extras = sbn.getNotification().extras;
        if(extras.getString("android.title")!=null){
            titleData = extras.getString("android.title");
        }else{
            titleData = "";
        }
        if(extras.getCharSequence("android.text")!=null){
            textData = extras.getCharSequence("android.text").toString();
        }else{
            textData = "";
        }
//        packageName=packageName.replaceAll("com"," ");
//        packageName=packageName.replaceAll("android"," ");
//        packageName=packageName.replaceAll("."," ");
//        packageName=packageName.trim();
        Log.d("Package", packageName);
        String id = databaseDataL.push().getKey();
        Data data = new Data(id, packageName, titleData,textData);
        databaseDataL.child(id).setValue(data);
        Log.d("Title", titleData);
        Log.d("Text", textData);

    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn){
        // Implement what you want here
        Log.d("Deleted", "Notification Removed");
    }
}