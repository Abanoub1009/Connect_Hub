/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect_hub.NewsFeed;

import java.util.Set;

/**
 *
 * @author Karen Amgad
 */
public class NewsFeed {
    private FriendManagement friendManagement;

    public NewsFeed(FriendManagement friendManagement) {
        this.friendManagement = friendManagement;
    }
  
    
    public Set<User> ShowSuggestions (User currentUser)
    { return friendManagement.Suggestions(currentUser); }
   
    //This Class is for displaying the Status of the Friends in the User's Friend List
    
    
    public void displayFriendStatuses(User currentUser) {
        for (User friend : currentUser.getFriendList()) {
            System.out.println(friend.getUsername() + " is " + friend.getStatus());
        }
    }
    
    
}
