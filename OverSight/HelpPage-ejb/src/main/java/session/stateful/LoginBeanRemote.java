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
public interface LoginBeanRemote {
    public String checkLogin(String userId, String password);
}
