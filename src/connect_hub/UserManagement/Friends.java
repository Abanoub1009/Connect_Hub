package connect_hub.UserManagement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class Friends {
    private String friendUsername;
    private String status;

    public Friends(String friendUsername, String status) {
        this.friendUsername = friendUsername;
        this.status = status;
    }

    public String getFriendd() {
        return friendUsername;
    }

    public void setFriendd(String friendUsername) {
        this.friendUsername = friendUsername;
    }

    
    

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Friends{" + "friend=" + friendUsername + ", status=" + status + '}';
    }
    
}
