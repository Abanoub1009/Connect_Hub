
package connect_hub.ContentCreation;

import java.time.LocalDateTime;


public interface Content {
    String getContentId();
    String getAuthorId();
    String getCaption();
    String getPhoto();
    LocalDateTime getTimestamp();
    boolean isExpired();
}
