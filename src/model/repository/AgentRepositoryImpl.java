package model.repository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//import model.objects.Order;

public class AgentRepositoryImpl implements AgentRepository {

    private final String agentFile = "SababaFlights\\src\\data\\agents.json";
    private final String adminFile = "SababaFlights\\src\\data\\admin.json";
//    private Set<Agent> agents;
//    private AgentSingleton agentSingletonInstance;

//    public AgentRepositoryImpl() {
//        this.agentSingletonInstance = AgentSingleton.getInstance();
//        this.agents = agentSingletonInstance.agentSet;
//    }

    @Override
    public String encryptPassword(String password) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(password.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1,digest);
            StringBuilder hashtext = new StringBuilder(bigInt.toString(16));
            // Now we need to zero pad it if you actually want the full 32 chars.
            while(hashtext.length() < 32 ){
                hashtext.insert(0, "0" ).append(hashtext);
            }
            return hashtext.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return password;
    }

//     we need to verify if the first if is required because the AuthenticationService should prevent it
//    @Override
//    public void add(Agent agent) throws Exception {
//
//        Set<Agent> agents = AgentSingleton.getInstance().agentSet;
//
//        if(agent == null){
//            throw new Exception(("must have a value"));
//        }
//        if(agents.contains(agent)){
//            throw new Exception("Agent already exist!");
//        }
//        agents.add(agent);
//        AgentSingleton.getInstance().saveSet(agents);
//
//    }

//    @Override
//    public void delete(int agentCode) {
//         need to implement delete in FileManger
//    }

    //check if there is a shorter way to find agent by agent code if this is a set
//    @Override
//    public Agent find(int agentCode) {
//        for (Agent agent : this.agents) {
//            if (agent.getAgentCode() == agentCode) {
//                return agent;
//            }
//        }
//        return null;
//
//    }

//    @Override
//    public List<Order> findAllOrdersForAgent(int agentCode) {
//        return null;
//    }
//
//    @Override
//    public List<Order> findAllOrdersForAgentByDate(int agentCode, LocalDate begin, LocalDate end) {
//        return null;
//    }
}
