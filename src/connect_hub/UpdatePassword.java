/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect_hub;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class UpdatePassword {
    ArrayList<User> users;

  
    public UpdatePassword(ArrayList<User> users) {
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
        for (User user : users) {
            if (user.getId().equals(id)) {  
                if(validatePassword(password)){
                String hashedPassword = HashedPassword(password); // Get the hashed password as a String
              if( checkPassword(user,hashedPassword)){
                user.setHashedPassword(hashedPassword);  // Update hashed password
                System.out.println("Password updated for user: " + user.getUsername());
            }}}
        }
    }
    public boolean checkPassword(User user,String password) throws NoSuchAlgorithmException{
        if(user.getHashedPassword().equals( password)){
            System.out.println("Password is same as the old one");
            return false;
        }
        return true;
    }
public boolean validatePassword(String password){
    if(password==null||password.length()<8){
        System.out.println("Incorrect password");
        return false;
    }
    return true;
}
public User getSpecificUser(String password) throws NoSuchAlgorithmException{
    for(User user:users){
       if(user.getHashedPassword().equals(HashedPassword(password))) ;
       return user;
    }
    return null;
}


}


