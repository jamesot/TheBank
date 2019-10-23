package com.bank.thebank.data;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;


public class Transactions extends DataSupport {

    @Column(unique = true)
    private long id;

    private String email;

    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }


}

