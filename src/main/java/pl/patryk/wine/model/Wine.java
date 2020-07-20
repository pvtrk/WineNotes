package pl.patryk.wine.model;

import pl.patryk.wine.model.enums.WineColor;
import pl.patryk.wine.model.enums.WineType;

import javax.persistence.*;
import java.util.Objects;


@Entity(name = "twine")
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producerId")
    private Producer producer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "countryId")
    private Country country;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regionId")
    private Region region;
    private Integer vintage;
    @Enumerated(EnumType.STRING)
    private WineType type;
    @Enumerated(EnumType.STRING)
    private WineColor color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVintage() {
        return vintage;
    }

    public void setVintage(int vintage) {
        this.vintage = vintage;
    }

    public WineType getType() {
        return type;
    }

    public void setType(WineType type) {
        this.type = type;
    }

    public WineColor getColor() {
        return color;
    }

    public void setColor(WineColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer='" + producer.getName() + '\'' +
                ", vintage=" + vintage +
                ", type=" + type.getDisplayValue() +
                ", color=" + color.getDisplayValue() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wine wine = (Wine) o;
        return name.equals(wine.name) &&
                producer.equals(wine.producer) &&
                country.equals(wine.country) &&
                region.equals(wine.region) &&
                vintage.equals(wine.vintage) &&
                type == wine.type &&
                color == wine.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, producer, country, region, vintage, type, color);
    }
}
