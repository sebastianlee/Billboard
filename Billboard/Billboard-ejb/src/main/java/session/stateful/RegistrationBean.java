/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateful;

import entity.SystemUser;
import entity.SystemUserDetails;
import java.util.Random;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Forde
 */
@Stateful
public class RegistrationBean implements RegistrationBeanRemote {

    @PersistenceContext
    private EntityManager em;

    public String register(String email, String password, String gName, String fName, String age) {
        System.out.println("SB " + email);
        System.out.println("SB " + password);
        System.out.println("SB " + gName);
        System.out.println("SB " + fName);
        System.out.println("SB " + age);

        Random r = new Random();
        Long id = r.nextLong();

        SystemUserDetails systemUserDetails = new SystemUserDetails();
        systemUserDetails.setId(id);
        systemUserDetails.setEmail(email);
        systemUserDetails.setGivenName(gName);
        systemUserDetails.setFamilyName(fName);
        systemUserDetails.setAge(age);
        systemUserDetails.setContactNo("");
        systemUserDetails.setStatus("Active");

        SystemUser systemUser = new SystemUser();
        systemUser.setEmail(email);
        systemUser.setPassword(password);

        systemUser.setSystemUserDetails(systemUserDetails);

        System.out.println("OKAY OKAY OKAY");

        em.persist(systemUser);

        return "true";
    }
}
