package connect_hub;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserDetails {
    private String userId;
    private String email;
    private String userName;
    private String password;
    private String storePassword; 
    private String dateOfBirth;
    private String status;

     public UserDetails(String userId, String email, String userName, String password, String dateOfBirth, String status) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        setPassword(password);
        this.dateOfBirth = dateOfBirth;
        this.status = "Offline";
    }
     
    public UserDetails(){
        
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Please enter your email");
        }
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid Email");
        }
    }

    public String getUserName() {
        return userName;
    }

    // lesa nshof hn3ml track lw el user momkn y8ayr esmo aw y check fi esm zayo wla
    // la (lsa msh 3arfa)
    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
    if (isValidDateOfBirth(dateOfBirth)) {
        this.dateOfBirth = dateOfBirth;
    } else {
        throw new IllegalArgumentException("Invalid date format or logical date. Use DD-MM-YYYY.");
    }
    }


    public String getStatus() {
        return status;
    }

   public boolean isValidEmail(String email) {
        return email != null && email.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+$");
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be longer than 7 digits");
        }
        this.password = hashPassword(password);
    }

    // This method should be used for checking the plain password length before hashing
    public boolean checkPassLength(String password) {
        if (password == null || password.length() < 8) {
            return false;  
        }
        return true;  
    }

    public String getPassword(){
        return password;
    }

    // Store password before hashing and set it
    public void storePassword(String password) {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be longer than 7 digits");
        }
        this.storePassword = password;  
        this.password = hashPassword(password);  
    }

    public String getStoredPassword() {
        return storePassword;  
    }

    public String hashPassword(String password) {
        try {
            // create an obj from MessageDigest&&useSHA-256algo
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] sha256byte = sha256.digest(password.getBytes()); // save it into byte array as it works with bytes
            StringBuilder hexString = new StringBuilder(); // convert vyte to hexadecimal
            for (byte b : sha256byte) { // haloop 3la kol byte to convert to 2-dig hexadec str then append it to the string
                hexString.append(String.format("%02x", b)); // Format each byte as a 2-digit hex value
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password.", e);
        }
    }
    public boolean isValidDateOfBirth(String dateOfBirth) {
    try {
       
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        LocalDate parsedDate = LocalDate.parse(dateOfBirth, formatter);
        return true;
    }
    catch (DateTimeParseException e) {
        return false;
    }
}
}
