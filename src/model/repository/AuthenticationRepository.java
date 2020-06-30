package model.repository;

import model.singletons.LoginSingleton;

/*Login,Signup*/
public interface AuthenticationRepository {

    boolean userNameLogin(String userName, String password);
    void logOut();
    boolean isLoggedin();

}
