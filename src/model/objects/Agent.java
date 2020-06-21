package model.objects;

import java.util.Objects;
import model.builders.AgentBuilder;

public class Agent extends Person {

    private String userName, password;
    private int agentCode;
    private boolean isVerified;
    private int permissionLevel;



    public static AgentBuilder builder() {
        return new AgentBuilder();
    }

    // Setters (which will be used by the builder)
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        // TODO: encrypt password (implement password encryption in agent repository)
        this.password = password;
    }
    public void setAgentCode(int agentCode) {
        this.agentCode = agentCode;
    }
    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public void setPermissionLevel(int permissionLevel) { this.permissionLevel = permissionLevel; }

    // Getters
    public String getUserName() {
        return userName;
    }
    public int getAgentCode() {
        return agentCode;
    }
    public boolean isVerified() { return isVerified; }
    public int getPermissionLevel() {return permissionLevel; }


    @Override
    public String toString() {
        return super.toString() + "\n"+
                " User name='" + userName + "\n" +
                " Agent code=" + agentCode + "\n" +
                " Is verified=" + isVerified + "\n" +
                " Permission level=" + permissionLevel + "\n" ;
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
        return Objects.hash(super.hashCode(), agentCode);
    }

}

