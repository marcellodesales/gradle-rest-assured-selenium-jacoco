package org.example;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
 
@Path("/hello")
public class FooService {

  @GET
  @Path("/{param}")
  public Response getMsg(@PathParam("param") String msg) {
    String output = "Jersey say : " + Foo.print("yes".equals(msg));
    return Response.status(200).entity(output).build();
  }
}
