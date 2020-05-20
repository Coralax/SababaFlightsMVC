package com.example.main;

public class Agent extends Person{
    private string userName, password;
    private int agentCode;
    private boolean enabled;

    public Agent(string userName, string password, int agentCode, boolean enabled){
        super(firstName, lastName, email, birthDateString);
        this.userName = userName;
        this.password = password;
        this.agentCode = agentCode;
        this.enabled = enabled;
    }

    public boolean isEnabled() { return enabled; }
    public int getAgentCode() { return agentCode; }
    public string getPassword() { return password; }
    public string getUserName() { return userName; }

    public void setAgentCode(int agentCode) { this.agentCode = agentCode; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    public void setPassword(string password) { this.password = password; }
    public void setUserName(string userName) { this.userName = userName; }
}
