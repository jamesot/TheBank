package com.bank.thebank.Interface;

import org.json.JSONObject;


public interface VolleyCallback {
    void onSuccessResponse(String result);
    void onSuccessResponse(JSONObject response);
}
