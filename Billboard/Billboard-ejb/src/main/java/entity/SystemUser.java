/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Forde
 */
@Entity
public class SystemUser implements Serializable {
    @Id
    private String email;
    private String password;
    private String status;

    @OneToOne(cascade={CascadeType.ALL})
    private SystemUserDetails systemUserDetails;

    @OneToMany(cascade={CascadeType.ALL}, mappedBy="systemUser")
    private Set<GameReview> gameReview = new HashSet<GameReview>();

    @OneToMany(cascade={CascadeType.ALL}, mappedBy="systemUser")
    private Set<LikeType> likeType = new HashSet<LikeType>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SystemUserDetails getSystemUserDetails() {
        return systemUserDetails;
    }

    public void setSystemUserDetails(SystemUserDetails systemUserDetails) {
        this.systemUserDetails = systemUserDetails;
    }

    public Set<GameReview> getGameReview() {
        return gameReview;
    }

    public void setGameReview(Set<GameReview> gameReview) {
        this.gameReview = gameReview;
    }

    public Set<LikeType> getLikeType() {
        return likeType;
    }

    public void setLikeType(Set<LikeType> likeType) {
        this.likeType = likeType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
