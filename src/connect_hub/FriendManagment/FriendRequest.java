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
public class FriendRequest {
   private UserDetails sender;
   private UserDetails reciver;

    public FriendRequest(UserDetails sender, UserDetails reciver) {
        this.sender = sender;
        this.reciver = reciver;
    }

    /**
     *
     * @param sender
     * @param email
     * @param friend
     * @param friend
     */
    
    
    public void sendRequest(UserDetails sender,UserDetails reciver){
        Friends friendSender=new Friends(sender.getUserName(),sender.getStatus());
        Friends friendReciver=new Friends(reciver.getUserName(),reciver.getStatus());
          reciver.addRequestFriend(friendSender);
          
          
    }
    public void acceptFriend(UserDetails sender,UserDetails reciver){
        Friends friendSender=new Friends(sender.getUserName(),sender.getStatus());
          Friends friendReciver=new Friends(reciver.getUserName(),reciver.getStatus());
        sender.addFriend(friendReciver);
        reciver.addFriend(friendSender);
        reciver.getRequest().remove(friendSender);
    }
    public void declineFriend(UserDetails sender,UserDetails reciver){
         Friends friendSender=new Friends(sender.getUserName(),sender.getStatus());
         reciver.getRequest().remove(friendSender);
    }
    
   
}
