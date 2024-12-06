/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect_hub.FriendManagment;

import connect_hub.UserManagement.Friends;
import connect_hub.UserManagement.UserDetails;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class FriendSuggestion {
     ArrayList<UserDetails> users;
     ArrayList<Friends>friendsSuggestion;
     public FriendSuggestion( ArrayList<UserDetails> users){
         this.users=users;
     }
     public ArrayList<Friends>checkFriends(String email){
         UserDetails user2=new UserDetails();
             user2=user2.getSpecificUser(users, email);
         for (UserDetails user : users) {
     
        if (user.getUserName().equals(user2.getUserName())) {
            continue;
        }

        boolean isAlreadyFriend = false;
        boolean isBlocked = false;

        // Check if the user is already a friend of user2
        for (connect_hub.UserManagement.Friends friend : user2.getFriends()) {
            if (friend.getFriendd().equals(user.getUserName())) {
                isAlreadyFriend = true;
                break;
            }
        }

        // Check if the user is in the blocked list of user2
        if (!isAlreadyFriend) {
            for (connect_hub.UserManagement.Friends blocked : user2.getBlocked()) {
                if (blocked.getFriendd().equals(user.getUserName())) {
                    isBlocked = true;
                    break;
                }
            }
        }

        // Add to friend suggestions if not already a friend and not blocked
        if (!isAlreadyFriend && !isBlocked) {
            Friends suggestion = new Friends(user.getUserName(), user.getStatus());
            friendsSuggestion.add(suggestion);
        }
    }

    return friendsSuggestion;
}
}
