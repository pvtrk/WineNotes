package pl.patryk.wine.model;

import pl.patryk.wine.model.enums.WineColor;
import pl.patryk.wine.model.enums.WineType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Entity(name = "twine")
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producerId")
    @NotNull
    @NotEmpty
    private Producer producer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "countryId")
    @NotNull
    @NotEmpty
    private Country country;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regionId")
    @NotNull
    @NotEmpty
    private Region region;
    @NotNull
    @NotEmpty
    private Integer vintage;
    @Enumerated(EnumType.STRING)
    @NotNull
    @NotEmpty
    private WineType type;
    @Enumerated(EnumType.STRING)
    @NotNull
    @NotEmpty
    private WineColor color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producer getProducer() {
        return producer;
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

    public Wine(String name, Producer producer,
                Country country, Region region,
                Integer vintage, WineType type, WineColor color) {
        this.name = name;
        this.producer = producer;
        this.country = country;
        this.region = region;
        this.vintage = vintage;
        this.type = type;
        this.color = color;
    }

    public Wine() {
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

    public static String getNameVintageProducerCountry(Wine wine) {
        StringBuilder sb = new StringBuilder();
        sb.append(wine.getName()).append(" (").append(wine.getColor().getDisplayValue())
                .append(", ").append(wine.getVintage()).append(", ")
                .append(wine.getProducer().getName()).append(", ").append(wine.getCountry().getCountryName())
                .append(", ").append(wine.getRegion().getRegionName()).append(")");

        return  sb.toString();
    }
}
