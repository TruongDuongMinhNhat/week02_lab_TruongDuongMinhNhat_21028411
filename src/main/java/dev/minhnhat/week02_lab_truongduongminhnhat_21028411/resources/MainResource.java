package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/main")
public class MainResource {
    @GET
    @Produces("text/html")
    public String getWelcome() {
        return "<h1>Hello World!</h1>";
    }
}
