/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateful;

import appHelper.GameReviewState;
import entity.Game;
import entity.GameReview;
import entity.LikeType;
import entity.SystemUser;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.persistence.Query;

/**
 *
 * @author Irvin Neo
 */
@Stateful
public class CreateReviewSB implements CreateReviewSBRemote {

    @PersistenceContext
    private EntityManager em;

    public String SubmitReviewByParent(Long gameId, String email, Long violence, Long addictive, Long lang, Long education, String reviewText) {

        try {

            Game g = em.find(Game.class, gameId);
            SystemUser su = em.find(SystemUser.class, email);
            GameReview gr = new GameReview();

            violence = violence * 2;
            addictive = addictive * 2;
            lang = lang * 2;
            education = education * 2;

            long tempRating = (5 - violence + 5 - addictive + 5 - lang + education - 5);
            long userRating = tempRating / 2;

            System.out.println("TempRating = " + tempRating + " and userRating is " + userRating);

            Calendar c1 = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm:ss a");
            Date submitDate = sdf.parse(sdf.format(c1.getTime()));

            gr.setAddiction(addictive);
            gr.setEducation(education);
            gr.setViolence(violence);
            gr.setLang(lang);
            gr.setUserRating(userRating);
            gr.setUserEmail(email);
            gr.setComments(reviewText);

            gr.setSystemUser(su);
            gr.setGame(g);
            gr.setDateAndTime(submitDate);

            g.getGameReview().add(gr);

            em.persist(gr);
            em.persist(g);

            long avgUserRating = 0;
            long avgViolence = 0;
            long avgAddictive = 0;
            long avgLang = 0;
            long avgEducation = 0;

            if (g.getGameReview() != null || g.getGameReview().size() != 0) {

                for (GameReview o : g.getGameReview()) {
                    avgUserRating += o.getUserRating();
                    avgViolence += o.getViolence();
                    avgAddictive += o.getAddiction();
                    avgLang += o.getLang();
                    avgEducation += o.getEducation();
                }
            }

            System.out.println("total Rating is " + avgUserRating + " and avg rating is " + avgUserRating / g.getGameReview().size() + " and size is " + g.getGameReview().size());

            g.setAverageRating(avgUserRating / g.getGameReview().size());
            g.setAverageViolence(avgViolence / g.getGameReview().size());
            g.setAverageAddiction(avgAddictive / g.getGameReview().size());
            g.setAverageLang(avgLang / g.getGameReview().size());
            g.setAverageEducation(avgEducation / g.getGameReview().size());

            em.persist(g);

            return "S";

        } catch (Exception e) {
            return "F";
        }
    }

    public List<GameReviewState> getParentReviewList(Long gameId) {
        /*Game g = em.find(Game.class, gameId);
        List stateList = new ArrayList();

        /*for (Object o : g.getGameReview()) {
            GameReviewState grs;

            grs = new GameReviewState((GameReview) o, this);
            stateList.add(grs);

        }*/
        List stateList = new ArrayList();
        Query q = em.createQuery("SELECT gr.id FROM GameReview gr WHERE gr.game.id='" + gameId + "' ORDER BY gr.dateAndTime ASC");

        for (Object o : q.getResultList()) {
            GameReview gr;
            GameReviewState grs;
            long id = Long.parseLong(o.toString());

            gr = em.find(GameReview.class, id);

            if (gr == null) {
                return null;
            } else {
                grs = new GameReviewState(gr);
                stateList.add(gr);
            }
        }

        return stateList;
    }

    public GameReview getGameReview(Long gameReviewId) {
        GameReview gr = em.find(GameReview.class, gameReviewId);

        return gr;
    }

    public GameReviewState getGameReviewState(Long gameReviewId) {
        GameReview gr = em.find(GameReview.class, gameReviewId);
        GameReviewState grs = new GameReviewState(gr);
        return grs;
    }

    public String likeReview(Long gameReviewId, String email) {

        try {

            GameReview gr = em.find(GameReview.class, gameReviewId);
            SystemUser su = em.find(SystemUser.class, email);

            Set<LikeType> ltSet = new HashSet<LikeType>();
            Calendar c1 = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm:ss a");
            Date likeDate = sdf.parse(sdf.format(c1.getTime()));

            LikeType lt = new LikeType();
            lt.setGameReview(gr);
            lt.setSystemUser(su);
            lt.setType("Like");
            lt.setUserEmail(email);
            lt.setDateAndTime(likeDate);

            if (gr.getLikeType() == null || gr.getLikeType().size() == 0 ) {
                ltSet.add(lt);
                gr.setLikeType(ltSet);
            } else {
                gr.getLikeType().add(lt);
            }

            em.persist(gr);

            return "S";

        } catch (Exception e) {
            return "F";
        }
    }

    public String dislikeReview(Long gameReviewId, String email) {

        try {

            GameReview gr = em.find(GameReview.class, gameReviewId);
            SystemUser su = em.find(SystemUser.class, email);

            Set<LikeType> ltSet = new HashSet<LikeType>();
            Calendar c1 = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm:ss a");
            Date likeDate = sdf.parse(sdf.format(c1.getTime()));

            LikeType lt = new LikeType();
            lt.setGameReview(gr);
            lt.setSystemUser(su);
            lt.setType("Dislike");
            lt.setUserEmail(email);
            lt.setDateAndTime(likeDate);

            if (gr.getLikeType() == null || gr.getLikeType().size() == 0 ) {
                ltSet.add(lt);
                gr.setLikeType(ltSet);
            } else {
                gr.getLikeType().add(lt);
            }

            em.persist(gr);

            return "S";

        } catch (Exception e) {
            return "F";
        }
    }

    public Game getGame(Long gameId) {
        Game g = em.find(Game.class, gameId);

        return g;
    }
}

