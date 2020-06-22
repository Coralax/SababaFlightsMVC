package com.example.main;

public class Agent extends Person{
    private String userName, password;
    private int agentCode;
    private boolean enabled;

    public Agent(String userName, String password, int agentCode, boolean enabled){
        this.setFirstName(firstName);
        this.setPassword(password);
        this.setAgentCode(agentCode);
        this.setEnabled(enabled);
        this.userName = userName;
        this.password = password;
        this.agentCode = agentCode;
        this.enabled = enabled;
    }

    public boolean isEnabled() { return enabled; }
    public int getAgentCode() { return agentCode; }
    public String getPassword() { return password; }
    public String getUserName() { return userName; }

    public void setAgentCode(int agentCode) { this.agentCode = agentCode; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    public void setPassword(String password) { this.password = password; }
    public void setUserName(String userName) { this.userName = userName; }
}
