package pl.patryk.wine.model.enums;

public enum ColorIntensity {
    PALE("pale"),
    MEDIUM("medium"),
    DEEP("deep");

    private String displayValue;

    ColorIntensity(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
