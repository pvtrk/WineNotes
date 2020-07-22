package pl.patryk.wine.model.enums;

public enum TanninsLvl {
    NONE("none"),
    LOW("low"),
    MEDIUMINUS("medium-"),
    MEDIUM("medium"),
    MEDIUMPLUS("medium+"),
    HIGH("high");

    private String displayValue;

    TanninsLvl(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
