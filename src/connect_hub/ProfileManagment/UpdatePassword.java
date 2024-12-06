package connect_hub.ProfileManagment;

import connect_hub.UserManagement.UserDetails;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class UpdatePassword {

    ArrayList<UserDetails> users;

    public UpdatePassword(ArrayList<UserDetails> users) {
        this.users = users;
    }

    public static String HashedPassword(String password) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");  // Removed the extra space
        byte[] hashedBytes = digest.digest(password.getBytes());  // Hash the password
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashedBytes) {
            hexString.append(String.format("%02x", b));  // Convert byte to hex
        }
        return hexString.toString();  // Return the hashed password as a String
    }

    public void changePassword(String password, String id) throws NoSuchAlgorithmException {
        for (UserDetails user : users) {
            if (user.getUserId().equals(id)) {
                if (validatePassword(password)) {
                    String hashedPassword = HashedPassword(password); // Get the hashed password as a String
                    if (checkPassword(user, hashedPassword)) {
                        user.setPassword(hashedPassword);  // Update hashed password
                        System.out.println("Password updated for user: " + user.getUserName());
                    }
                }
            }
        }
    }

    public boolean checkPassword(UserDetails user, String password) throws NoSuchAlgorithmException {
        if (user.getPassword().equals(password)) {
            System.out.println("Password is same as the old one");
            return false;
        }
        return true;
    }

    public boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            System.out.println("Incorrect password");
            return false;
        }
        return true;
    }

    public UserDetails getSpecificUser(String password) throws NoSuchAlgorithmException {
        for (UserDetails user : users) {
            if (user.getPassword().equals(UserDetails.hashPassword(password))) 
            return user;
        }
        return null;
    }

}
