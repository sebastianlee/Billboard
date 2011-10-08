package managedbean;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import session.stateful.LoginBeanRemote;

@ManagedBean(name = "loginMB")
@RequestScoped
public class LoginMB {

    @EJB
    private LoginBeanRemote lbRemote;
    private String userId;
    private String password;
    private String email;
    private String status;
    private String errorMsg = "";

    /** Creates a new instance of LoginMB */
    public LoginMB() {
    }

    public String checkStatus() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession(false);
            session.setMaxInactiveInterval(18000);
            userId = session.getAttribute("usersId").toString();
            if (userId.equals("")) {
            } else {
                session.setAttribute("usersId", userId);
            }

        } catch (NullPointerException npe) {
        }
        return userId;
    }

    public void checkLogin() throws IOException {
        String result = lbRemote.checkLogin(userId, password, status);

        if (result.equals("pass")) {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession(false);
            session.setMaxInactiveInterval(18000);
            session.setAttribute("usersId", userId);
            session.setAttribute("status", status);
            System.out.println("Login Successful");
            FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/Billboard-web/index.xhtml");
        } else {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession(false);
            session.setAttribute("LoginStatus", "fail");
            errorMsg = "Username & Password doesn't match";
            System.out.println("Login Fail");
        }
    }

     public void register() throws IOException {
        String result = lbRemote.register(userId, password, status);

        if (result.equals("pass")) {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession(false);
            session.setMaxInactiveInterval(18000);
            session.setAttribute("usersId", userId);
            session.setAttribute("status", status);
            System.out.println("Login Successful");
            FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/Billboard-web/index.xhtml");
        } else {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession(false);
            session.setAttribute("LoginStatus", "fail");  
            System.out.println("Registration Fail");
        }
    }


    public void addError(ActionEvent actionEvent) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sample error message", errorMsg));
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
