package model;

import java.util.Objects;

public class Item {
    private final String name;
    private final double value;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.value, value) == 0 &&
                name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return name + " " + value;
    }
}
