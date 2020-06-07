package com.example.main;

/*Need to do:
 * 1. A method to validate that the user name is not already taken */

import java.util.Objects;

public class Agent extends Person {

    private String userName, password;
    private int agentCode;
    private boolean enabled;

  public Agent(String firstName,String lastName,long id,  String email, String birthDateString, boolean enabled , String userName, String password){
        super(firstName,lastName,id,email,birthDateString);
        this.enabled= enabled;

        //We have to implement a method (from an admin context) that validates the agent code from a pre-made file and then sets the enabled field accordingly
        if(!enabled)
            throw new IllegalArgumentException("Agent is not enabled, can not register to the system");
        if(!(userNameValidation(userName))|| !passwordStrength(password) ) {
            throw new IllegalArgumentException("");
        }
        else
        {
            this.userName=userName;
            this.password= password;
        }
     }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAgentCode(int agentCode) {
        this.agentCode = agentCode;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getAgentCode() {
        return agentCode;
    }
    public boolean isEnabled() {
        return enabled;
    }

    private static boolean userNameValidation(String userName) {
        if (!userName.matches("^[a-zA-Z]*$")){
            System.out.println("User name must consist of only English alphanumeric characters!");
            return false;
        }
        if(userName.length()<6 || userName.length()>20)
        {
            System.out.println("User name must be between 6 and 20 characters long");
            return false;
        }
        return true;
    }

    private static boolean passwordStrength(String password) {
        if (password.length() < 8 || password.length()>32) {
            System.out.println("Password must be between 8 and 32 characters long");
            return false;
        }

        if (!(password.matches("(?=.*[0-9]).*"))) {
            System.out.println("Password must contain at least one digit! ");
            return false;
        }

        if (!(password.matches("(?=.*[a-zA-Z]).*"))) {
            System.out.println("Password must contain at least one letter! ");
            return false;
        }

    return true;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Agent additional information: " + "\n" +
                "User name: " + userName + "\n" +
                "Password: " + "*********" + "\n" +
                "Agent code: " + agentCode + "\n" +
                "Enabled: " + enabled + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return agentCode == agent.agentCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(agentCode);
    }
}
