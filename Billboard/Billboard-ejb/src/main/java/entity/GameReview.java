/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Forde
 */
@Entity
public class GameReview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userEmail;
    private Long userRating;
    @Temporal(value = TemporalType.DATE)
    private Date dateAndTime;
    private Long violence;
    private Long education;
    private Long lang;
    private Long addiction;
    private String comments;

    @ManyToOne
    private Game game;
    @ManyToOne
    private SystemUser systemUser;
    
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "gameReview")
    private Set<LikeType> likeType = new HashSet<LikeType>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<LikeType> getLikeType() {
        return likeType;
    }

    public void setLikeType(Set<LikeType> likeType) {
        this.likeType = likeType;
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

    public Long getLang() {
        return lang;
    }

    public void setLang(Long lang) {
        this.lang = lang;
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameReview)) {
            return false;
        }
        GameReview other = (GameReview) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.GameReview[id=" + id + "]";
    }
}
