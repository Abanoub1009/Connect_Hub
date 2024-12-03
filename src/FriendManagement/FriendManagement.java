/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FriendManagement;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Karen Amgad
 */
public class FriendManagement {
    //This Class is mainly for Friends Suggestions and List of "Friends of Friends"
    public Set<User> Suggestions ( User currentUser)
    {  Set<User> suggestions = new HashSet<>();
    //Two Loops inner and outer that checks every friend in the user list has that friend of friend in list to add them
        for ( User friend : currentUser.getFriendList()){
        for (User friendsFriend : friend.getFriendList())
        { if ( !currentUser.getFriendList().contains(friendsFriend)&& !currentUser.getBlockedUsers().contains(friendsFriend))
        {  suggestions.add(friendsFriend);
            }
    }
    
}
    return suggestions;
}
}
    