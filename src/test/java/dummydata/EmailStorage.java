package dummydata;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class EmailStorage {
    private static final String FILE_PATH = "/Users/alex/Dev/codeSpace/softDev/ide/javaIDE/intelliJ/testing/tests/assignments/assignment/src/test/resources/users.json";
    private static final Type type = new TypeToken<Map<String, UserData>>() {}.getType();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveUser(String key, UserData userData) {
        Map<String, UserData> users = readUsers();

        users.put(key, userData);

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserData getUser(String key) {
        Map<String, UserData> users = readUsers();
        return users.get(key);
    }

    private static Map<String, UserData> readUsers() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            return new HashMap<>();
        }
    }
}
