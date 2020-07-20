package pl.patryk.wine.model;

import pl.patryk.wine.model.enums.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="tnote")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String note;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private WineColor wineColor;
    private ColorIntensity colorIntensity;
    private AcidityLvl acidityLvl;
    private AromaIntensity aromaIntesity;
    private TanninsLvl tanninsLvl;
    private FinishLength finishLength;
    private OverallRating overallRating;
    private LocalDateTime creationDate;


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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WineColor getWineColor() {
        return wineColor;
    }

    public void setWineColor(WineColor wineColor) {
        this.wineColor = wineColor;
    }

    public ColorIntensity getColorIntensity() {
        return colorIntensity;
    }

    public void setColorIntensity(ColorIntensity colorIntensity) {
        this.colorIntensity = colorIntensity;
    }

    public AcidityLvl getAcidityLvl() {
        return acidityLvl;
    }

    public void setAcidityLvl(AcidityLvl acidityLvl) {
        this.acidityLvl = acidityLvl;
    }

    public AromaIntensity getAromaIntesity() {
        return aromaIntesity;
    }

    public void setAromaIntesity(AromaIntensity aromaIntesity) {
        this.aromaIntesity = aromaIntesity;
    }

    public TanninsLvl getTanninsLvl() {
        return tanninsLvl;
    }

    public void setTanninsLvl(TanninsLvl tanninsLvl) {
        this.tanninsLvl = tanninsLvl;
    }

    public FinishLength getFinishLength() {
        return finishLength;
    }

    public void setFinishLength(FinishLength finishLength) {
        this.finishLength = finishLength;
    }

    public OverallRating getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(OverallRating overallRating) {
        this.overallRating = overallRating;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", user=" + user.getId() +
                ", wineColor=" + wineColor.getDisplayValue() +
                ", colorIntensity=" + colorIntensity.getDisplayValue() +
                ", acidityLvl=" + acidityLvl.getDisplayValue() +
                ", aromaIntesity=" + aromaIntesity.getDisplayValue() +
                ", tanninsLvl=" + tanninsLvl.getDisplayValue() +
                ", finishLength=" + finishLength.getDisplayValue() +
                ", overallRating=" + overallRating.getDisplayValue() +
                ", creationDate=" + creationDate +
                '}';
    }
}
