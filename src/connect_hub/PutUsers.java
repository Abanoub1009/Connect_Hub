package connect_hub;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class PutUsers {

    public static void writeUserToJson(UserDetails user) throws IOException {
        
        JSONArray usersArray = new JSONArray();
        int nextUserId = 0; 
        
        try (BufferedReader reader = new BufferedReader(new FileReader("users.json"))) {
            StringBuilder jsonData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }

            // If the file has existing data, parse it into a JSONArray
            if (!jsonData.isEmpty()) {
                usersArray = new JSONArray(jsonData.toString());
                
                String lastUserId = usersArray.getJSONObject(usersArray.length() - 1).getString("userId");
                nextUserId = Integer.parseInt(lastUserId.substring(1)) + 1; // Extract the numeric part of the last ID and increment
            }
        } catch (IOException e) {
            System.out.println("No existing file. A new users.json will be created.");
        }

        JSONObject userJson = new JSONObject();
        String newUserId = "U" + nextUserId; 
        userJson.put("userId", newUserId); 
        userJson.put("email", user.getEmail());
        userJson.put("userName", user.getUserName());
        userJson.put("password", user.getPassword());
        userJson.put("dateOfBirth", user.getDateOfBirth());
        userJson.put("status", user.getStatus());

        usersArray.put(userJson);

        try (FileWriter file = new FileWriter("users.json")) {
            file.write(usersArray.toString(4)); // Pretty print with indentation
        }
    }
}
