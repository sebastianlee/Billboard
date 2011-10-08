/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appHelper;

import entity.Game;
import entity.GameReview;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Forde
 */
public class GameState implements Serializable {

    private Long id;
    private String gameTitle;
    private String developer;
    private Date dateAndTime;
    private String mdaRating;
    private Long averageRating;
    private Long averageViolence;
    private Long averageEducation;
    private Long averageLang;
    private Long averageAddiction;
    private Set gameReviewStateSet = new HashSet<GameReviewState>();
    private String facebookName;
    private Long gameNumber;
    private String twitter;
    private String googleDoc;
    

    public GameState() {}

    public GameState(Game g) {
        this.setId(g.getId());
        this.setGameTitle(g.getGameTitle());
        this.setDeveloper(g.getDeveloper());
        this.setDateAndTime(g.getDateAndTime());
        this.setMdaRating(g.getMdaRating());
        this.setAverageRating(g.getAverageRating());
        this.setAverageViolence(g.getAverageViolence());
        this.setAverageEducation(g.getAverageEducation());
        this.setAverageLang(g.getAverageLang());
        this.setAverageAddiction(g.getAverageAddiction());
        this.setGameNumber(g.getGameNumber());
        this.setFacebookName(g.getFacebookName());
        this.setTwitter(g.getTwitter());
        this.setGoogleDoc(g.getGoogledoc());

       

        if(g.getGameReview() != null) {
            for(GameReview gr : g.getGameReview()) {
                GameReviewState grs = new GameReviewState(gr);
                getGameReviewStateSet().add(grs);
            }
        }
    }

    public GameState(Game g, Object o) {
        this.setId(g.getId());
        this.setGameTitle(g.getGameTitle());
        this.setDeveloper(g.getDeveloper());
        this.setDateAndTime(g.getDateAndTime());
        this.setMdaRating(g.getMdaRating());
        this.setAverageRating(g.getAverageRating());
        this.setAverageViolence(g.getAverageViolence());
        this.setAverageEducation(g.getAverageEducation());
        this.setAverageLang(g.getAverageLang());
        this.setAverageAddiction(g.getAverageAddiction());
        this.setFacebookName(g.getFacebookName());
        this.setGameNumber(g.getGameNumber());
        this.setTwitter(g.getTwitter());
        this.setGoogleDoc(g.getGoogledoc());
    }

    public Long getAverageAddiction() {
        return averageAddiction;
    }

    public void setAverageAddiction(Long averageAddiction) {
        this.averageAddiction = averageAddiction;
    }

    public Long getAverageEducation() {
        return averageEducation;
    }

    public void setAverageEducation(Long averageEducation) {
        this.averageEducation = averageEducation;
    }

    public Long getAverageLang() {
        return averageLang;
    }

    public void setAverageLang(Long averageLang) {
        this.averageLang = averageLang;
    }

    public Long getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Long averageRating) {
        this.averageRating = averageRating;
    }

    public Long getAverageViolence() {
        return averageViolence;
    }

    public void setAverageViolence(Long averageViolence) {
        this.averageViolence = averageViolence;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Set getGameReviewStateSet() {
        return gameReviewStateSet;
    }

    public void setGameReviewStateSet(Set gameReviewStateSet) {
        this.gameReviewStateSet = gameReviewStateSet;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMdaRating() {
        return mdaRating;
    }

    public void setMdaRating(String mdaRating) {
        this.mdaRating = mdaRating;
    }


    public Long getGameNumber() {
        return gameNumber;
    }


    public void setGameNumber(Long gameNumber) {
        this.gameNumber = gameNumber;
    }


    public String getFacebookName() {
        return facebookName;
    }

    public void setFacebookName(String facebookName) {
        this.facebookName = facebookName;
    }
    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    /**
     * @return the googleDoc
     */
    public String getGoogleDoc() {
        return googleDoc;
    }

    /**
     * @param googleDoc the googleDoc to set
     */
    public void setGoogleDoc(String googleDoc) {
        this.googleDoc = googleDoc;
    }
}
