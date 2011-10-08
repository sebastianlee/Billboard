/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import appHelper.GameReviewState;
import appHelper.LikeTypeState;
import entity.Game;
import entity.GameReview;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.*;
import session.stateful.CreateReviewSBRemote;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Irvin Neo
 */
@ManagedBean(name = "createReviewMB")
@RequestScoped
public class CreateReviewMB {

    @EJB
    private CreateReviewSBRemote crsb;
    private Long rateViolence;
    private Long rateAddictive;
    private Long rateCoarseLanguage;
    private Long rateEducation;
    private String reviewText;
    private String gameTitle;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private FacesContext context = FacesContext.getCurrentInstance();
    private HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    private HttpSession session = request.getSession(false);

    /** Creates a new instance of CreateReviewMB */
    public CreateReviewMB() {
    }

    public void submitReviewByParent() throws IOException {
        //long gameId = 1;
        //String userEmail = "test@test.com";

        String userEmail = (String) session.getAttribute("userEmail");
        long gameId = (Long) session.getAttribute("gameId");

        if (crsb.SubmitReviewByParent(gameId, userEmail, rateViolence, rateAddictive, rateCoarseLanguage, rateEducation, reviewText).equals("S")) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/OverSight-web/submitReviewResult.xhtml");
        }

    }

    public List<GameReviewState> getGameReviewList() {

        long gameId = (Long) session.getAttribute("gameId");
        //long gameId = 1;
        return crsb.getParentReviewList(gameId);


    }

    public String reviewNameNdate(long id) {
        GameReview gr = crsb.getGameReview(id);

        return gr.getSystemUser().getSystemUserDetails().getFamilyName() + " " + gr.getSystemUser().getSystemUserDetails().getGivenName() + " (" + sdf.format(gr.getDateAndTime()) + ")";
    }

    public String retrieveLikeCount(long reviewId) {
        GameReviewState grs = crsb.getGameReviewState(reviewId);
        int like = 0;
        if (grs.getLikeTypeStateSet() != null) {
            Set<LikeTypeState> tempSet = grs.getLikeTypeStateSet();
            for (LikeTypeState lts : tempSet) {
                if (lts.getType().equals("Like")) {
                    like += 1;
                }
            }
        }

        return "" + like;
    }

    public String retrieveDislikeCount(long reviewId) {
        GameReviewState grs = crsb.getGameReviewState(reviewId);
        int dislike = 0;
        if (grs.getLikeTypeStateSet() != null) {
            Set<LikeTypeState> tempSet = grs.getLikeTypeStateSet();
            for (LikeTypeState lts : tempSet) {
                if (lts.getType().equals("Dislike")) {
                    dislike += 1;
                }
            }
        }

        return "" + dislike;
    }

    public void likeAreview(long reviewId) throws IOException {
        String email =(String) session.getAttribute("userEmail");

        //String email = "test@test.com";
        String result = crsb.likeReview(reviewId, email);

        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/OverSight-web/ViewParentReviews.xhtml");
    }

    public void dislikeAreview(long reviewId) throws IOException {
        String email =(String) session.getAttribute("userEmail");

        //String email = "test@test.com";
        String result = crsb.dislikeReview(reviewId, email);

        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/OverSight-web/ViewParentReviews.xhtml");
    }

    public void goToSubmitReviewForm() throws IOException {

        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/OverSight-web/createParentReviewForm.xhtml");
    }

    public String getGameTitle() {
        long gameId = (Long) session.getAttribute("gameId");
        //long gameId = 1;
        Game g = crsb.getGame(gameId);
        return g.getGameTitle();
    }

    /**
     * @return the reviewText
     */
    public String getReviewText() {
        return reviewText;
    }

    /**
     * @param reviewText the reviewText to set
     */
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    /**
     * @return the rateViolence
     */
    public Long getRateViolence() {
        return rateViolence;
    }

    /**
     * @param rateViolence the rateViolence to set
     */
    public void setRateViolence(Long rateViolence) {
        this.rateViolence = rateViolence;
    }

    /**
     * @return the rateAddictive
     */
    public Long getRateAddictive() {
        return rateAddictive;
    }

    /**
     * @param rateAddictive the rateAddictive to set
     */
    public void setRateAddictive(Long rateAddictive) {
        this.rateAddictive = rateAddictive;
    }

    /**
     * @return the rateCoarseLanguage
     */
    public Long getRateCoarseLanguage() {
        return rateCoarseLanguage;
    }

    /**
     * @param rateCoarseLanguage the rateCoarseLanguage to set
     */
    public void setRateCoarseLanguage(Long rateCoarseLanguage) {
        this.rateCoarseLanguage = rateCoarseLanguage;
    }

    /**
     * @return the rateEducation
     */
    public Long getRateEducation() {
        return rateEducation;
    }

    /**
     * @param rateEducation the rateEducation to set
     */
    public void setRateEducation(Long rateEducation) {
        this.rateEducation = rateEducation;
    }

    /**
     * @param gameTitle the gameTitle to set
     */
    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }
}
