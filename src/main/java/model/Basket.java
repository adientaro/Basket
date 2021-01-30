package model;

import java.util.HashMap;
import java.util.Map;

public class Basket implements IBasket<Item> {

    //TODO
    // Optionals, more tests, other types of containers
    private final Map<Item, Integer> basketElements = new HashMap<>();

    public void add(Item item, Integer quantity) {
        if (item == null)
            throw new IllegalArgumentException("Cannot insert null item");
        else if (quantity == null) {
            throw new IllegalArgumentException("Cannot insert null quantity");
        }
        if (basketElements.containsKey(item)) {
            quantity += basketElements.get(item);
        }
        basketElements.put(item, quantity);

    }

    public void remove(Item item) {
        if (basketElements.isEmpty())
            throw new IllegalStateException("Cannot remove items from empty basket");
        basketElements.remove(item);
    }

    @Override
    public void clear() {
        basketElements.clear();
    }

    public Map<Item, Integer> getElements() {
        return basketElements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Basket contains: \n");
        sb.append("Item").append("\t").append("Value").append("\t").append("Quantity\n");
        basketElements.forEach((k, v) -> {
            sb.append(k.getName()).append("\t").append(k.getValue()).append("\t").append(v);
        });
        sb.append("\nTotal value: " + displayTotalValue());
        return sb.toString();
    }

    public double displayTotalValue() {
        double result = 0;
        for (Map.Entry<Item, Integer> entry : basketElements.entrySet()) {
            result += entry.getKey().getValue() * entry.getValue();
        }
        return result;
    }
}
