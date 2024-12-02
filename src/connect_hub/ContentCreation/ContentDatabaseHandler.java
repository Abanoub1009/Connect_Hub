
package connect_hub.ContentCreation;

import connect_hub.FileManager;
import java.util.Map;


public abstract class ContentDatabaseHandler<T> {
    protected FileManager<T> fileManager;
    public ContentDatabaseHandler(String filePath) {
        fileManager = new FileManager<>(filePath);
    }

    // Add or update content
    public void addOrUpdateContent(String contentId, T value) {
        fileManager.addOrUpdate(contentId, value);
    }

    // Remove content by its ID
    public void removeContent(String contentId) {
        fileManager.remove(contentId);
    }

    // Get content by its ID
    public T getContentById(String contentId) {
        return fileManager.getById(contentId);
    }

    // Get all content
    public Map<String, T> getAllContent() {
        return fileManager.getDataMap();
    }

    // Save content back to the file
    public void saveContent() {
        fileManager.saveToFile();
    }
}
