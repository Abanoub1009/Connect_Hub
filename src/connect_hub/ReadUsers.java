package connect_hub;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;

public class ReadUsers {
    
    public static JSONArray readUsersFromFile() throws IOException {
        JSONArray usersArray = new JSONArray();
        try (BufferedReader reader = new BufferedReader(new FileReader("users.json"))) {
            StringBuilder jsonData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }

            if (!jsonData.isEmpty()) {
                usersArray = new JSONArray(jsonData.toString());
            }
        }
        return usersArray;
    }
}
