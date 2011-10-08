package session.stateful;

import appHelper.GameState;
import java.util.List;
import javax.ejb.Remote;


@Remote
public interface SearchBeanRemote {
     public List<GameState> getResult(String query);
     public List<GameState> getGameReview(String query);
}
