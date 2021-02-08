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

    @Test
    void itemIsBackstageOrAgedbrieAndQualityUnder50ThenQualityPlusOne() {
        // Given
        Item[] items = new Item[] { new Item("Aged Brie", 3, 39) };
        GildedRose app = new GildedRose(items);
        // When
        app.updateQuality();
        // Then
        assertEquals(items[0].quality, 40);
    }

    @Test
    void itemIsNotBackstageNorAgedbrieNorSulfurasAndQualityOver0ThenQualityMinusOne() {
        // Given
        Item[] items = new Item[] { new Item("Some item", 3, 26) };
        GildedRose app = new GildedRose(items);
        // When
        app.updateQuality();
        // Then
        assertEquals(items[0].quality, 25);
    }

    @Test
    void sellinNegativeandIsBackstageThenQualityEqualsZero() {
        // Given
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -3, 26) };
        GildedRose app = new GildedRose(items);
        // When
        app.updateQuality();
        // Then
        assertEquals(items[0].quality, 0);
    }

    @Test
    void sellinNegativeAndItemAgedBrieAndQualityUnder50() {
        // Given
        int quality = 23;
        Item[] items = new Item[] { new Item("Aged Brie", -3, quality) };
        GildedRose app = new GildedRose(items);
        // When
        app.updateQuality();
        // Then
        assertEquals(quality+2, items[0].quality);
    }
}
