/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateful;

import appHelper.GameReviewState;
import entity.Game;
import entity.GameReview;
import javax.ejb.Remote;
import java.util.List;

/**
 *
 * @author Irvin Neo
 */
@Remote
public interface CreateReviewSBRemote {

    public String SubmitReviewByParent(Long gameId, String email, Long violence, Long addictive, Long lang, Long education, String reviewText);

    public List<GameReviewState> getParentReviewList(Long gameId);

    public GameReview getGameReview(Long gameReviewId);

    public GameReviewState getGameReviewState(Long gameReviewId);

    public String likeReview(Long gameReviewId, String email);

    public String dislikeReview(Long gameReviewId, String email);

    public Game getGame(Long gameId);
}
