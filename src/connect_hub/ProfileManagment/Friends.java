/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import connect_hub.ProfileManagment.*;

/**
 *
 * @author HP
 */
public class Friends {
    private String friendUserName;
    private String status;

    public Friends(String friendUserName, String status) {
        this.friendUserName = friendUserName;
        this.status = status;
    }

    public String getFriendd() {
        return friendUserName;
    }

    public void setFriend(String friend) {
        this.friendUserName = friend;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Friends{" + "friend=" + friendUserName + ", status=" + status + '}';
    }
    
}