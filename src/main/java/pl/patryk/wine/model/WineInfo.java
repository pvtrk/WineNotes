package pl.patryk.wine.model;

import pl.patryk.wine.model.enums.WineColor;
import pl.patryk.wine.model.enums.WineType;

import javax.persistence.*;

@Entity(name="twineinfo")
public class WineInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String wineName;
    private WineColor wineColor;
    private WineType wineType;
    private Double vintage;
    private Double alcohol;
    private Double residualSugar;
    private String producer;
    @ManyToOne
    @JoinColumn(name="countryId")
    private Country wineCountry;
    @ManyToOne
    @JoinColumn(name="regionId")
    private Region wineRegion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWineName() {
        return wineName;
    }

    public void setWineName(String wineName) {
        this.wineName = wineName;
    }

    public WineColor getWineColor() {
        return wineColor;
    }

    public void setWineColor(WineColor wineColor) {
        this.wineColor = wineColor;
    }

    public WineType getWineType() {
        return wineType;
    }

    public void setWineType(WineType wineType) {
        this.wineType = wineType;
    }

    public Double getVintage() {
        return vintage;
    }

    public void setVintage(Double vintage) {
        this.vintage = vintage;
    }

    public Double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Double alcohol) {
        this.alcohol = alcohol;
    }

    public Double getResidualSugar() {
        return residualSugar;
    }

    public void setResidualSugar(Double residualSugar) {
        this.residualSugar = residualSugar;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Country getWineCountry() {
        return wineCountry;
    }

    public void setWineCountry(Country wineCountry) {
        this.wineCountry = wineCountry;
    }

    public Region getWineRegion() {
        return wineRegion;
    }

    public void setWineRegion(Region wineRegion) {
        this.wineRegion = wineRegion;
    }
}
