/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appHelper;

import entity.LikeType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Forde
 */
public class LikeTypeState implements Serializable {

    private Long id;
    private String type;
    private String userEmail;
    private Date dateAndTime;

    private GameReviewState gameReviewState;
    private SystemUserState systemUserState;

    public LikeTypeState(LikeType l) {
        this.setId(l.getId());
        this.setType(l.getType());
        this.setUserEmail(l.getUserEmail());
        this.setDateAndTime(l.getDateAndTime());

        this.setGameReviewState(new GameReviewState(l.getGameReview(), this));
        this.setSystemUserState(new SystemUserState(l.getSystemUser(), this));
    }

    public GameReviewState getGameReviewState() {
        return gameReviewState;
    }

    public void setGameReviewState(GameReviewState gameReviewState) {
        this.gameReviewState = gameReviewState;
    }

    public SystemUserState getSystemUserState() {
        return systemUserState;
    }

    public void setSystemUserState(SystemUserState systemUserState) {
        this.systemUserState = systemUserState;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
}
