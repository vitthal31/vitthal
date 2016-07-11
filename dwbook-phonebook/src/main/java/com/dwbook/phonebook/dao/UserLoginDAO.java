/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dwbook.phonebook.dao;

import com.dwbook.phonebook.entity.UserLoginEntity;

/**
 *
 * @author vitthalde
 */
public interface UserLoginDAO {

        public UserLoginEntity getContactById(int id);
        public void save(UserLoginEntity ce);
    }
