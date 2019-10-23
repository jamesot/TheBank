package com.bank.thebank.Interface;


import com.bank.thebank.data.Result;
import com.bank.thebank.data.model.LoggedInUser;

import org.json.JSONObject;


public interface ServerLoginCallback {
    Result.Success<LoggedInUser> onSuccess(String result);

    void onSuccess(JSONObject response);
}