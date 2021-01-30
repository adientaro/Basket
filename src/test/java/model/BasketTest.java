package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BasketTest {

    private final Integer defaultTestQuantity = 2;
    private Basket basket;
    private Item item;
    private Map<Item, Integer> expectedResult;
    private Map<Item, Integer> returnedResult;

    @BeforeEach
    public void setUp() {
        basket = new Basket();
        item = new Item("SampleItem", 2.5);
        expectedResult = new HashMap<>();
        returnedResult = new HashMap<>();
    }

    @Test
    void givenEmptyBasketWhenCreatedNewBasketContainsNoItem() {
        //Given
        expectedResult = Collections.emptyMap();

        //When
        returnedResult = basket.getElements();

        //Then
        assertEquals(returnedResult, expectedResult);
    }

    @Test
    void givenEmptyBasketWhenAddOneItemThenOneElementInside() {
        //Given
        basket.clear();
        expectedResult.put(item, defaultTestQuantity);

        //When
        basket.add(item, defaultTestQuantity);

        //Then
        returnedResult = basket.getElements();
        assertEquals(returnedResult, expectedResult);
    }

    @Test
    void givenEmptyBasketWhenAddOneItemWithNegativeQuantityThrowsException() {
        //Then
        assertThrows(IllegalArgumentException.class, () -> basket.add(item, -10));
    }


    @Test
    void givenOneElementInBasketWhenAddTheSameItemCheckQuantity() {
        //Given
        basket.add(item, defaultTestQuantity);

        //When
        basket.add(item, 5);

        //Then
        var returnedQuantity = basket.getElements().get(item);
        assertEquals(returnedQuantity, 7);
    }

    @Test
    void givenOneElementInBasketWhenTryToModifyMapThenThrowsUnsupportedOperation() {
        //Given
        Item item2 = new Item("SampleItem2", 3.0);
        basket.add(item, defaultTestQuantity);

        //Then
        assertThrows(UnsupportedOperationException.class, () -> basket.getElements().put(item2, defaultTestQuantity));
    }


    @Test
    void givenEmptyBasketAddTwoItemsThenTwoElementsInside() {
        //Given
        Item item2 = new Item("SampleItem2", 3.0);

        //When
        basket.add(item, defaultTestQuantity);
        basket.add(item2, 5);
        expectedResult.put(item, 2);
        expectedResult.put(item2, 5);

        //Then
        returnedResult = basket.getElements();
        assertEquals(returnedResult, expectedResult);
    }


    @Test
    void givenNullItemWhenAddToBasketThenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> basket.add(null, defaultTestQuantity));
    }

    @Test
    void givenNullQuantityWhenAddToBasketThenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> basket.add(item, null));
    }

    @Test
    void givenOneItemWhenRemoveItemThenReturnsEmptyBasket() {
        //Given
        basket.add(item, defaultTestQuantity);

        //When
        basket.remove(item);

        //Then
        returnedResult = basket.getElements();
        assertEquals(returnedResult, Collections.emptyMap());
    }

    @Test
    void givenThreeItemsWhenRemoveTwoReturnsOneItem() {
        //Given
        Item item2 = new Item("SampleItem2", 2.5);
        Item item3 = new Item("SampleItem3", 2.5);
        basket.add(item, defaultTestQuantity);
        basket.add(item2, defaultTestQuantity);
        basket.add(item3, defaultTestQuantity);
        expectedResult.put(item3, defaultTestQuantity);

        //When
        basket.remove(item, item2);

        //Then
        returnedResult = basket.getElements();
        assertEquals(returnedResult, expectedResult);
    }


    @Test
    void givenTwoItemsWhenRemoveOneThatNotExistThenNothingHappens() {
        //Given
        Item item2 = new Item("SampleItem2", 2.5);
        Item item3 = new Item("SampleItem3", 2.5);
        basket.add(item, defaultTestQuantity);
        basket.add(item2, defaultTestQuantity);
        expectedResult.put(item, defaultTestQuantity);
        expectedResult.put(item2, defaultTestQuantity);

        //When
        basket.remove(item3);

        //Then
        returnedResult = basket.getElements();
        assertEquals(returnedResult, expectedResult);
    }

    @Test
    void givenAnyItemWhenRemoveItemThenThrowsException() {
        //Given
        //When
        //Then
        assertThrows(Exception.class, () -> basket.remove(item));
    }


    @Test
    void givenOneItemWhenDisplayTotalValueReturnCorrectValue() {
        //Given
        basket.add(item, defaultTestQuantity);
        double expectedValue = item.getValue() * defaultTestQuantity;

        //When
        double returnedTotalValue = basket.displayTotalValue();

        //Then
        assertEquals(returnedTotalValue, expectedValue);
    }

    @Test
    void givenTwoItemsThenClearBasketReturnsEmptyBasket() {
        //Given
        Item item2 = new Item("SampleItem2", 3.0);
        expectedResult = Collections.emptyMap();

        //When
        basket.add(item, defaultTestQuantity);
        basket.add(item2, 5);


        //Then
        basket.clear();
        returnedResult = basket.getElements();
        assertEquals(returnedResult, expectedResult);

    }


}