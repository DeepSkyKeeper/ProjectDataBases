package hyber;

import com.mongodb.internal.validator.CollectibleDocumentFieldNameValidator;
import models.Contact;

import java.lang.module.Configuration;

public class Session {
    private static SessionFactory sessionFactory;

    private Session() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Contact.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение! " + e);
            }
            return sessionFactory;
        }
    }
