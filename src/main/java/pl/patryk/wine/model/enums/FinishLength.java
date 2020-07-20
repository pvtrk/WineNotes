package pl.patryk.wine.model.enums;

public enum FinishLength {
    SHORT("short"),
    MEDIUMINUS("mediuminus"),
    MEDIUM("medium"),
    MEDIUMPLUS("mediumplus"),
    LONG("long");

    private String displayValue;

    FinishLength(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
