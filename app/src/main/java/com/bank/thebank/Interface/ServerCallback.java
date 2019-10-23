package com.bank.thebank.Interface;

import org.json.JSONObject;


public interface ServerCallback {
    void onSuccess(String result);

    void onSuccess(JSONObject response);
}