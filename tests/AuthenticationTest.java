import controller.AuthenticationController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AuthenticationTest {


    @Test
    public void failLoginEmptyPassword(){
        AuthenticationController authenticationController = new AuthenticationController();
        Assertions.assertFalse(authenticationController.login("aaaddd", ""));
    }

    @Test
    public void failLoginEmptyUser(){
        AuthenticationController authenticationController = new AuthenticationController();
        Assertions.assertFalse(authenticationController.login("", "gogo1234"));
    }

    @Test
    public void loginTest() {
        AuthenticationController authenticationController = new AuthenticationController();
        Assertions.assertTrue(authenticationController.login("asdf", "asdf"));
    }

    @Test
    public void birthdayNotValid(){
        AuthenticationController authenticationController = new AuthenticationController();
        if (!authenticationController.isDate("1/1/1990")) {
            System.out.println( "Date is not valid,should match the pattern dd/mm/yyyy");
        }
        Assertions.assertFalse(authenticationController.isDate("1/1/1990"));
    }
    @Test
    public void birthdayIsValid(){
        AuthenticationController authenticationController = new AuthenticationController();
        Assertions.assertTrue(authenticationController.isDate("01/01/1993"));
    }

}
