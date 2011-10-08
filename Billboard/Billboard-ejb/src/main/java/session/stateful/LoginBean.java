package session.stateful;

import entity.SystemUser;
import entity.SystemUserDetails;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class LoginBean implements LoginBeanRemote {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public String checkLogin(String userId, String password, String status) {
        SystemUser systemUser = em.find(SystemUser.class, userId);

        if (systemUser == null) {
            return "null";
        } else if (systemUser.getPassword().equals(password)) {
            return "pass";
        } else if (systemUser.getStatus().equals("registered")){
            return "registered";
        } else {
            return "fail";
        }
    }

    @Override
    public String register(String userId, String password, String status) {
        SystemUserDetails sd = new SystemUserDetails();
         SystemUser su = new SystemUser();
        try{
            sd.setEmail(userId);
            sd.setEmail(userId);
            sd.setStatus("unregistered");

            su.setEmail(userId);
            su.setPassword(password);
            su.setStatus("unregistered");

            em.persist(sd);
            em.persist(su);

            return "pass";

        } catch (Exception e) {
            return "Failed";
        }
 
    }
    
}
