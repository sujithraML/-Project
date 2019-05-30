package com.aspire.sample.simpleuser;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UserInfoService {
	  @GET
	    @Path("/{userId}")   
	    @Produces(MediaType.APPLICATION_JSON)
	    public UserInfo getUser(@PathParam(value = "userId")String userId) {
		  UserInfo user = new UserInfo(userId, "jhone", 35);
	      return user;
	    }
}
