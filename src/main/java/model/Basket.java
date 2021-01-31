package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Basket implements IBasket<Item> {

    public static final String ITEM_ORDER_FORMAT = "%s (%.2f x %d = %.2f)";
    private final Map<Item, Integer> basketElements = new LinkedHashMap<>();

    @Override
    public void add(Item item, Integer quantity) {
        if (item == null)
            throw new IllegalArgumentException("Cannot insert null item");
        else if (quantity == null) {
            throw new IllegalArgumentException("Cannot insert null quantity");
        } else if (quantity <= 0) {
            throw new IllegalArgumentException("Cannot insert Item with negative quantity");
        }
        if (basketElements.containsKey(item)) {
            quantity += basketElements.get(item);
        }
        basketElements.put(item, quantity);

    }

    @Override
    public void remove(Item... items) {
        if (basketElements.isEmpty())
            throw new UnsupportedOperationException("Cannot remove items from empty basket");
        Arrays.asList(items).forEach(item -> {
            if (basketElements.containsKey(item)) {
                basketElements.remove(item);
            } else throw new UnsupportedOperationException("Cannot remove not existing item");
        });
    }


    @Override
    public void clear() {
        basketElements.clear();
    }

    @Override
    public Map<Item, Integer> getElements() {
        return Collections.unmodifiableMap(basketElements);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        basketElements.forEach((k, v) -> {
            String item = String.format(ITEM_ORDER_FORMAT, k.getName(), k.getPrice(), v, k.getPrice() * v);
            sb.append(item);
            sb.append(System.lineSeparator());
        });
        sb.append(String.format("Total: %.2f", displayTotalValue()));
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    public double displayTotalValue() {
        double result = 0;
        for (Map.Entry<Item, Integer> entry : basketElements.entrySet()) {
            result += entry.getKey().getPrice() * entry.getValue();
        }
        return result;
    }
}
