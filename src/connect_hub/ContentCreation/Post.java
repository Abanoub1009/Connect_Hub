package connect_hub.ContentCreation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONTokener;

public class Post extends ContentImp {

    public Post(String authorId, String caption, String photoPath) {
        this.authorId = authorId;
        this.caption = caption;
        this.photoPath = photoPath;
        this.id = generateId();
        this.createdDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());  // Set timestamp to current time
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("createdDate", createdDate);
        map.put("id", id);
        map.put("authorId", authorId);
        map.put("caption", caption);
        map.put("photoPath", photoPath);
        return map;
    }

}
