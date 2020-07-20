package pl.patryk.wine.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public @Entity(name = "tregion")
class Region {
    @Id
    @GeneratedValue
    private Long id;
    private String regionName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "countryId")
    private Country country;
    @OneToMany(mappedBy = "region",
            cascade = CascadeType.ALL)
    private List<Wine> wines = new ArrayList<>();

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

    public List<Wine> getWines() {
        return wines;
    }

    public void setWines(List<Wine> wines) {
        this.wines = wines;
    }

    public void addWine(Wine wine) {
        wine.setRegion(this);
        getWines().add(wine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return regionName.equals(region.regionName) &&
                country.equals(region.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionName, country);
    }
}
