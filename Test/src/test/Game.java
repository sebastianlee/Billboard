/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Arty
 */
@Entity
@Table(name = "game", catalog = "oversightds", schema = "")
@NamedQueries({
    @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g"),
    @NamedQuery(name = "Game.findById", query = "SELECT g FROM Game g WHERE g.id = :id"),
    @NamedQuery(name = "Game.findByMdarating", query = "SELECT g FROM Game g WHERE g.mdarating = :mdarating"),
    @NamedQuery(name = "Game.findByAveragerating", query = "SELECT g FROM Game g WHERE g.averagerating = :averagerating"),
    @NamedQuery(name = "Game.findByAveragelang", query = "SELECT g FROM Game g WHERE g.averagelang = :averagelang"),
    @NamedQuery(name = "Game.findByAverageeducation", query = "SELECT g FROM Game g WHERE g.averageeducation = :averageeducation"),
    @NamedQuery(name = "Game.findByGametitle", query = "SELECT g FROM Game g WHERE g.gametitle = :gametitle"),
    @NamedQuery(name = "Game.findByFacebookname", query = "SELECT g FROM Game g WHERE g.facebookname = :facebookname"),
    @NamedQuery(name = "Game.findByTwitter", query = "SELECT g FROM Game g WHERE g.twitter = :twitter"),
    @NamedQuery(name = "Game.findByGamenumber", query = "SELECT g FROM Game g WHERE g.gamenumber = :gamenumber"),
    @NamedQuery(name = "Game.findByAverageviolence", query = "SELECT g FROM Game g WHERE g.averageviolence = :averageviolence"),
    @NamedQuery(name = "Game.findByDeveloper", query = "SELECT g FROM Game g WHERE g.developer = :developer"),
    @NamedQuery(name = "Game.findByDateandtime", query = "SELECT g FROM Game g WHERE g.dateandtime = :dateandtime"),
    @NamedQuery(name = "Game.findByAverageaddiction", query = "SELECT g FROM Game g WHERE g.averageaddiction = :averageaddiction"),
    @NamedQuery(name = "Game.findByGoogledoc", query = "SELECT g FROM Game g WHERE g.googledoc = :googledoc")})
public class Game implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "MDARATING")
    private String mdarating;
    @Column(name = "AVERAGERATING")
    private BigInteger averagerating;
    @Column(name = "AVERAGELANG")
    private BigInteger averagelang;
    @Column(name = "AVERAGEEDUCATION")
    private BigInteger averageeducation;
    @Column(name = "GAMETITLE")
    private String gametitle;
    @Column(name = "FACEBOOKNAME")
    private String facebookname;
    @Column(name = "TWITTER")
    private String twitter;
    @Column(name = "GAMENUMBER")
    private BigInteger gamenumber;
    @Column(name = "AVERAGEVIOLENCE")
    private BigInteger averageviolence;
    @Column(name = "DEVELOPER")
    private String developer;
    @Column(name = "DATEANDTIME")
    @Temporal(TemporalType.DATE)
    private Date dateandtime;
    @Column(name = "AVERAGEADDICTION")
    private BigInteger averageaddiction;
    @Column(name = "GOOGLEDOC")
    private String googledoc;

    public Game() {
    }

    public Game(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getMdarating() {
        return mdarating;
    }

    public void setMdarating(String mdarating) {
        String oldMdarating = this.mdarating;
        this.mdarating = mdarating;
        changeSupport.firePropertyChange("mdarating", oldMdarating, mdarating);
    }

    public BigInteger getAveragerating() {
        return averagerating;
    }

    public void setAveragerating(BigInteger averagerating) {
        BigInteger oldAveragerating = this.averagerating;
        this.averagerating = averagerating;
        changeSupport.firePropertyChange("averagerating", oldAveragerating, averagerating);
    }

    public BigInteger getAveragelang() {
        return averagelang;
    }

    public void setAveragelang(BigInteger averagelang) {
        BigInteger oldAveragelang = this.averagelang;
        this.averagelang = averagelang;
        changeSupport.firePropertyChange("averagelang", oldAveragelang, averagelang);
    }

    public BigInteger getAverageeducation() {
        return averageeducation;
    }

    public void setAverageeducation(BigInteger averageeducation) {
        BigInteger oldAverageeducation = this.averageeducation;
        this.averageeducation = averageeducation;
        changeSupport.firePropertyChange("averageeducation", oldAverageeducation, averageeducation);
    }

    public String getGametitle() {
        return gametitle;
    }

    public void setGametitle(String gametitle) {
        String oldGametitle = this.gametitle;
        this.gametitle = gametitle;
        changeSupport.firePropertyChange("gametitle", oldGametitle, gametitle);
    }

    public String getFacebookname() {
        return facebookname;
    }

    public void setFacebookname(String facebookname) {
        String oldFacebookname = this.facebookname;
        this.facebookname = facebookname;
        changeSupport.firePropertyChange("facebookname", oldFacebookname, facebookname);
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        String oldTwitter = this.twitter;
        this.twitter = twitter;
        changeSupport.firePropertyChange("twitter", oldTwitter, twitter);
    }

    public BigInteger getGamenumber() {
        return gamenumber;
    }

    public void setGamenumber(BigInteger gamenumber) {
        BigInteger oldGamenumber = this.gamenumber;
        this.gamenumber = gamenumber;
        changeSupport.firePropertyChange("gamenumber", oldGamenumber, gamenumber);
    }

    public BigInteger getAverageviolence() {
        return averageviolence;
    }

    public void setAverageviolence(BigInteger averageviolence) {
        BigInteger oldAverageviolence = this.averageviolence;
        this.averageviolence = averageviolence;
        changeSupport.firePropertyChange("averageviolence", oldAverageviolence, averageviolence);
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        String oldDeveloper = this.developer;
        this.developer = developer;
        changeSupport.firePropertyChange("developer", oldDeveloper, developer);
    }

    public Date getDateandtime() {
        return dateandtime;
    }

    public void setDateandtime(Date dateandtime) {
        Date oldDateandtime = this.dateandtime;
        this.dateandtime = dateandtime;
        changeSupport.firePropertyChange("dateandtime", oldDateandtime, dateandtime);
    }

    public BigInteger getAverageaddiction() {
        return averageaddiction;
    }

    public void setAverageaddiction(BigInteger averageaddiction) {
        BigInteger oldAverageaddiction = this.averageaddiction;
        this.averageaddiction = averageaddiction;
        changeSupport.firePropertyChange("averageaddiction", oldAverageaddiction, averageaddiction);
    }

    public String getGoogledoc() {
        return googledoc;
    }

    public void setGoogledoc(String googledoc) {
        String oldGoogledoc = this.googledoc;
        this.googledoc = googledoc;
        changeSupport.firePropertyChange("googledoc", oldGoogledoc, googledoc);
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
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.Game[id=" + id + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
