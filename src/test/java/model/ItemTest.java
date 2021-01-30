package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemTest {
    /*Class with shouldTest... nomenclature */
    //TODO codeCoverage
    private final double defaultValue = 1.0;
    private final String defaultItemName = "DefaultItem";

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
}