package pl.patryk.wine.model;

import javax.persistence.*;

public @Entity
class Region {
    @Id
    @GeneratedValue
    private Long id;
    private String regionName;
    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
