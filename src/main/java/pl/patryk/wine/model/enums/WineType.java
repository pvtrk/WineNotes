package pl.patryk.wine.model.enums;

public enum WineType {
    STILL("Still"),
    SPARKLING("Sparkling"),
    PETNAT("Pet Nat");

    private String displayValue;

    WineType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }
}
