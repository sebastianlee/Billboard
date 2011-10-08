package session.stateful;

import appHelper.GameState;
import entity.Game;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class SearchBean implements SearchBeanRemote {

    @PersistenceContext
    private EntityManager em;

        @Override
    public List<GameState> getResult(String strquery){

        Query query = em.createQuery("SELECT a FROM Game a");
        List stateList = new ArrayList();
        for (Object o : query.getResultList()) {
            Game gm = (Game) o;
            em.refresh(gm);
           if (gm.getGameTitle().toUpperCase().contains(strquery.toUpperCase())){
            GameState gmState = new GameState(gm);
            stateList.add(gmState);
           }
            
        }
        return stateList;
    }

    @Override
        public List<GameState> getGameReview(String query){
            Query query1 = em.createQuery("SELECT a FROM Game a WHERE a.gameTitle=:gameTitle");
            query1.setParameter("gameTitle", query);
            List stateList = new ArrayList();
        for (Object o : query1.getResultList()) {
            Game gm = (Game) o;
            em.refresh(gm);
            GameState gmState = new GameState(gm);
            stateList.add(gmState);
        }
        return stateList;
        }
 
}
