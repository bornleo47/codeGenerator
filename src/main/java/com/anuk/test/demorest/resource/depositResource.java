/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuk.test.demorest.resource;

import com.anuk.test.demorest.deposit;
import com.anuk.test.demorest.repository.depositRepository;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author anukshakya
 */
@Path("start")
public class depositResource {

    depositRepository dr = new depositRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<deposit> readAll() {
        return dr.readAll();

    }

    @POST
    @Path("save")
    public deposit createDeposit(deposit a) throws Exception {
        String p = null;
        do {
          p = a.setCode(dr.generateCode("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789", 6));
            System.out.println(dr.checker(p));
        } while(dr.checker(p));

        dr.createDeposit(a);
        return a;
    }

}

