package model.filemanager;

import model.objects.Agent;
import java.util.Set;

public class AgentFileManager extends FileManager<Agent> {

    private static AgentFileManager agentFileManagerInst = null;
    public Set<Agent> agentSet;

    private AgentFileManager() {
        super("src/data/agents.json");
        agentSet = this.read(Agent.class);
    }

    public static AgentFileManager getInstance() {
        if (agentFileManagerInst == null)
            agentFileManagerInst = new AgentFileManager();

        return agentFileManagerInst;
    }

}
