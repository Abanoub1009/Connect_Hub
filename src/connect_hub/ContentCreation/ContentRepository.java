package connect_hub.ContentCreation;

import connect_hub.*;
import java.io.*;
import java.util.*;
import org.json.*;

public class ContentRepository {

    private String filePath;
    private final FileManager<Content> postManager = new FileManager<>("posts.json", "P");;
    private final FileManager<Content> storyManager = new FileManager<>("stories.json", "S");;

    // Constructor to set the file path for content storage
    public ContentRepository(String filePath) {
        this.filePath = filePath;
    }

    // Load content from a JSON file
    public List<Content> loadContents() {
        List<Content> contents = new ArrayList<>();
        JSONArray jsonArray = FileManager.loadFromFile(filePath);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String type = jsonObject.getString("type");
            String contentId = jsonObject.getString("contentId");
            String authorId = jsonObject.getString("authorId");
            String caption = jsonObject.getString("caption");
            String photo = jsonObject.getString("photo");
            
            // Create Post or Story based on type
            Content content = ContentFactory.createContent(type, contentId, authorId, caption, photo);
            contents.add(content);
        }
        return contents;
    }

    // Save content to the JSON file
    public void savePosts(List<Content> posts) {
        try {
            for(Content content: posts)
            {
                Post post = (Post) content;
                postManager.writeToJson(post);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save stories to stories.json using FileManager
    public void saveStories(List<Content> stories) {
        try {
            for(Content content: stories)
            {
                Story story = (Story) content;
                storyManager.writeToJson(story);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
    
