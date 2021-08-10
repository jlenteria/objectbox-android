package com.rd.asynchttpclient.AsyncHttpClient;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.RequestParams;

public class Rest {
    private static Rest ourInstance;
    private AsyncHttpClient client;

    public static Rest getInstance(){
        if(ourInstance == null)
            ourInstance = new Rest();
        return  ourInstance;
    }

    private Rest(){
        if(client == null){
            client = new AsyncHttpClient();
            client.setSSLSocketFactory(MySSLSocketFactory.getFixedSocketFactory()); // for SSL
            int one_minute = 1 * 60 * 1000;
            client.setConnectTimeout(one_minute); // set connect timeout to 1 minute;
            client.setResponseTimeout(one_minute); // set response timeout to 1 minute;
        }
    }

    //if the API has authtoken, call this;
    public void addAuthHeaders(String token ){
        if(token != null){
            client.addHeader("Authorization", "Bearer " + token);
        }
    }
    public void Login(String username, String password, AsyncHttpResponseHandler responseHandler){
        RequestParams params = new RequestParams();
        params.add("username", username);
        params.add("password", password);
        client.post("https://myjewels.com.ph/wp-json/jwt-auth/v1/token", params, responseHandler);
    }


}
