package pl.patryk.wine.model;

import pl.patryk.wine.model.enums.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="tnote")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name="wineId")
    private Wine wine;
    private WineColor wineColor;
    private String colorSpecification;
    private ColorIntensity colorIntensity;


    private AromaIntensity aromaIntensity;
    private String aromaCharasteristics;

    private Sweetness sweetness;
    private AcidityLvl acidityLvl;
    private TanninsLvl tanninsLvl;
    private String tanninsNature;
    private AlcoholLvl alcoholLvl;
    private Body body;
    private FlavourIntensity flavourIntensity;
    private String flavourCharasteristics;
    private String otherObservations;
    private FinishLength finishLength;
    private OverallRating overallRating;
    private LocalDateTime creationDate;
    private boolean blind;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public AromaIntensity getAromaIntensity() {
        return aromaIntensity;
    }

    public void setAromaIntensity(AromaIntensity aromaIntensity) {
        this.aromaIntensity = aromaIntensity;
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

    public Wine getWine() {
        return wine;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }

    public boolean isBlind() {
        return blind;
    }

    public void setBlind(boolean blind) {
        this.blind = blind;
    }

    public String getColorSpecification() {
        return colorSpecification;
    }

    public void setColorSpecification(String colorSpecification) {
        this.colorSpecification = colorSpecification;
    }

    public String getAromaCharasteristics() {
        return aromaCharasteristics;
    }

    public void setAromaCharasteristics(String aromaCharasteristics) {
        this.aromaCharasteristics = aromaCharasteristics;
    }

    public Sweetness getSweetness() {
        return sweetness;
    }

    public void setSweetness(Sweetness sweetness) {
        this.sweetness = sweetness;
    }

    public String getTanninsNature() {
        return tanninsNature;
    }

    public void setTanninsNature(String tanninsNature) {
        this.tanninsNature = tanninsNature;
    }

    public AlcoholLvl getAlcoholLvl() {
        return alcoholLvl;
    }

    public void setAlcoholLvl(AlcoholLvl alcoholLvl) {
        this.alcoholLvl = alcoholLvl;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public FlavourIntensity getFlavourIntensity() {
        return flavourIntensity;
    }

    public void setFlavourIntensity(FlavourIntensity flavourIntensity) {
        this.flavourIntensity = flavourIntensity;
    }

    public String getFlavourCharasteristics() {
        return flavourCharasteristics;
    }

    public void setFlavourCharasteristics(String flavourCharasteristics) {
        this.flavourCharasteristics = flavourCharasteristics;
    }

    public String getOtherObservations() {
        return otherObservations;
    }

    public void setOtherObservations(String otherObservations) {
        this.otherObservations = otherObservations;
    }

    public Note(String name, User user, Wine wine, WineColor wineColor,
                ColorIntensity colorIntensity,
                AcidityLvl acidityLvl, AromaIntensity aromaIntensity,
                TanninsLvl tanninsLvl, FinishLength finishLength,
                OverallRating overallRating, LocalDateTime creationDate, boolean blind) {
        this.name = name;
        this.user = user;
        this.wine = wine;
        this.wineColor = wineColor;
        this.colorIntensity = colorIntensity;
        this.acidityLvl = acidityLvl;
        this.aromaIntensity = aromaIntensity;
        this.tanninsLvl = tanninsLvl;
        this.finishLength = finishLength;
        this.overallRating = overallRating;
        this.creationDate = creationDate;
        this.blind = blind;
    }

    public Note() {
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user.getId() +
                ", wine=" + wine.getName() +
                ", creationDate=" + creationDate +
                '}';
    }
}
