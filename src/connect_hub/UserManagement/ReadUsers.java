package connect_hub.UserManagement;

import connect_hub.ContentCreation.Content;
import connect_hub.FileManager;
import org.json.JSONArray;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONObject;

public class ReadUsers {

    public static ArrayList<UserDetails> readUsersFromFile(String filePath) throws IOException {
        ArrayList<UserDetails> users = new ArrayList<>();
        JSONArray jsonArray = FileManager.loadFromFile(filePath);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String password = jsonObject.getString("password");
            String dateOfBirth = jsonObject.getString("dateOfBirth");
            String id = jsonObject.getString("id");
            String userName = jsonObject.getString("userName");
            String email = jsonObject.getString("email");
            String status = jsonObject.getString("status");
            UserDetails user = new UserDetails(id, email, userName, password, dateOfBirth, status);
            users.add(user);
        }
        return users;
    }
}
