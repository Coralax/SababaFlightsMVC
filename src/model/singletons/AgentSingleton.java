package model.singletons;

import model.objects.Agent;
import java.util.Set;

public class AgentSingleton extends Singleton<Agent> {

    private static AgentSingleton agentSingletonInstance = null;
    public Set<Agent> agentSet;

    private AgentSingleton() {
        super("src/data/agents.json");
        agentSet = this.read(Agent.class);
    }

    public static AgentSingleton getInstance() {
        if (agentSingletonInstance == null)
            agentSingletonInstance = new AgentSingleton();

        return agentSingletonInstance;
    }

    public Agent getAgentById(int id) {
        for (Agent agent : this.agentSet) {
            if (agent.getId() == id) {
                return agent;
            }
        }
        System.out.println("Could not find an agent with this id");
        return null;
    }

}
