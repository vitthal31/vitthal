/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dwbook.phonebook.dao.impl;

import com.dwbook.phonebook.dao.UserLoginDAO;
import com.dwbook.phonebook.entity.UserLoginEntity;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

/**
 *
 * @author vitthalde
 */
public class UserLoginDAOImpl extends AbstractDAO<UserLoginEntity> implements UserLoginDAO {

    
    
     /* Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     * @return
     */
    
    public UserLoginDAOImpl(SessionFactory sessionFactory) {
       
        super(sessionFactory);
         System.out.println("gooooo............."+sessionFactory.toString());
    }

    @Override
    public UserLoginEntity getContactById(int id) {
       
//         return  uniqueResult(\
//         
//         
//         
//         
//				namedQuery("com.dwbook.phonebook.entity.Course.findByID").setParameter("ID", id));
//        SessionFactory.openSession();
        System.out.print("id..."+id);
        
        return  get(id);
    }

    @Override
    public void save(UserLoginEntity ce) {
       System.out.print("insert record..."+ce.toString());
        persist(ce);
    }

}
