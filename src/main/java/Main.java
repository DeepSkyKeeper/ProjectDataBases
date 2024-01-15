import models.Contact;
import models.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) throws SQLException, IOException {

        var controller = new MainController();

        User user1 = new User();
        user1.setId(1);
        user1.setName("Petya");

        Contact cont = new Contact();
        cont.setPhone("+98181616561");
        cont.setContactName("reioeorhn");
        cont.setEmail("errtjhywic@wtrer.com");

        var meta = new HashMap<String, Object>();
        meta.put("traceId", "wqwwwwwwwwwwwqq88");
        meta.put("userId", 1);
        meta.put("time", new Date().getTime());

        controller.addContact(user1, cont, meta);
        controller.close();


    }

}
