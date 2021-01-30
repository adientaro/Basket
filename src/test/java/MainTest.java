import model.Basket;
import model.Item;

public class MainTest {
    /*
        - TreeMap vs other maps implementations
        - Illegal argument should have information about wrong argument
     */

    public static void main(String[] args) {
        Basket basket = new Basket();
        Item item = new Item("SampleItem", 3);
        Item item2 = new Item("SampleItem2", 2.53);
        System.out.print("Adding two items: " + item + item2 + "\n");
        basket.add(item, 3);
        basket.add(item2, 4);
        System.out.print(basket.toString());
        System.out.print("Removing items: " + item + "\n");
        basket.remove(item);
        System.out.print(basket.toString());
        System.out.print("Clearing basket.\n");
        basket.clear();
        System.out.print(basket.toString());
    }
}
