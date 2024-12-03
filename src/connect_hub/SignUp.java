package connect_hub;
import java.io.IOException;

public class SignUp extends UserDetails {

    public SignUp(String userId, String email, String userName, String password, String dateOfBirth, String status) throws IOException {
        super(userId, email, userName, password, dateOfBirth, status);
        createAccount();  
    }

    public void createAccount() throws IOException {
        if (isValid()) {  
            PutUsers.writeUserToJson(this);
            System.out.println("Account created successfully!");
        } else {
            System.out.println("Invalid account details!");
        }
    }

    private boolean isValid() {
        
        boolean isEmailValid = isValidEmail(getEmail());
        boolean isPasswordLengthValid = checkPassLength(getPassword());

        System.out.println("Email Valid: " + isEmailValid);
        System.out.println("Password Length Valid: " + isPasswordLengthValid);

        return getEmail() != null && isEmailValid && isPasswordLengthValid;
    }
}
