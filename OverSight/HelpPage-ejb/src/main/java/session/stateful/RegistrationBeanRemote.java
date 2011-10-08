/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package session.stateful;

import javax.ejb.Remote;

/**
 *
 * @author Forde
 */
@Remote
public interface RegistrationBeanRemote {
    public String register(String email, String password, String gName, String fName, String age);
}
