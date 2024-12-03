package connect_hub.UserManagement;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class LogOut extends UserDetails {

    public LogOut(String email) throws IOException {
        super(null, email, null, null, null, null);
    }

    public String checkLogOutCredentials(String email) throws IOException {
        JSONArray usersArray = ReadUsers.readUsersFromFile("users.json");
        boolean userFound = false;

        for (int i = 0; i < usersArray.length(); i++) {
            JSONObject userJson = usersArray.getJSONObject(i);
            String storedEmail = userJson.getString("email");

            if (email.equals(storedEmail)) {
   //             if (userJson.optString("status").equalsIgnoreCase("Online")) {
                    userJson.put("status", "Offline");
                    userFound = true;
                    break;
       //         } else {
        //            return "User already offline";
       //         }
            }
        }
        if (userFound) {
            saveUsersToFile(usersArray);
            return "Logout successful"; 
        } else {
            return "invalidEmail";
        }
    }

    private void saveUsersToFile(JSONArray usersArray) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.json"))) {
            writer.write(usersArray.toString(4)); 
        }
    }
}
