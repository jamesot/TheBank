package com.bank.thebank.controllers;

import android.content.Context;


import com.bank.thebank.Interface.ServerCallback;
import com.bank.thebank.Interface.ServerLoginCallback;
import com.bank.thebank.Interface.VolleyCallback;
import com.bank.thebank.data.Post;
import com.bank.thebank.utils.Utils;

import org.json.JSONObject;

import java.util.Map;

/* *
* Handles all data_formats (JSON or URL Params) to POST requests to any API
* */
public class PostData {
    Context context;

    public PostData(Context context) {
        this.context = context;
    }

    public void post(final String t_url, final Map<String, String> parameters, final JSONObject params, final Map<String, String> headers, final ServerCallback callback) {

        if (parameters != null) {
            Post.PostString(Utils.baseURL(context) + t_url, parameters, headers, new VolleyCallback() {
                @Override
                public void onSuccessResponse(String result) {
                    callback.onSuccess(result);
                }

                @Override
                public void onSuccessResponse(JSONObject response) {
                }
            });
        } else if (params != null) {

            Post.PostJSON(Utils.baseURL(context) + t_url, params, headers, new VolleyCallback() {
                @Override
                public void onSuccessResponse(String result) {
                }

                @Override
                public void onSuccessResponse(JSONObject response) {
                    callback.onSuccess(response);
                }
            });
        } else {
            Post.PostString(Utils.baseURL(context) + t_url, null, headers, new VolleyCallback() {
                @Override
                public void onSuccessResponse(String result) {
                    callback.onSuccess(result);
                }

                @Override
                public void onSuccessResponse(JSONObject response) {
                }
            });
        }
    }

    public void login(final String t_url, final Map<String, String> parameters, final JSONObject params, final Map<String, String> headers, final ServerLoginCallback callback) {

        if (parameters != null) {
            Post.PostString(Utils.baseURL(context) + t_url, parameters, headers, new VolleyCallback() {
                @Override
                public void onSuccessResponse(String result) {
                    callback.onSuccess(result);
                }

                @Override
                public void onSuccessResponse(JSONObject response) {
                }
            });
        } else if (params != null) {

            Post.PostJSON(Utils.baseURL(context) + t_url, params, headers, new VolleyCallback() {
                @Override
                public void onSuccessResponse(String result) {
                }

                @Override
                public void onSuccessResponse(JSONObject response) {
                    callback.onSuccess(response);
                }
            });
        } else {
            Post.PostString(Utils.baseURL(context) + t_url, null, headers, new VolleyCallback() {
                @Override
                public void onSuccessResponse(String result) {
                    callback.onSuccess(result);
                }

                @Override
                public void onSuccessResponse(JSONObject response) {
                }
            });
        }
    }
}
