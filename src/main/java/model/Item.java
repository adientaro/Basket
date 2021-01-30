package model;

public class Item {
    private final String name;
    private final double value;

    //TODO change to BigDecimal

    public Item(String name, double value) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Cannot insert item with empty name");
        }
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name + " " + value;
    }
}
