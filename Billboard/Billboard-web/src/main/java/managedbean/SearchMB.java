package managedbean;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name="searchMB")
@RequestScoped
public class SearchMB {
    private String query;

    /** Creates a new instance of TestMB */
    public SearchMB() {
    }

    public void addsearch() throws IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(18000);
        session.setAttribute("query", query);

        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/OverSight-web/searchResult.xhtml");
     
    }
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }

}
