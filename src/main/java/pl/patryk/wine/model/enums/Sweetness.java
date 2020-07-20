package pl.patryk.wine.model.enums;

public enum Sweetness {
    DRY("dry"),
    OFFDRY("off-dry"),
    MEDIUMDRY("medium-dry"),
    MEDIUMSWEET("medium-sweet"),
    SWEET("sweet");

    private String displayValue;

    Sweetness(String displayValue) {
        this.displayValue = displayValue;
    }
}
