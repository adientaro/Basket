package model;

public interface IBasket<T> {
    void add(T item, Integer quantity);
    void remove(T item);
    void clear();
    double displayTotalValue();
    //TODO make display total value more customizable
}
