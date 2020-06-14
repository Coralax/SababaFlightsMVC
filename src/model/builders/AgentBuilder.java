package model.builders;
import model.objects.Agent;
import java.time.LocalDate;

public class AgentBuilder {

    private String firstName, lastName, email, userName, password;
    private int agentCode, permissionLevel;
    private boolean isVerified;
    private long id;
    private LocalDate birthDate;

    public AgentBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AgentBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AgentBuilder email(String email) {
        this.email = email;
        return this;
    }

    // Password should be implemented in the AgentRepositoryImpl

    public AgentBuilder agentCode(int agentCode) {
        this.agentCode = agentCode;
        return this;
    }

    public AgentBuilder permissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
        return this;
    }

    public AgentBuilder isVerified(boolean isVerified) {
        this.isVerified = isVerified;
        return this;
    }

    public AgentBuilder id(long id) {
        this.id = id;
        return this;
    }

    public AgentBuilder birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Agent build() {
        Agent agent = new Agent();
        agent.setFirstName(this.firstName);
        agent.setLastName(this.lastName);
        agent.setEmail(this.email);
        agent.setUserName(this.userName);
        agent.setAgentCode(this.agentCode);
        agent.setPermissionLevel(this.permissionLevel);
        agent.setIsVerified(this.isVerified);
        agent.setAgentCode(this.agentCode);
        agent.setBirthDate(this.birthDate);
        agent.setId(this.id);
        return agent;
    }

}
