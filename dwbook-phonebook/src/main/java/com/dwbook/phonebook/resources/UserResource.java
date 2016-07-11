/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dwbook.phonebook.resources;

/**
 *
 * @author vitthalde
 */
import com.dwbook.phonebook.dao.UserLoginDAO;
import com.dwbook.phonebook.entity.UserLoginEntity;
import com.dwbook.phonebook.representations.LoginUser;
import io.dropwizard.hibernate.UnitOfWork;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/localoffer/userlogin")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    UserLoginDAO contactDAO = null;

    public UserResource(UserLoginDAO employeeDAO) {
        this.contactDAO = employeeDAO;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Response getUserLoginDetails(@PathParam("id") int id) {
// retrieve information about the contact with the
        //   provided id

//        UserLoginEntity contactEntity= new UserLoginEntity();
//        contactEntity.setFirstName("insert record");
//        contactEntity.setLastName("last");
//        contactEntity.setPhone("3333");
//        contactEntity.setId(3);
//        contactDAO.save(contactEntity);
        UserLoginEntity contactEntity = contactDAO.getContactById(id);

        System.out.println("contact" + contactEntity);
        if (contactEntity != null) {
            return Response
                    .ok(new LoginUser(id, contactEntity.getLoginName(), contactEntity.getLoginPassword(), contactEntity.getPhone(), contactEntity.getUserId()))
                    .build();
        } else {
            return Response
                    .ok(null)
                    .build();
        }

    }

    @POST
    public Response createContact(
            @FormParam("name") String name,
            @FormParam("phone") String phone) {
        // store the new contact
        // ...
        return Response
                .created(null)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") int id) {
        // delete the contact with the provided id
        // ...
        return Response
                .noContent()
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateContact(
            @PathParam("id") int id,
            LoginUser contact) {
        // update the contact with the provided ID
        // ...
        return Response.ok(new LoginUser(id, contact.getLoginName(), contact.getLoginPassword(), contact.getPhone(), contact.getUserId()))
                .build();
    }

}
