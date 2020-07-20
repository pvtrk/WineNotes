package pl.patryk.wine.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum WineColor {
    WHITE("White") {
        @Override
        public List<String> getColourSpecification() {
            List<String> result = new ArrayList<>();
            result.add("lemon");
            result.add("gold");
            result.add("amber");
            result.add("brown");

            return result;
        }
    },
    RED("Red"){
        @Override
        public List<String> getColourSpecification() {
            List<String> result = new ArrayList<>();
            result.add("purple");
            result.add("ruby");
            result.add("garnet");
            result.add("tawny");

            return result;
        }
    },
    ROSE("Rose") {
        @Override
        public List<String> getColourSpecification() {
            List<String> result = new ArrayList<>();
            result.add("pink");
            result.add("pink-orange");
            result.add("orange");

            return result;
        }
    },
    ORANGE("Orange"){
        @Override
        public List<String> getColourSpecification() {
            List<String> result = new ArrayList<>();

            return result;
        }
    };

    private String displayValue;

    WineColor(String displayValue) {
        this.displayValue = displayValue;
    }

    public abstract List<String> getColourSpecification();

    public String getDisplayValue() {
        return this.displayValue;
    }
}
