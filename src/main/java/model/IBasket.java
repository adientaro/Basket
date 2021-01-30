package model;

public interface IBasket<T> {
    public void add(T item, Integer quantity);
    public void remove(T item);
    public void clear();
    public double displayTotalValue();
    //TODO make deispaly total value more customizable
}
