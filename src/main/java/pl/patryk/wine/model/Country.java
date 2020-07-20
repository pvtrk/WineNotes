package pl.patryk.wine.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "tcountry")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String countryName;
    @OneToMany (mappedBy = "country")
    private List<Region> regions = new ArrayList<>();
    @OneToMany(mappedBy = "country")
    private List<Wine> wines = new ArrayList<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public List<Wine> getWines() {
        return wines;
    }

    public void setWines(List<Wine> wines) {
        this.wines = wines;
    }

    @Override
    public String toString() {

        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", regions=" + getRegionsToString() +
                '}';
    }

    public String getRegionsToString() {
        StringBuilder sb = new StringBuilder();
        for(Region region : this.regions) {
            sb.append(region.getRegionName());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id) &&
                Objects.equals(countryName, country.countryName) &&
                Objects.equals(regions, country.regions) &&
                Objects.equals(wines, country.wines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryName, regions, wines);
    }
}
