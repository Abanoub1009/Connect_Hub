package connect_hub.UserManagement;

import connect_hub.FileManager;
import connect_hub.ProfileManagment.*;
import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONArray;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.json.JSONObject;

public class ReadUsers {

    private static ArrayList<Friends> parseFriends(JSONArray friendsArray) {
        ArrayList<Friends> friendsList = new ArrayList<>();
        if (friendsArray != null) {
            for (int i = 0; i < friendsArray.length(); i++) {
                JSONObject friendObject = friendsArray.getJSONObject(i);
                // Parse friend object (adjust fields based on Friends class)
                String friendName = friendObject.getString("FriendUserName"); // Example field
                String friendStatus = friendObject.getString("status"); // Example field
                friendsList.add(new Friends(friendName, friendStatus)); // Adjust constructor
            }
        }
        return friendsList;
    }

    private static ArrayList<Posts> parsePosts(JSONArray postsArray) {
        ArrayList<Posts> postsList = new ArrayList<>();
        if (postsArray != null) {
            for (int i = 0; i < postsArray.length(); i++) {
                JSONObject postObject = postsArray.getJSONObject(i);
                // Parse post object (adjust fields based on Posts class)
                String content = postObject.getString("Content");
                String image = postObject.getString("Image");// Example field
                String timestamp = postObject.getString("Timestamp"); // Example field
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Adjust format if necessary
                LocalDateTime dateTime = LocalDateTime.parse(timestamp, formatter);
                postsList.add(new Posts(content, image, dateTime)); // Adjust constructor
            }
        }
        return postsList;
    }

    public static ArrayList<UserDetails> readUsersFromFile(String filePath) throws IOException {
        ArrayList<UserDetails> users = new ArrayList<>();
        
        // Using FileManager to load JSON from file
        JSONArray jsonArray = FileManager.loadFromFile(filePath);
        
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String password = jsonObject.getString("password");
            String profilePhoto = jsonObject.optString("ProfilePhoto", "");
            String coverPhoto = jsonObject.optString("CoverPhoto");
            String bio = jsonObject.optString("Bio", "");
            String dateOfBirth = jsonObject.getString("dateOfBirth");
            String id = jsonObject.getString("id");
            String userName = jsonObject.getString("userName");
            ArrayList<Posts> posts = parsePosts(jsonObject.optJSONArray("Posts"));
            String email = jsonObject.getString("email");
            ArrayList<Friends> friends = parseFriends(jsonObject.optJSONArray("Friends"));
            String status = jsonObject.getString("status");

            UserDetails user = new UserDetails(id, email, userName, password, dateOfBirth, status, bio, profilePhoto, coverPhoto, friends, posts);
            users.add(user);
        }
        return users;
    }
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
