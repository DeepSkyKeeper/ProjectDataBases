import models.Contact;
import models.User;
import services.EntityService;
import services.LogService;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;

public class MainController implements Closeable {
    LogService log;
    EntityService entity;

    public MainController() {
       log=new LogService();
       entity =new EntityService();
    }

    @Override
    public void close() throws IOException {
        entity.close();
        log.close();
    }
    public void addContact(User user, Contact contact, Map<String, Object> meta) {
        contact.setUser(user);

       entity.em.getTransaction().begin();
       entity.em.persist(contact);
       entity.em.getTransaction().commit();
        meta.put("action", "createContact");
        meta.put("newContactId", contact.getId());

        log.add(meta);
    }
}
