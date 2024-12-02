
package connect_hub.ContentCreation;

import connect_hub.FileManager;
import java.util.Map;


public class PostDatabase {
    
    private FileManager filemanager;
    private String filePath;
    public PostDatabase(String filePath) {
        this.filePath = filePath;
        filemanager = new FileManager<Post>(this.filePath);
    }
    public void addOrUpdateContent(String contentId, Post value) {
        filemanager.addOrUpdate(contentId, value);
    }

    // Remove content by its ID
    public void removeContent(String contentId) {
        filemanager.remove(contentId);
    }

    // Get content by its ID
    public Post getContentById(String contentId) {
        return (Post)filemanager.getById(contentId);
    }

    // Get all content
    public Map<String, Post> getAllContent() {
        return filemanager.getDataMap();
    }

    // Save content back to the file
    public void saveContent() {
        filemanager.saveToFile();
    }
    
}
