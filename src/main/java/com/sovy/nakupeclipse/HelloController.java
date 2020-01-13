package com.sovy.nakupeclipse;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

    @GET
    public String sayHello() {
        return "Hello World";
    }



    @Inject
    NakupDao nakupDao = new NakupDao();


    //@GET
    // public String sayHello() {
    //   return "Hello World";
    //}


    @GET
    @Path("/Nakup/{id}")
    public Nakup getNakupById(@PathParam("id") Long id) {
        return nakupDao.getNakupById(id);
    }

    @POST
    @Path("/add/")
    @Consumes("application/json")
    public void addNakup(Nakup nakup) {
        nakupDao.saveNakup(nakup);
    }

  ///  @DELETE
 //   @Path("/del/{id}")
   // public void deleteNakupById(@PathParam("id") int id) {
     //   nakupDao.deleteNakup(id);
    //}


}
