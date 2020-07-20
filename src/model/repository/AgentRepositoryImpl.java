package model.repository;

import model.objects.Agent;
import model.filemanager.AgentFileManager;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.Set;

//import model.objects.Order;

public class AgentRepositoryImpl implements AgentRepository {

    private Set<Agent> agentSet;

    public AgentRepositoryImpl() {
        this.agentSet = AgentFileManager.getInstance().agentSet;
    }

    //MD5 password Encryption
    @Override
    public String encryptPassword(String password) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(password.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1,digest);
            StringBuilder hashtext = new StringBuilder(bigInt.toString(16));
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
        System.out.println("\n"+"Could not find an agent with this id!" +"\n");
        return null;
    }

    public  boolean removeAgent(long id)
    {
        if(getAgentById(id).getPermissionLevel()==10)
        {
            System.out.println("\n"+"Can not remove an admin!"+"\n");
            return false;
        }
        if(getAgentById(id) ==null)
        {
            System.out.println("\n"+"Agent does not exist!"+"\n");
            return false;
        }
        else
        {
            AgentFileManager.getInstance().agentSet.remove(getAgentById(id));
            AgentFileManager.getInstance().saveSet(agentSet);
            return true;
        }
    }

    public  boolean changePermissionLevel(long id)
    {
        int level;
        Agent agent =getAgentById(id);
        if(agent.getPermissionLevel()==10){
            System.out.println("\n"+"Can not change admin's permission level!"+"\n");
            return false;
        }
        if(agent==null)
        {
            System.out.println("\n"+"Agent does not exist!"+"\n");
            return false;
        }
        Scanner scanner=new Scanner(System.in);
        do {
            System.out.print("Please enter the permission level, in the range of 1-10: ");
            level = scanner.nextInt();
        }while(level<1 || level>10);

        agent.setPermissionLevel(level);
        AgentFileManager.getInstance().agentSet.remove(getAgentById(id));
        agentSet.add(agent);
        AgentFileManager.getInstance().saveSet(agentSet);
        return true;
    }

   public boolean changeEmailAddress(long id,String email){
       Agent agent =getAgentById(id);
       if(agent.getPermissionLevel()==10){
           System.out.println("\n"+"Can not change an admin's email!"+"\n");
           return false;
       }
       if(agent==null)
       {
           System.out.println("\n"+"Agent does not exist!"+"\n");
           return false;
       }
       else
       {
           agent.setEmail(email);
           AgentFileManager.getInstance().agentSet.remove(getAgentById(id));
           agentSet.add(agent);
           AgentFileManager.getInstance().saveSet(agentSet);
       }
       return true;
    }
}
