package connect_hub.NewsFeed;

import connect_hub.ContentCreation.Content;
import connect_hub.ContentCreation.ContentRepository;
import java.util.ArrayList;

public class NewsFeedManager {

    private ContentRepository contentRepository;

    public NewsFeedManager(String filePath) {
        contentRepository = new ContentRepository(filePath);
    }

    // Load content (posts and stories) from the repository
    public ArrayList<Content> getNewsFeed() {
        return contentRepository.loadContents();
    }

    // Save posts to the repository
    public void savePosts(ArrayList<Content> posts) {
        contentRepository.savePosts(posts);
    }

    // Save stories to the repository
    public void saveStories(ArrayList<Content> stories) {
        contentRepository.saveStories(stories);
    }

    // Clear the content file after loading
    public void eraseFileAfterLoad(String type) {
        contentRepository.earaseTheFileAfterLoad(type);
    }
}
