package connect_hub.UserManagement;

import connect_hub.FileManager;
import connect_hub.UserManagement.UserDetails;
import java.io.IOException;

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
}
