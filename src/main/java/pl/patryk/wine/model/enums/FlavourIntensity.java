package pl.patryk.wine.model.enums;

public enum FlavourIntensity {
    LIGHT("light"),
    MEDIUMINUS("medium-"),
    MEDIUM("medium"),
    MEDIUMPLUS("medium+"),
    PRONOUNCED("pronounced");

    private String displayValue;

    FlavourIntensity(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
