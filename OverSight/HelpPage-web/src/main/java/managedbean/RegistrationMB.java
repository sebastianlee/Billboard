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
import session.stateful.RegistrationBeanRemote;

/**
 *
 * @author Forde
 */
@ManagedBean(name="registrationMB")
@RequestScoped
public class RegistrationMB {
    @EJB
    private RegistrationBeanRemote rbRemote;
    private String email;
    private String password;
    private String gName;
    private String fName;
    private String age;

    /** Creates a new instance of RegistrationMB */
    public RegistrationMB() {
    }

    public void register() throws IOException {
        System.out.println("MB " + email);
        System.out.println("MB " + password);
        System.out.println("MB " + gName);
        System.out.println("MB " + fName);
        System.out.println("MB " + age);

        rbRemote.register(email, password, gName, fName, age);

        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/OverSight-web/login.xhtml");
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
