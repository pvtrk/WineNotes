package pl.patryk.wine.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tproducer")
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "country")
    private Country country;
    @OneToMany(mappedBy = "producer",
    cascade = CascadeType.MERGE)
    private List<Wine> wines = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        wine.setProducer(this);
        getWines().add(wine);
    }

    public static String getNameAndCountry(Producer producer) {
        return producer.getName() + " (" + producer.getCountry().getCountryName() + ")";
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", wines=" + wines.size() +
                '}';
    }


}
