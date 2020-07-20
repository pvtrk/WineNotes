package pl.patryk.wine.model.enums;

public enum TanninsLvl {
    Low("low"),
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
