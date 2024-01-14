import models.Contact;
import models.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MainSql {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("Eric");

        Contact cont =new Contact();
        cont.setUser(user1);
        cont.setPhone("+795918486646");
        cont.setContactName("Eric cont name");
        cont.setEmail("eric@wr.com");

        var entityManagerFactory = Persistence.createEntityManagerFactory("pgconnection");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user1);
        em.getTransaction().commit();
        em.close();
    }
}
