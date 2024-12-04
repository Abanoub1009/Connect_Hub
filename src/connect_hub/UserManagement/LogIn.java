package connect_hub.UserManagement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;


public class LogIn extends UserDetails {

        private PutUsers putUsers = new PutUsers();

    public LogIn(String email, String password) throws IOException {
        super(null, email, null, password, null, "online",null,null,null,null,null);
    }

    public String checkLoginCredentials(String email, String password) throws IOException {
        ArrayList<UserDetails> usersArray = ReadUsers.readUsersFromFile("users.json");
        boolean userFound = false;

        for (int i = 0; i < usersArray.size(); i++) {
            UserDetails user = usersArray.get(i);
            String storedEmail = user.getEmail();
            String storedHashedPass = user.getPassword();

            if (email.equals(storedEmail)) {
                String enteredPassHash = hashPassword(password);

                if (enteredPassHash.equals(storedHashedPass)) {
                   user.setStatus("Online");
                    userFound = true;
                    break;
                } else {
                    return "invalidPassword";
                }
            }
        }

        if (userFound) {
           putUsers.writeUserToJson(this);
            return "success";
        } else {
            return "invalidEmail";
        }
    }
    // save the updated user data back to the file
     private void saveUsersToFile(JSONArray usersArray) throws IOException {
        String filePath = "users.json"; 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(usersArray.toString(4));  
        }
    }
}
