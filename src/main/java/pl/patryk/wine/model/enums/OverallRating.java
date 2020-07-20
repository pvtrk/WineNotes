package pl.patryk.wine.model.enums;

public enum OverallRating {
    POOR("poor", 1),
    ACCEPTABLE("acceptable", 2),
    GOOD("good", 3),
    VERYGOOD("very good", 4);

    private String displayValue;
    private int numberValue;

    OverallRating(String displayValue, int numberValue) {
        this.displayValue = displayValue;
        this.numberValue = numberValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
