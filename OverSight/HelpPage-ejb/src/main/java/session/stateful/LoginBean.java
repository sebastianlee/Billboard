/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package session.stateful;

import entity.SystemUser;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Forde
 */
@Stateful
public class LoginBean implements LoginBeanRemote {

    @PersistenceContext
    private EntityManager em;
    
    public String checkLogin(String userId, String password) {
        SystemUser systemUser = em.find(SystemUser.class, userId);

        if (systemUser == null) {
            return "null";
        } else if (systemUser.getPassword().equals(password)) {
            return "pass";
        } else {
            return "fail";
        }
    }
    
}
