/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect_hub.ContentCreation;


import java.time.LocalDateTime;

public class Post implements Content {
    private String contentId;
    private String authorId;
    private String caption;
    private String photo;
    private LocalDateTime timestamp;

    // Constructor
    public Post(String contentId, String authorId, String caption, String photo) {

        this.contentId = contentId;
        this.authorId = authorId;
        this.caption = caption;
        this.photo = photo;
        this.timestamp = LocalDateTime.now();
    }



    // Getters
    @Override
    public String getContentId() {
        return contentId;
    }

    @Override
    public String getAuthorId() {
        return authorId;
    }

    @Override
    public String getCaption() {
        return caption;
    }

    @Override
    public String getPhoto() {
        return photo;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean isExpired() {
        return false;  // Posts never expire
    }
}

