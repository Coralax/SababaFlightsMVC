import controller.AuthenticationController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.fail;

public class AuthenticationTest {


    @Test
    public void weakPasswordSignUp(){
        AuthenticationController authenticationController = new AuthenticationController();
        String pass = "james13";
        try{
            authenticationController.passwordValidation(pass);
            fail("Password is valid, there's a logic error");
        }catch (IllegalArgumentException e){
            Assertions.assertEquals("Password is not valid",e.getMessage());
        }
//        authenticationController.agentSignUp("james","cohen",198134212,"ja@gmail.com",
//                "01/10/1990",false,"james132",pass)
    }
    @Test
    public void failLoginEmptyPassword(){
        AuthenticationController authenticationController = new AuthenticationController();
        try {
            authenticationController.login("aaaddd","");
            fail("Login success,there's a logic error");
        }catch (IllegalArgumentException e){
            Assertions.assertEquals("Username or password are required",e.getMessage());
        }
    }
    @Test
    public void failLoginEmptyUser(){
        AuthenticationController authenticationController = new AuthenticationController();
        try {
            authenticationController.login("","gogo1234");
            fail("Login success,there's a logic error");
        }catch (IllegalArgumentException e){
            Assertions.assertEquals("Username or password are required",e.getMessage());
        }
    }
    @Test
    public void birthdayNotValid(){
        AuthenticationController authenticationController = new AuthenticationController();
        try {
            authenticationController.birthdayValidation("1/1/1990");
            fail("Date validation error, regex not match dd/mm/yyyy, but test Passed ");
        }catch (IllegalArgumentException e){
            Assertions.assertEquals("Date is not valid,should match the pattern dd/mm/yyyy",e.getMessage());
        }
    }
    @Test
    public void birthdayIsValid(){
        AuthenticationController authenticationController = new AuthenticationController();
        try {
            boolean isValid = authenticationController.birthdayValidation("01/01/1993");
            Assertions.assertEquals(true,isValid);
        }catch (IllegalArgumentException e){
            fail("Date is not valid,should match the pattern dd/mm/yyyy");
        }
    }

}
