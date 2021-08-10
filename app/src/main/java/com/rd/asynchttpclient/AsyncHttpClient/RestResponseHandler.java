package com.rd.asynchttpclient.AsyncHttpClient;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class RestResponseHandler extends TextHttpResponseHandler {
    @Override
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, String responseString) {

    }


    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
        AsyncHttpClient.log.w("LOG_TAG", "onFailure(int, Header[], Throwable, JSONArray) was not overriden, but callback was received", throwable);

    }
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        AsyncHttpClient.log.w("LOG_TAG", "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
    }

    /**
     * Returns when request succeeds
     *
     * @param statusCode http response status line
     * @param headers    response headers if any
     * @param response   parsed response if any
     */
    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
        AsyncHttpClient.log.w("LOG_TAG", "onSuccess(int, Header[], JSONArray) was not overriden, but callback was received");
    }
}
