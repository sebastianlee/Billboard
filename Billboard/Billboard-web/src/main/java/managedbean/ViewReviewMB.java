package managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import javax.faces.context.FacesContext;
import session.stateful.SearchBeanRemote;
import appHelper.GameState;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name ="viewReviewMB")
@RequestScoped

public class ViewReviewMB {

    @EJB
    private SearchBeanRemote searchBean;
    private List<GameState> game;
    private List<GameState> gameReview;
    private GameState selectedGame;
    private String gameTitle;
    private String viewReview;
    private String developer;
    private String googleDoc;
  

  public ViewReviewMB() {
        selectedGame = new GameState();
    }

    public SearchBeanRemote getSearchBean() {
        return searchBean;
    }

    public void setSearchBean(SearchBeanRemote searchBean) {
        this.searchBean = searchBean;
    }
    public void setGame(List<GameState> game) {
        this.game = game;
    }

    public GameState getSelectedGame() {
        return selectedGame;
    }

    public void setSelectedGame(GameState selectedGame) {
        this.selectedGame = selectedGame;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
    
    public String getDeveloper() {
        return developer;
    }

    public String getViewReview() {
        return viewReview;
    }

    public void setViewReview(String viewReview) {
        this.viewReview = viewReview;
    }

      public String getGoogleDoc() {
        return googleDoc;
    }

    public void setGoogleDoc(String googleDoc) {
        this.googleDoc = googleDoc;
    }

    public List<GameState> getGameReview() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(18000);
        this.gameTitle = session.getAttribute("gameName").toString();
        return searchBean.getGameReview(gameTitle);
    }

    public void setGameReview(List<GameState> gameReview) {
        this.gameReview = gameReview;
    }

    public String viewMoreInfo() throws IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(18000);
        System.out.println("For Irvin:" + gameTitle);

        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/OverSight-web/ViewParentReviews.xhtml");
        return null;
    }

        public String viewGamespot() throws IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(18000);
        this.gameTitle = session.getAttribute("gameName").toString();
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://asia.gamespot.com/search.html?qs="+gameTitle+"&om_act=convert&om_clk=search");
        return null;
    }

        public String viewGoogle() throws IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(18000);
        this.googleDoc = session.getAttribute("googleDoc").toString();
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://api.addthis.com/oexchange/0.8/forward/google/offer?url=http%3A%2F%2F"+ googleDoc +"%2F&username=vasiliikondratev");

        return null;
    }

        public String viewIgn() throws IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(18000);
        this.gameTitle = session.getAttribute("gameName").toString();
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://search.ign.com/article?query="+ gameTitle );

        return null;
    }

       public String viewGamezone() throws IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(18000);
        this.gameTitle = session.getAttribute("gameName").toString();
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://www.gamezone.com/search/search_results/?cx=012475291702510425601%3Aypfnb3twwug&cof=FORID%3A9&ie=UTF-8&q="+gameTitle+"&sa=Search&siteurl=www.gamezone.com%2F#1152");

        return null;
    }
       public String viewMda() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("https://app.mda.gov.sg/classification/Search/VideoGames/");
        return null;
    }
   
  


}
