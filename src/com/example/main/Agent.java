package com.example.main;

public class Agent extends Person {
    private String userName, password;
    private int agentCode;
    private boolean enabled;

    public Agent(String firstName, String lastName, long id, String email, String birthDateString, String userName, String password,
                 boolean enabled ) {
        super(firstName, lastName, id, email, birthDateString);
        this.userName = userName;
        this.enabled=enabled;
        this.password=password;
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

}
