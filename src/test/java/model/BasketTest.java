package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BasketTest {

    private Basket basket;
    private Item item;
    private Map<Item, Integer> expectedResult;
    private Map<Item, Integer> returnedResult;

    @BeforeEach
    public void setUp() {
        basket = new Basket();
        item = new Item("SampleItem", 39.99);
        expectedResult = new HashMap<>();
        returnedResult = new HashMap<>();
    }

    @Test
    void shouldAllowItemWithQuantityOne() {
        basket.add(item, 1);

        expectedResult = createBasket(item, 1);
        returnedResult = basket.getElements();

        assertEquals(expectedResult, returnedResult);
    }

    @Test
    void shouldAllowItemWithQuantityNotOne() {
        basket.add(item, 500);

        expectedResult = createBasket(item, 500);
        returnedResult = basket.getElements();

        assertEquals(expectedResult, returnedResult);
    }

    @Test
    void shouldNotAllowItemWithQuantityZero() {
        assertThrows(IllegalArgumentException.class, () -> basket.add(item, 0));
    }

    @Test
    void shouldNotAllowItemWithQuantityLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> basket.add(item, -10));
    }

    @Test
    void shouldNotAllowAddNullItem() {
        assertThrows(IllegalArgumentException.class, () -> basket.add(null, 1));
    }

    @Test
    void shouldNotAllowAddNullQuantity() {
        assertThrows(IllegalArgumentException.class, () -> basket.add(item, null));
    }

    @Test
    void shouldAllowAddTheSameItemTwice() {
        basket.add(item, 1);
        basket.add(item, 1);

        expectedResult = createBasket(item, 2);
        returnedResult = basket.getElements();

        assertEquals(expectedResult, returnedResult);
    }

    @Test
    void shouldNotAllowModifyReturnedResult() {
        basket.add(item, 1);

        assertThrows(UnsupportedOperationException.class, () -> basket.getElements().put(item, 2));
    }

    @Test
    void shouldAllowRemoveItemFromBasket() {
        Item item2 = new Item("SampleItem2", 4);
        basket.add(item, 3);
        basket.add(item2, 4);

        expectedResult = createBasket(item, 3);
        basket.remove(item2);
        returnedResult = basket.getElements();

        assertEquals(expectedResult, returnedResult);
    }

    @Test
    void shouldThrowUnsupportedOperationWhenTryToRemoveNonExistingItemInBasket() {
        Item item2 = new Item("SampleItem2", 4);
        basket.add(item, 3);
        assertThrows(UnsupportedOperationException.class, () -> basket.remove(item2));
    }

    @Test
    void shouldThrowUnsupportedOperationWhenTryToRemoveFromEmptyBasket() {
        assertThrows(UnsupportedOperationException.class, () -> basket.remove(item));
    }

    @Test
    void shouldAllowClearBasket() {
        Item item2 = new Item("SampleItem2", 4);
        basket.add(item, 3);
        basket.add(item2, 4);

        expectedResult = createBasket();
        basket.clear();
        returnedResult = basket.getElements();
        assertEquals(expectedResult, returnedResult);
    }

    @Test
    void shouldComputeProperBasketValueForOneItem() {
        var quantity = 3;
        basket.add(item, quantity);
        var expectedValue = computeTotalValue(item, quantity);
        var returnedValue = basket.displayTotalValue();
        assertEquals(expectedValue, returnedValue);
    }

    @Test
    void shouldReturnProperValueWithToString() {
        var quantity = 2;
        basket.add(item, quantity);

        var expectedString = String.format(Basket.ITEM_ORDER_FORMAT, item.getName(),
                item.getValue(), quantity, item.getValue() * quantity) +
                System.lineSeparator() +
                String.format("Total: %.2f", computeTotalValue(item, quantity)) +
                System.lineSeparator();
        var returnedString = basket.toString();
        assertEquals(expectedString, returnedString);
    }

    private double computeTotalValue(Item item, Integer quantity) {
        return item.getValue() * quantity;
    }

    private Map<Item, Integer> createBasket(Object... parameters) {
        Map<Item, Integer> result = new HashMap<>();

        for (int index = 0; index < parameters.length; index += 2) {
            Item item = (Item) parameters[index];
            Integer quantity = (Integer) parameters[index + 1];
            result.put(item, quantity);
        }
        return result;
    }
}