/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect_hub.ProfileManagment;

import connect_hub.UserManagement.UserDetails;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class UpdateBio {
  
     ArrayList<UserDetails> users;
     public UpdateBio( ArrayList<UserDetails> users){
         this.users=users;
     }
     public void changeBio(String bio,String id){
     for(UserDetails userr:users){
         if (userr.getUserId().equals(id)){
             userr.setBio(bio);
         }
     }
}
     
    /* public User getSpecific(String email){
         for(User user:users){
             if(user.getEmail().equals(email)){
                 return user;
             }
         }
         return null;
     }*/
}

