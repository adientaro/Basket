import model.Basket;
import model.Item;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Basket basket = new Basket();
        Item item = new Item("SampleItem", 2.5);
        Scanner in = new Scanner(System.in);
        System.out.print("How many items you want to add?\n");
        String quantity = in.nextLine();
        basket.add(item, Integer.parseInt(quantity));
        System.out.print(basket.toString());
    }
}
