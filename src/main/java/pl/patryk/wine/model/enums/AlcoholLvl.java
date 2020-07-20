package pl.patryk.wine.model.enums;

public enum AlcoholLvl {
    LOW("low"),
    MEDIUM("medium"),
    HIGH("high");

    private String displayValue;

    AlcoholLvl(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
