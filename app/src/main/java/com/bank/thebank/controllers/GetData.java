package com.bank.thebank.controllers;

import android.content.Context;

import com.android.volley.Request;
import com.bank.thebank.Interface.ServerCallback;
import com.bank.thebank.Interface.VolleyCallback;
import com.bank.thebank.data.Get;
import com.bank.thebank.utils.Utils;

import org.json.JSONObject;

import java.util.Map;

/* *
 * Handles all data_formats (JSON or URL Params) to GET requests to any API
 * */
public class GetData {

    Context context;

    public GetData(Context context) {
        this.context = context;
    }

    public void online_data(final String t_url, final Map<String, String> parameters, final Map<String, String> headers, final ServerCallback callback) {
        Get.getResponse(Request.Method.GET, Utils.baseURL(context) + t_url, null, context, parameters, headers,
                new VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result) {

                        String res = result;
                        callback.onSuccess(res);
                    }

                    @Override
                    public void onSuccessResponse(JSONObject response) {

                    }
                });
    }


}
