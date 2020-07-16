package pl.patryk.wine.model;

import javax.persistence.*;

@Entity
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "producerId")
    private Producer producer;
    private String country;
    private String region;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
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
                ", producer='" + producer + '\'' +
                ", vintage=" + vintage +
                ", type=" + type +
                ", color=" + color +
                '}';
    }

    enum WineType {
        STILL("Spokojne"),
        SPARKLING("Musujące"),
        PETNAT("Pet Nat");

        private String displayValue;

        WineType(String displayValue) {
            this.displayValue = displayValue;
        }

        public String getDisplayValue() {
            return this.displayValue;
        }
    }

    enum WineColor {
        WHITE("Białe"),
        RED("Czerwone"),
        ORANGE("Pomarańczowe");

        private String displayValue;

        WineColor(String displayValue) {
            this.displayValue = displayValue;
        }

        public String getDisplayValue() {
            return this.displayValue;
        }
    }
}
