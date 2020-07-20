package pl.patryk.wine.model.enums;

public enum AromaIntensity {
    LIGHT("light"),
    MEDIUMINUS("medium-"),
    MEDIUM("medium"),
    MEDIUMPLUS("medium+"),
    HIGH("high");

    private String displayValue;

    AromaIntensity(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
