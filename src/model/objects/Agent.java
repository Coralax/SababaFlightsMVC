package model.objects;

import model.repository.AgentRepository;
import model.repository.AgentRepositoryImpl;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class Agent extends Person {

    private String userName, password;
    private int agentCode;
    private boolean isVerified;
    private int permissionLevel;

    public Agent() { super(); }

    public Agent(long id, String firstName, String lastName, String email, String userName, String password, int agentCode, String birthDateStr) {
        super(firstName, lastName, email, id, birthDateStr);
        this.userName = userName;
        this.password = password;
        this.agentCode = agentCode;
    }



    // Setters (which will be used by the builder)
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        // TODO: encrypt password (implement password encryption in agent repository)
//        this.password = this.agentRepository.encryptPassword(password);
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
        return this.userName;
    }
    public int getAgentCode() {
        return this.agentCode;
    }
    public boolean isVerified() { return this.isVerified; }
    public int getPermissionLevel() { return this.permissionLevel; }
    public String getPassword() { return this.password; }

    @Override
    public String toString() {
        return "Agent{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", agentCode=" + agentCode +
                ", isVerified=" + isVerified +
                ", permissionLevel=" + permissionLevel +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                '}';
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

