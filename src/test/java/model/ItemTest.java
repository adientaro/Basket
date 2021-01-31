package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    private final double defaultValue = 1.0;
    private final String defaultItemName = "DefaultItem";

    @Test
    void itemsWithTheSameNamesAndValuesAreEqual(){
        Item item1 = new Item("Item1", defaultValue);
        Item item2 = new Item("Item1", defaultValue);
        assertEquals(item1,item2);
    }

    @Test
    void itemsWithDifferentNamesAreNotEqual() {
        Item item1 = new Item("Item2", defaultValue);
        Item item2 = new Item("Item1", defaultValue);
        assertNotEquals(item1,item2);
    }

    @Test
    void itemsWithDifferentPricesAreNotEqual() {
        Item item1 = new Item("Item1", defaultValue);
        Item item2 = new Item("Item1", defaultValue+2);
        assertNotEquals(item1,item2);
    }

    @Test
    void itemsWithDifferentNameShouldHaveDifferentHashcode() {
        Item item1 = new Item("Item1", defaultValue);
        Item item2 = new Item("Item2", defaultValue);
        assertNotEquals(item1.hashCode(),item2.hashCode());
    }

    @Test
    void itemsWithTheSameNameShouldHaveTheSameHashcode() {
        Item item1 = new Item("Item1", defaultValue);
        Item item2 = new Item("Item1", defaultValue+10);
        assertNotEquals(item1.hashCode(),item2.hashCode());
    }

    @Test
    void shouldThrowExceptionWhenTryToAddItemWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Item(null, defaultValue));
    }

    @Test
    void shouldThrowExceptionWhenTryToAddItemWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Item("", defaultValue));
    }

    @Test
    void shouldReturnProperNameWhenGetItemName() {
        Item item = new Item(defaultItemName, defaultValue);
        assertEquals(defaultItemName, item.getName());
    }

    @Test
    void shouldReturnProperValueWhenGetItemValue() {
        Item item = new Item(defaultItemName, defaultValue);
        assertEquals(defaultValue, item.getValue());
    }

    @Test
    void shouldReturnProperValueWhenCastingToString() {
        Item item = new Item(defaultItemName, defaultValue);
        var returnedString = item.toString();
        var expectedString = defaultItemName + " " + defaultValue;
        assertEquals(expectedString, returnedString);
    }

}