package model.repository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//import model.objects.Order;

public class AgentRepositoryImpl implements AgentRepository {

    private final String agentFile = "SababaFlights\\src\\data\\agents.json";
    private final String adminFile = "SababaFlights\\src\\data\\admin.json";

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

}
