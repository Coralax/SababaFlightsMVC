package model.repository;

import model.objects.Agent;
import model.singletons.AgentSingleton;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

//import model.objects.Order;

public class AgentRepositoryImpl implements AgentRepository {

    private Set<Agent> agentSet;

    public AgentRepositoryImpl() {
        this.agentSet = AgentSingleton.getInstance().agentSet;
    }

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

    @Override
    public Agent getAgentById(long id) {
        for (Agent agent : this.agentSet) {
            if (agent.getId() == id) {
                return agent;
            }
        }
        System.out.println("Could not find an agent with this id");
        return null;
    }
}
