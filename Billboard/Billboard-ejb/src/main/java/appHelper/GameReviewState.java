/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appHelper;

import entity.GameReview;
import entity.LikeType;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Forde
 */
public class GameReviewState implements Serializable {

    private Long id;
    private String userEmail;
    private Long userRating;
    private Date dateAndTime;
    private Long violence;
    private Long education;
    private Long lang;
    private Long addiction;
    private String comments;
    private GameState gameState;
    private SystemUserState systemUserState;
    private Set likeTypeStateSet = new HashSet<LikeTypeState>();

    public GameReviewState(GameReview g) {
        this.setId(g.getId());
        this.setUserEmail(g.getUserEmail());
        this.setUserRating(g.getUserRating());
        this.setDateAndTime(g.getDateAndTime());
        this.setViolence(g.getViolence());
        this.setEducation(g.getEducation());
        this.setLang(g.getLang());
        this.setAddiction(g.getAddiction());
        this.setComments(g.getComments());

        this.setGameState(new GameState(g.getGame(), this));
        this.setSystemUserState(new SystemUserState(g.getSystemUser(), this));

        if(g.getLikeType() != null) {
            for(LikeType l : g.getLikeType()) {
                LikeTypeState ls = new LikeTypeState(l);
                getLikeTypeStateSet().add(ls);
            }
        }
    }

    public GameReviewState(GameReview g, Object o) {
        this.setId(g.getId());
        this.setUserEmail(g.getUserEmail());
        this.setUserRating(g.getUserRating());
        this.setDateAndTime(g.getDateAndTime());
        this.setViolence(g.getViolence());
        this.setEducation(g.getEducation());
        this.setLang(g.getLang());
        this.setAddiction(g.getAddiction());
        this.setComments(g.getComments());
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public SystemUserState getSystemUserState() {
        return systemUserState;
    }

    public void setSystemUserState(SystemUserState systemUserState) {
        this.systemUserState = systemUserState;
    }

    public Long getAddiction() {
        return addiction;
    }

    public void setAddiction(Long addiction) {
        this.addiction = addiction;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Long getEducation() {
        return education;
    }

    public void setEducation(Long education) {
        this.education = education;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLang() {
        return lang;
    }

    public void setLang(Long lang) {
        this.lang = lang;
    }

    public Set getLikeTypeStateSet() {
        return likeTypeStateSet;
    }

    public void setLikeTypeStateSet(Set likeTypeStateSet) {
        this.likeTypeStateSet = likeTypeStateSet;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getUserRating() {
        return userRating;
    }

    public void setUserRating(Long userRating) {
        this.userRating = userRating;
    }

    public Long getViolence() {
        return violence;
    }

    public void setViolence(Long violence) {
        this.violence = violence;
    }
    
}
