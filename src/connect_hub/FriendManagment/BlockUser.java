/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect_hub.FriendManagment;

import connect_hub.UserManagement.Friends;
import connect_hub.UserManagement.UserDetails;

/**
 *
 * @author HP
 */
public class BlockUser {
    private UserDetails sender;
   private UserDetails reciver;

    public BlockUser(UserDetails sender, UserDetails reciver) {
        this.sender = sender;
        this.reciver = reciver;
    }
    public void Block(UserDetails sender,UserDetails reciver){
         Friends friendSender=new Friends(sender.getUserName(),sender.getStatus());
          Friends friendReciver=new Friends(reciver.getUserName(),reciver.getStatus());
          sender.getFriends().remove( friendSender);
          reciver.getFriends().remove(reciver);
          sender.addBlockedFriend(friendReciver);
    }
    public void remove(UserDetails sender,UserDetails reciver){
        Friends friendSender=new Friends(sender.getUserName(),sender.getStatus());
        Friends friendReciver=new Friends(reciver.getUserName(),reciver.getStatus());
         sender.getFriends().remove( friendSender);
          reciver.getFriends().remove(reciver);
    }
}
