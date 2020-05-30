package com.example.main;

public class Agent extends Person {
    private String userName, password;
    private int agentCode;
    private boolean enabled;


    public Agent(Person pr, boolean enabled , String userName, String password){
        super(pr.firstName, pr.lastName, pr.id, pr.email, pr.birthDateString);
        this.enabled= enabled;
        //We have to implement a method that validates the agent code from a pre-made file and then sets the enabled attribute accordingly
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
            System.out.println("User name must consist of only english alphanumeric characters!");
            return false;
        }
        if(userName.length()<5)
        {
            System.out.println("User name length must be at least 5 characters");
            return false;
        }
        return true;
    }

    private static boolean passwordStrength(String password) {
        if (password.length() < 8) {
            System.out.println("Password is too short! ");
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
        return super.toString() + "\n" + "Agent additional details are: " + "\n" +
                "User name: " + userName + "\n" +
                "Password: " + "*********" + "\n" +
                "Agent code: " + agentCode + "\n" +
                "Enabled: " + enabled + "\n";
    }
}
