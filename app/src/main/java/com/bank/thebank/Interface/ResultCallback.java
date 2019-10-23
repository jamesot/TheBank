package com.bank.thebank.Interface;


import com.bank.thebank.data.Result;

public interface ResultCallback<T> {
    void handleResult(Result<T> result);
}
