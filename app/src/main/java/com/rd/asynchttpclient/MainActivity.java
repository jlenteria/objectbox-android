package com.rd.asynchttpclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.google.gson.Gson;
import com.rd.asynchttpclient.AsyncHttpClient.BaseActivity;
import com.rd.asynchttpclient.AsyncHttpClient.Rest;
import com.rd.asynchttpclient.AsyncHttpClient.RestResponseHandler;
import com.rd.asynchttpclient.AsyncHttpClient.fragments.LoginFragment;
import com.rd.asynchttpclient.AsyncHttpClient.model.SampleModel;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import io.objectbox.Box;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
    }
    private void initialView(){
        LoginFragment loginFragment  = LoginFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_view, loginFragment)
                .commit();
    }

}