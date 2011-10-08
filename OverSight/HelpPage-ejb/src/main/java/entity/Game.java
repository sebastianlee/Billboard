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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Forde
 */
@Entity
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String gameTitle;
    private String developer;
    @Temporal(value = TemporalType.DATE)
    private Date dateAndTime;
    private String mdaRating;
    private Long averageRating;
    private Long averageViolence;
    private Long averageEducation;
    private Long averageLang;
    private Long averageAddiction;
    private Long gameNumber;
    private String FacebookName;
    private String twitter;
    private String googleDoc;
    
    @OneToMany(cascade={CascadeType.ALL}, mappedBy="game")
    private Set<GameReview> gameReview = new HashSet<GameReview>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Long averageRating) {
        this.averageRating = averageRating;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getMdaRating() {
        return mdaRating;
    }

    public void setMdaRating(String mdaRating) {
        this.mdaRating = mdaRating;
    }

    public Set<GameReview> getGameReview() {
        return gameReview;
    }

    public void setGameReview(Set<GameReview> gameReview) {
        this.gameReview = gameReview;
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


    public Long getGameNumber() {
        return gameNumber;
    }


    public void setGameNumber(Long gameNumber) {
        this.gameNumber = gameNumber;
    }


    public String getFacebookName() {
        return FacebookName;
    }

    public void setFacebookName(String FacebookName) {
        this.FacebookName = FacebookName;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getGoogledoc() {
        return googleDoc;
    }


    public void setGoogledoc(String googledoc) {
        this.googleDoc = googledoc;
    }
}
