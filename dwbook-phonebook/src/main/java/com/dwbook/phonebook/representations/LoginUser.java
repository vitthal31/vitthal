/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dwbook.phonebook.representations;

/**
 *
 * @author vitthalde
 */
public class LoginUser {

    private final int id;
    private final int userId;

    private final String loginName;
    private final String loginPassword;
    private final String phone;

    public LoginUser() {
        this.id = 0;
        this.userId = 0;
        this.loginName = null;
        this.loginPassword = null;
        this.phone = null;
    }

    public LoginUser(int id, String firstName, String lastName,
            String phone, int userId) {
        this.id = id;
        this.userId = userId;
        this.loginName = firstName;
        this.loginPassword = lastName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public String getPhone() {
        return phone;
    }

    public int getUserId() {
        return userId;
    }
}
