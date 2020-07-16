package pl.patryk.wine.model;

import javax.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String note;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private Integer colorIntensivity;
    private Integer acidityLvl;
    private Integer aromaIntesivity;
    private Integer tanninsLvl;
    private Integer finishLength;
    private Integer overallRating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getColorIntensivity() {
        return colorIntensivity;
    }

    public void setColorIntensivity(Integer colorIntensivity) {
        this.colorIntensivity = colorIntensivity;
    }

    public Integer getAcidityLvl() {
        return acidityLvl;
    }

    public void setAcidityLvl(Integer acidityLvl) {
        this.acidityLvl = acidityLvl;
    }

    public Integer getAromaIntesivity() {
        return aromaIntesivity;
    }

    public void setAromaIntesivity(Integer aromaIntesivity) {
        this.aromaIntesivity = aromaIntesivity;
    }

    public Integer getTanninsLvl() {
        return tanninsLvl;
    }

    public void setTanninsLvl(Integer tanninsLvl) {
        this.tanninsLvl = tanninsLvl;
    }

    public Integer getFinishLength() {
        return finishLength;
    }

    public void setFinishLength(Integer finishLength) {
        this.finishLength = finishLength;
    }

    public Integer getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Integer overallRating) {
        this.overallRating = overallRating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
