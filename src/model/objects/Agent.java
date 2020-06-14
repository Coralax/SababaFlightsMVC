package model.objects;


import java.time.LocalDate;
import java.util.Objects;

public class Agent extends Person {

    private String userName, password;
    private int agentCode;
    private boolean enabled;
    private int permission;

  public Agent(String firstName, String lastName, long id, String email, LocalDate birthDate, boolean enabled , String userName, String password){
        super(firstName,lastName,id,email,birthDate);
        this.enabled= enabled;
        this.userName=userName;
        this.password= password;
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


    @Override
    public String toString() {
        return super.toString() + "\n" + "Agent additional information: " + "\n" +
                "User name: " + userName + "\n" +
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

