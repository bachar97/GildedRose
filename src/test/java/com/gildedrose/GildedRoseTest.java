package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test
  @DisplayName("Test that the quality is unchanged")
  void testQuality() {
    Item element = new Item("foo", 0, 5);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(3));
  }

  @Test
  @DisplayName("Test that Quality is less than 50 and name is not Sulfuras")
  void testAll() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(13));
  }

  @Test
  @DisplayName("Test that Quality is less than 50")
  void testBackQual() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("Test that Quality is strictly less than 50")
  void testBackQualStrictLess() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("Test that SellIn is less than 11")
  void testBackSell() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 12);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(13));
  }

  @Test
  @DisplayName("Test that SellIn is strictly less than 11")
  void testBackSellStrict() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 12);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(13));
  }


  @Test
  @DisplayName("Test that Quality is less than 50 and SellIn is less than 6")
  void testBackSellLess() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("Test that Quality is less than 50 and SellIn is strictly less than 6")
  void testBackSellStrictLess() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 40);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(42));
  }

  @Test
  @DisplayName("Test that SellIn is less than 0")
  void testSellBack() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test
  @DisplayName("Test that SellIn is strictly less than 0")
  void testSellBackStrict() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(13));
  }

  @Test
  @DisplayName("Test that SellBrie is unchanged")
  void testSellBrie() {
    Item element = new Item("Aged Brie", -1, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(12));
  }

  @Test
  @DisplayName("Test that quality is less than 50 while name is Aged Brie")
  void testQual() {
    Item element = new Item("Aged Brie", -1, 51);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(51));
  }

  @Test
  @DisplayName("Test that quality is strictly less than 50 while name is Aged Brie")
  void testQualStrict() {
    Item element = new Item("Aged Brie", -1, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("Test that if not Backstage quality = 0")
  void testHand() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", -1, 51);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("Sulfuras, Hand of Ragnaros"));
  }

  @Test
  @DisplayName("Test Item.java")
  void testToString() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", -1, 51);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.toString(), is("Sulfuras, Hand of Ragnaros, -1, 51"));
  }
}
