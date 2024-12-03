/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import connect_hub.ProfileManagment.*;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class UpdateBio {
  
     ArrayList<User> users;
     public UpdateBio( ArrayList<User> users){
         this.users=users;
     }
     public void changeBio(String bio,String id){
     for(User userr:users){
         if (userr.getId().equals(id)){
             userr.setBio(bio);
         }
     }
}
     
     public User getSpecific(String email){
         for(User user:users){
             if(user.getEmail().equals(email)){
                 return user;
             }
         }
         return null;
     }
}

