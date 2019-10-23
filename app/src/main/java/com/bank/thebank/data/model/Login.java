package com.bank.thebank.data.model;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * Created by stephineosoro on 23/10/19.
 */

public class Login extends DataSupport {

    @Column(unique = true)
    private long id;

    private String email;

    private String password;

    private String username;

    private String national_id;

    public String getNationalId() {
        return national_id;
    }

    public void setNaitionalId(String id) {
        this.national_id = id;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }


}

