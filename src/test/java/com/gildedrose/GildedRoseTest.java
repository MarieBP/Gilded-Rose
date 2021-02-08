package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void allItemsAreRead() {
        // Given
        Item[] items = new Item[] { new Item("foo", 0, 0), new Item("fixme", 0, 0) };
        GildedRose app = new GildedRose(items);
        // When
        app.updateQuality();
        // Then
        assertEquals(app.counter, items.length);
    }

    @Test
    void itemIsNotSulfurasThenSellInMinusOne() {
        // Given
        Item[] items = new Item[] { new Item("Aged Brie", 3, 0) };
        GildedRose app = new GildedRose(items);
        // When
        app.updateQuality();
        // Then
        assertEquals(items[0].sellIn, 2);
    }
}
