package com.rd.asynchttpclient;

import android.app.Application;

import com.rd.asynchttpclient.AsyncHttpClient.model.MyObjectBox;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class App extends Application {
    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();
        boxStore = MyObjectBox.builder().androidContext(App.this).build();

    }
    public BoxStore getBoxStore(){return boxStore;}
}
