import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        try (var mongoClient = MongoClients.create()) {

            var database = mongoClient.getDatabase("syn");

            var todoCollection = database.getCollection("todo");

            addDoc(todoCollection);

            resOut(todoCollection);

//            changeDoc(todoCollection);

//            resOut(todoCollection);

//            todoCollection.deleteOne(new Document("_id", new ObjectId("659fcb48e24805191473dc6a")));
//
//            resOut(todoCollection);

        }

    }

    private static void addDoc(MongoCollection<Document> todoCollection) {

        var todoDocument = new Document(Map.of(
                "_id", new ObjectId(),
                "task", "Drink some coffee",
                "dateCreated", LocalDateTime.now(),
                "done", false));

        todoCollection.insertOne(todoDocument);
    }

    private static void changeDoc(MongoCollection<Document> todoCollection) {
        todoCollection.updateOne(new Document(
         "_id", new ObjectId("659fcb48e24805191473dc6a")),
                new Document(Map.of(
                        "$set", new Document("done", true),
                        "$currentDate", new Document("dateDone", true),
                        "$unset", new Document("dateCreated", true)
                ))
        );
    }

    private static void resOut(MongoCollection<Document> todoCollection) {
        /**
         * поиск
         */
        todoCollection.find()
                .forEach((Consumer<Document>) System.out::println);
        /**
         * Поиск по подобию
         */
//        todoCollection.find(new Document("task", new Document("$regex", "coffee")))
//                .forEach((Consumer<Document>) System.out::println);
    }

    private static void getTableList(MongoDatabase database) {
        database.listCollectionNames()
                .forEach((Consumer<String>) System.out::println);
        // todo
        database.listCollections()
                .forEach((Consumer<Document>) System.out::println);
    }

    private static void getDbList(MongoClient mongoClient) {
        mongoClient.listDatabases()
                .forEach((Consumer<Document>) System.out::println);
        // show dbs
        // Document{{name=test, sizeOnDisk=1.385336832E9, empty=false}}
        mongoClient.listDatabaseNames()
                .forEach((Consumer<String>) System.out::println);
    }
}


//docker run -p 5432:5432 --name pgdb-postgres -e POSTGRES_DB=pgdb -e POSTGRES_PASSWORD=deeppas -e POSTGRES_USER=dsk -d postgres:alpine
//docker run -p 27017:27017 --name mongodb-mongo -d mongo:latest