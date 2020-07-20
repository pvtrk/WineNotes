package pl.patryk.wine.model.enums;

public enum AcidityLvl {
    LOW("low"),
    MEDIUMMIUS("medium-"),
    MEDIUM("medium"),
    MEDIUMPLUS("medium+"),
    HIGH("high");

    private String displayValue;

    AcidityLvl(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
