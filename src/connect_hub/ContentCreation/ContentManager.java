package connect_hub.ContentCreation;

import java.util.*;

public class ContentManager {

    private ContentRepository contentRepository;

    public ContentManager(String filePath) {
        this.contentRepository = new ContentRepository(filePath);
    }

    public void createPost(String contentId, String authorId, String caption, String photo) {
        Content post = ContentFactory.createContent("post", contentId, authorId, caption, photo);
        List<Content> contents = contentRepository.loadContents();
        contents.add(post);
        contentRepository.savePosts(contents);
    }

    public void createStory(String contentId, String authorId, String caption, String photo) {
        Content story = ContentFactory.createContent("story", contentId, authorId, caption, photo);
        List<Content> contents = contentRepository.loadContents();
        contents.add(story);
        contentRepository.saveStories(contents);
    }

    public void deleteExpiredStories() {
        List<Content> contents = contentRepository.loadContents();
        List<Content> expiredStories = new ArrayList<>();
        
        for (Content content : contents) {
            if (content instanceof Story && content.isExpired()) {
                expiredStories.add(content);
            }
        }

        contents.removeAll(expiredStories);
        contentRepository.saveStories(contents);
    }
}
