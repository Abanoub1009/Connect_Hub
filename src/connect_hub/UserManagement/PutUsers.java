package connect_hub.UserManagement;

import connect_hub.FileManager;
import connect_hub.UserManagement.UserDetails;
import java.io.IOException;

public class PutUsers {

    private final FileManager<UserDetails> userManager = new FileManager<>("users.json", "U");;



    // Add a new user
    public void writeUserToJson(UserDetails user) {
        try {
            userManager.writeToJson(user);
            System.out.println("User added successfully.");
        } catch (IOException e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }

    // Retrieve all users
//    public void displayAllUsers() {
//        userManager.getAll().forEach((id, user) -> {
//            System.out.println("ID: " + id);
//            System.out.println("Email: " + user.getEmail());
//            System.out.println("Username: " + user.getUserName());
//            System.out.println("Date of Birth: " + user.getDateOfBirth());
//            System.out.println("Status: " + user.getStatus());
//            System.out.println("------------------------");
//        });
//    }

    // Example of retrieving a user by ID
//    public UserDetails getUserById(String userId) {
//        UserDetails user = userManager.get(userId);
//        if (user != null) {
//            System.out.println("User found: " + user.getUserName());
//        } else {
//            System.out.println("User with ID " + userId + " not found.");
//        }
//        return user;
//    }
}
