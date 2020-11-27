package org.acme.getting.started;

import javax.inject.Inject;
import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.acme.people.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;

@Path("/hello")
public class GreetingResource {

   // public static final Logger log = LoggerFactory.getLogger(GreetingResource.class);

    
    @Inject
    Mailer mailer;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    //	log.info("in hello");
        return "hello";
    }



    @GET 
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/email/{email}")
    public String sendMail(@PathParam("email") String email) {
    	System.out.println(email);
        mailer.send(Mail.withText(email, "An email", "www.google.com"));
          
        return "Email sent successfully!!";
    	
    }
}