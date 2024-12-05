package connect_hub.UserManagement;

import connect_hub.FileManager;
import connect_hub.ProfileManagment.*;

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
    public static void save(ArrayList<UserDetails> x) throws IOException{
            JSONArray usersArray=new JSONArray();
        for(UserDetails u:x){
            JSONObject j=new JSONObject();
            j.put("userId", u.getUserId());
            j.put("userName", u.getUserName());
            j.put("password",u.getPassword());
            j.put("email", u.getEmail());
            j.put("ProfilePhoto", u.getProfilePhoto());
            j.put("CoverPhoto", u.getCoverPhoto());
             j.put("Bio", u.getBio());
            JSONArray friendsArray = new JSONArray();
        // Iterate through the user's friends
        for (Friends friend : u.getFriends()) {
            JSONObject friendJson = new JSONObject();
            // Add friend's username and status
            friendJson.put("FriendUserName", friend.getFriendd());
            friendJson.put("status", friend.isStatus());
            friendsArray.put(friendJson);
        }
        JSONArray postsArray = new JSONArray();
        // Iterate through the user's friends
        for (Posts post : u.getPosts()) {
            JSONObject postJson = new JSONObject();
            // Add friend's username and status
            postJson.put("Content", post.getContent());
            postJson.put("Image", post.getImage());
            postJson.put("Timestamp", post.getFormattedDate());
            postsArray.put(postJson);
        }
        
        // Add the friends array to the user's JSON object
        j.put("Friends", friendsArray);
        j.put("Posts", postsArray);
        
      
       
        
        // Add the user object to the users array
        usersArray.put(j);
    }
    
    // Write the users array to a JSON file
    FileWriter file = new FileWriter("users.json");
    file.write(usersArray.toString(3)); // Indentation level 3 for better readability
    file.close();
}
    
}
