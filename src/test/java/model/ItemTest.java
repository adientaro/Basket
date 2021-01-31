package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    private final double defaultItemPrice = 1.0;
    private final String defaultItemName = "DefaultItem";

    @Test
    void itemsWithTheSameNamesAndValuesAreEqual(){
        Item item1 = new Item("Item1", defaultItemPrice);
        Item item2 = new Item("Item1", defaultItemPrice);
        assertEquals(item1,item2);
    }

    @Test
    void itemsWithDifferentNamesAreNotEqual() {
        Item item1 = new Item("Item1", defaultItemPrice);
        Item item2 = new Item("Item2", defaultItemPrice);
        assertNotEquals(item1,item2);
    }

    @Test
    void itemsWithDifferentPricesAreNotEqual() {
        Item item1 = new Item("Item1", defaultItemPrice);
        Item item2 = new Item("Item1", defaultItemPrice + 2);
        assertNotEquals(item1,item2);
    }

    @Test
    void itemsWithDifferentNameShouldHaveDifferentHashcode() {
        Item item1 = new Item("Item1", defaultItemPrice);
        Item item2 = new Item("Item2", defaultItemPrice);
        assertNotEquals(item1.hashCode(),item2.hashCode());
    }

    @Test
    void itemsWithTheSameNameShouldHaveTheSameHashcode() {
        Item item1 = new Item("Item1", defaultItemPrice);
        Item item2 = new Item("Item1", defaultItemPrice + 10);
        assertNotEquals(item1.hashCode(),item2.hashCode());
    }

    @Test
    void shouldThrowExceptionWhenTryToAddItemWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Item(null, defaultItemPrice));
    }

    @Test
    void shouldThrowExceptionWhenTryToAddItemWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Item("", defaultItemPrice));
    }

    @Test
    void shouldReturnProperNameWhenGetItemName() {
        Item item = new Item(defaultItemName, defaultItemPrice);
        assertEquals(defaultItemName, item.getName());
    }

    @Test
    void shouldReturnProperValueWhenGetItemValue() {
        Item item = new Item(defaultItemName, defaultItemPrice);
        assertEquals(defaultItemPrice, item.getPrice());
    }

    @Test
    void shouldReturnProperValueWhenCastingToString() {
        Item item = new Item(defaultItemName, defaultItemPrice);
        var returnedString = item.toString();
        var expectedString = defaultItemName + " " + defaultItemPrice;
        assertEquals(expectedString, returnedString);
    }
}