package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.resources.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/main")
public class MainResource {
    private EntityManager entityManager;
    @GET
    @Produces("text/html")
    public String getWelcome() {
        entityManager = Persistence.createEntityManagerFactory("week02").createEntityManager();
        return "<h1>Hello World!</h1>";
    }
}
