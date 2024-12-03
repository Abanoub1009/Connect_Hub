package connect_hub.UserManagement;

import connect_hub.FileManager;
import org.json.JSONArray;
import java.io.IOException;

public class ReadUsers {

    public static JSONArray readUsersFromFile(String filePath) throws IOException {
  
        return FileManager.loadFromFile(filePath);
    }
}

