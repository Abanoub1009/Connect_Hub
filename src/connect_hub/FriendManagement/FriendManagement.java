/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connect_hub.FriendManagement;

import connect_hub.UserManagement.UserDetails;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Karen Amgad
 */
public class FriendManagement {

    //This Class is mainly for Friends Suggestions and List of "Friends of Friends"
    public Set<UserDetails> Suggestions(UserDetails currentUser) {
        Set<UserDetails> suggestions = new HashSet<>();
        //Two Loops inner and outer that checks every friend in the user list has that friend of friend in list to add them
        for (UserDetails friend : currentUser.getFriends()) {
            for (UserDetails friendsFriend : friend.getFriends()) {
                if (!currentUser.getFriends().contains(friendsFriend) && !currentUser.getBlockedUsers().contains(friendsFriend)) {
                    suggestions.add(friendsFriend);
                }
            }

        }
        return suggestions;
    }
}
