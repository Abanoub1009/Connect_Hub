package connect_hub.UserManagement;

import connect_hub.FileManager;
import connect_hub.ProfileManagment.*;
import static connect_hub.UserManagement.UserDetails.getPasswordFromFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class PutUsers {

    private final FileManager<UserDetails> userManager = new FileManager<>("users.json", "U");;

    public void writeUserToJson(UserDetails user) {
        try {
            userManager.writeToJson(user);
            System.out.println("User added successfully.");
        } catch (IOException e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }
   public static void save(ArrayList<UserDetails> users) throws IOException {
    JSONArray usersArray = new JSONArray();
    
    for (UserDetails user : users) {
        JSONObject userJson = new JSONObject();
        userJson.put("id", user.getUserId());
        userJson.put("userName", user.getUserName());
        userJson.put("password", getPasswordFromFile(user.getUserId()));
        userJson.put("email", user.getEmail());
        userJson.put("profilePhoto", user.getProfilePhoto());
        userJson.put("coverPhoto", user.getCoverPhoto());
        userJson.put("dateOfBirth", user.getDateOfBirth());
        userJson.put("status", UserDetails.getStatus(user.getUserId()));  
        userJson.put("bio", user.getBio());

        JSONArray friendsArray = new JSONArray();
        for (Friends friend : user.getFriends()) {
            JSONObject friendJson = new JSONObject();
            friendJson.put("FriendUserName", friend.getFriendd());
            friendJson.put("status", friend.isStatus());
            friendsArray.put(friendJson);
        }
        JSONArray postsArray = new JSONArray();
        for (Posts post : user.getPosts()) {
            JSONObject postJson = new JSONObject();
            postJson.put("Content", post.getContent());
            postJson.put("Image", post.getImage());
            postJson.put("Timestamp", post.getFormattedDate());
            postsArray.put(postJson);
        }

        userJson.put("friends", friendsArray);
        userJson.put("posts", postsArray);
        usersArray.put(userJson);
    }
    
    // Write the users array to the JSON file
    try (FileWriter file = new FileWriter("users.json")) {
        file.write(usersArray.toString(3));  // Write with indentation level 3
    }
}
}