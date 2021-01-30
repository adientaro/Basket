package model;

import java.util.Map;

public interface IBasket<T> {
    void add(T item, Integer quantity);
    @SuppressWarnings("unchecked")
    void remove(T ... items);
    void clear();
    double displayTotalValue();
    Map<T,Integer> getElements();
}
