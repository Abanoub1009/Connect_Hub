package connect_hub.ProfileManagment;

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
