/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect_hub.ProfileManagment;
import connect_hub.UserManagement.UserDetails;
import connect_hub.Friends;
import connect_hub.Posts;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class UpdatePhoto {
     ArrayList<UserDetails> users;

  
    public UpdatePhoto(ArrayList<UserDetails> users) {
        this.users = users;
    }
    public void changeProfilePhoto(String userId,String profilePhoto){
        for(UserDetails user:users){
             if (user.getUserId().equals(userId)) { {
                 user.setProfilePhoto(profilePhoto);
             }
        }}}
        public void changeCoverPhoto(String userId,String profilePhoto){
        for(UserDetails user:users){
             if (user.getUserId().equals(userId)) { 
                 user.setProfilePhoto(profilePhoto);
             
        }
    }
    }}
