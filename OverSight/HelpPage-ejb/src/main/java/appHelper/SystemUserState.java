/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appHelper;

import entity.GameReview;
import entity.LikeType;
import entity.SystemUser;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Forde
 */
public class SystemUserState implements Serializable {

    private String email;
    private String password;
    private SystemUserDetailsState systemUserDetailsState;
    private Set gameReviewStateSet = new HashSet<GameReviewState>();
    private Set likeTypeStateSet = new HashSet<LikeTypeState>();

    public SystemUserState(SystemUser s) {
        this.setEmail(s.getEmail());
        this.setPassword(s.getPassword());
        this.setSystemUserDetailsState(new SystemUserDetailsState(s.getSystemUserDetails()));

        if(s.getGameReview() != null) {
            for(GameReview g : s.getGameReview()) {
                GameReviewState gs = new GameReviewState(g);
                getGameReviewStateSet().add(gs);
            }
        }

        if(s.getLikeType() != null) {
            for(LikeType l : s.getLikeType()) {
                LikeTypeState ls = new LikeTypeState(l);
                getLikeTypeStateSet().add(ls);
            }
        }
    }

    public SystemUserState(SystemUser s, Object o) {
        this.setEmail(s.getEmail());
        this.setPassword(s.getPassword());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set getGameReviewStateSet() {
        return gameReviewStateSet;
    }

    public void setGameReviewStateSet(Set gameReviewStateSet) {
        this.gameReviewStateSet = gameReviewStateSet;
    }

    public Set getLikeTypeStateSet() {
        return likeTypeStateSet;
    }

    public void setLikeTypeStateSet(Set likeTypeStateSet) {
        this.likeTypeStateSet = likeTypeStateSet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SystemUserDetailsState getSystemUserDetailsState() {
        return systemUserDetailsState;
    }

    public void setSystemUserDetailsState(SystemUserDetailsState systemUserDetailsState) {
        this.systemUserDetailsState = systemUserDetailsState;
    }
    
}
