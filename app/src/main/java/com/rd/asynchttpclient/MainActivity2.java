package com.rd.asynchttpclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.rd.asynchttpclient.AsyncHttpClient.BaseActivity;
import com.rd.asynchttpclient.AsyncHttpClient.model.SampleModel;

public class MainActivity2 extends BaseActivity {

    Button backBtn;
    EditText username,firstName,lastName,status,password;
    SampleModel sampleModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String data = getIntent().getStringExtra("DATA");
        sampleModel = new Gson().fromJson(data, SampleModel.class);
        initialView();
    }

    private void initialView(){
        backBtn = findViewById(R.id.backBtn);
        username = findViewById(R.id.username);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        status = findViewById(R.id.status);
        password = findViewById(R.id.password);
        username.setText(sampleModel.getUsername());
        firstName.setText(sampleModel.getFirstName());
        lastName.setText(sampleModel.getLastName());
        status.setText(sampleModel.getStatus());
        password.setText(sampleModel.getPassword());
        backBtn.setOnClickListener(v -> {
            finish();
        });
    }

}