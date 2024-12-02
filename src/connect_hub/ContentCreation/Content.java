
package connect_hub.ContentCreation;


public interface Content {
    String getId();        // Unique ID of the content
    String getCreatedDate(); // Creation date of the content
    String getCaption(); 
    String getPhotoPath();
    String getAuthorId();
    void setCaption(String caption);
    void setPhotoPath(String photoPath);
}