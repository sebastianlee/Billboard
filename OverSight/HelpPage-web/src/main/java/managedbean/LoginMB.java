/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import session.stateful.LoginBeanRemote;

/**
 *
 * @author Forde
 */
@ManagedBean(name = "loginMB")
@RequestScoped
public class LoginMB {

    @EJB
    private LoginBeanRemote lbRemote;
    private String userId;
    private String password;

    /** Creates a new instance of LoginMB */
    public LoginMB() {
    }

    public void checkLogin() throws IOException {
        String result = lbRemote.checkLogin(userId, password);

        if (result.equals("pass")) {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession(false);
            session.setAttribute("userEmail", userId);
            System.out.println("Login Successful");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/OverSight-web/" + "" + ".xhtml");
        }
    }

    public void logout() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession(false);
        session.removeAttribute("userId");
        //FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/OverSight-web/" + "" + ".xhtml");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
