package pl.patryk.wine.model.enums;

public enum Body {
    LIGHT("light"),
    MEDIUMMINUS("medium-"),
    MEDIUM("medium"),
    MEDIUMPLUS("medium+"),
    FULL("full");

    private String displayValue;

    Body(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
