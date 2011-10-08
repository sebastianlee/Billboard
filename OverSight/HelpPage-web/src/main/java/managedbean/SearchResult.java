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

@ManagedBean(name ="searchResult")
@RequestScoped

public class SearchResult {

    @EJB
    private SearchBeanRemote searchBean;
    private List<GameState> game;
    private List<GameState> gameReview;
    private GameState selectedGame;
    private String gameTitle;
    private String viewReview;
    private String developer;
    private Long gameId;
    private String googleDoc;
  

  public SearchResult() {
        selectedGame = new GameState();
    }

    public SearchBeanRemote getSearchBean() {
        return searchBean;
    }

    public void setSearchBean(SearchBeanRemote searchBean) {
        this.searchBean = searchBean;
    }

    public List<GameState> getGame() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(18000);
        this.gameTitle = session.getAttribute("query").toString();
        return searchBean.getResult(gameTitle);
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

    public String getSelect() throws IOException {
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(18000);

        String gamename = getSelectedGame().getGameTitle();
        session.setAttribute("gameName", gamename);

        gameId = getSelectedGame().getId();
        session.setAttribute("gameId", gameId);

        googleDoc = getSelectedGame().getGoogleDoc();
        session.setAttribute("googleDoc", googleDoc);


        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/OverSight-web/viewReview.xhtml");
        return null;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
    
    public String getDeveloper() {
        return developer;
    }

    public List<GameState> getGameReview() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(18000);
        this.gameTitle = session.getAttribute("gameName").toString();
        System.out.println("Game name when reached the last page:" + gameTitle);
        return searchBean.getGameReview(gameTitle);
    }

    public void setGameReview(List<GameState> gameReview) {
        this.gameReview = gameReview;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

}
