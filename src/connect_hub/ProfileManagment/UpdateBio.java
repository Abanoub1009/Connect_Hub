package connect_hub.ProfileManagment;

import connect_hub.UserManagement.ReadUsers;
import connect_hub.UserManagement.UserDetails;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author HP
 */
public class UpdateBio {

    // ArrayList<UserDetails> users;
//     JSONArray usersArray = ReadUsers.readUsersFromFile();
//     public UpdateBio( ArrayList<UserDetails> users){
//         this.users=users;
//     }
//     public void changeBio(String bio,String id){
//     for(UserDetails userr:users){
//         if (userr.getUserId().equals(id)){
//             userJson.put("Bio", setBio(bio)); 
//         }
//     }
//}
    /* public User getSpecific(String email){
         for(User user:users){
             if(user.getEmail().equals(email)){
                 return user;
             }
         }
         return null;
     }*/
    public String checkBio(String bio, String email) throws IOException {
        JSONArray usersArray = ReadUsers.readUsersFromFile();
        boolean userFound = false;

        for (int i = 0; i < usersArray.length(); i++) {
            JSONObject userJson = usersArray.getJSONObject(i);
            String storedEmail = userJson.getString("email");

            if (email.equals(storedEmail)) {
                userJson.put("Bio", bio);
                userFound = true;
                break;
            } else {
                System.out.println("Error");
            }
        }

        if (userFound) {
            saveUsersToFile(usersArray);
            return "success";
        } else {
            return "Errorr";
        }
    }
        // save the updated user data back to the file
    private void saveUsersToFile(JSONArray usersArray) throws IOException {
        String filePath = "users.json";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(usersArray.toString(4));
        }
    }
}

//    UserDetails getSpecific(String email) {
//        throw new UnsupportedOperationException("Not supported yet."); 
//    }
//}

