package model;

import java.util.Objects;

public class Item {
    private final String name;
    private final double price;

    public Item(String name, double price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Cannot insert item with empty name");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 &&
                name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return name + " " + price;
    }
}
