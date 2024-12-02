
package connect_hub.ContentCreation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public abstract class ContentImp implements Content{
    protected String id;         // Unique ID of the content
    protected String authorId;     // User ID of the creator      )
    protected String createdDate; // Date of content creation
    protected String caption;    // Caption for both Post and Story
    protected String photoPath;      // Photo associated with the Post or Story

    // Generate unique ID with dynamic content type suffix
    protected String generateId() {
        String className = this.getClass().getSimpleName().toLowerCase();
        return className + UUID.randomUUID().toString().replace("-", "") + "id";
    }

    // Getters
    @Override
    public String getId() {
        return id;
    }

    public String getAuthorId() {
        return authorId;
    }
    
    @Override
    public String getCreatedDate() {
        return createdDate;
    }

    @Override
    public String getCaption() {
        return caption;
    }

    @Override
    public String getPhotoPath() {
        return photoPath;
    }

    // Setters
    @Override
    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    @Override
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}


