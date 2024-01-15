package services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.Closeable;
import java.io.IOException;

public class EntityService implements Closeable {
    private final EntityManagerFactory entityManagerFactory;
    public final EntityManager em;

    public EntityService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pgconnection");
        em = entityManagerFactory.createEntityManager();
    }

    @Override
    public void close() throws IOException {
        em.close();
        entityManagerFactory.close();
    }
}
