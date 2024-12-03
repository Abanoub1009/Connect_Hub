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
public class UpdatePhoto {
     ArrayList<User> users;

  
    public UpdatePhoto(ArrayList<User> users) {
        this.users = users;
    }
    public void changeProfilePhoto(String userId,String profilePhoto){
        for(User user:users){
             if (user.getId().equals(userId)) { {
                 user.setProfilePhoto(profilePhoto);
             }
        }}}
        public void changeCoverPhoto(String userId,String profilePhoto){
        for(User user:users){
             if (user.getId().equals(userId)) { 
                 user.setProfilePhoto(profilePhoto);
             
        }
    }
    }}
