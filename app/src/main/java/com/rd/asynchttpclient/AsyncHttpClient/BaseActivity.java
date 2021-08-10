package com.rd.asynchttpclient.AsyncHttpClient;

import androidx.appcompat.app.AppCompatActivity;

import com.rd.asynchttpclient.App;
import com.rd.asynchttpclient.AsyncHttpClient.model.SampleModel;
import com.rd.asynchttpclient.AsyncHttpClient.model.SampleModel_;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.query.Query;

public class BaseActivity extends AppCompatActivity {
    public Box<SampleModel> getSampleInfo(){
        return ((App)getApplication()).getBoxStore().boxFor(SampleModel.class);
    }
}
