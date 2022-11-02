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
  void testSulfQual() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(13));
  }

  @Test
  @DisplayName("Test that Quality is less than 50 for Backstage")
  void testBackQual() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("Test that Quality is strictly less than 50 for Backstage")
  void testBackQualStrictLess() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("Test that SellIn is less than 11 for Backstage")
  void testBackSell() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 12);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(13));
  }

  @Test
  @DisplayName("Test that SellIn is strictly less than 11 for Backstage")
  void testBackSellStrict() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 12);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(13));
  }

  @Test
  @DisplayName("Test that Quality is less than 50 and SellIn is less than 6 for Backstage")
  void testBackQualSellLess() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("Test that Quality is less than 50 and SellIn is strictly less than 6 for Backstage")
  void testBackQualSellStrictLess() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 40);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(42));
  }

  @Test
  @DisplayName("Test that SellIn is less than 0 for Backstage")
  void testSellBack() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test
  @DisplayName("Test that SellIn is strictly less than 0 for Backstage")
  void testSellBackStrict() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(13));
  }

  @Test
  @DisplayName("Test that Aged Brie is unchanged")
  void testAged() {
    Item element = new Item("Aged Brie", -1, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(12));
  }

  @Test
  @DisplayName("Test that quality is strictly less than 50 for Aged Brie")
  void testQualAgedStrict() {
    Item element = new Item("Aged Brie", -1, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("Test that SellIn is strictly less than 0 for Aged Brie")
  void testSellAgedStrict() {
    Item element = new Item("Aged Brie", 1, 40);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(41));
  }

  @Test
  @DisplayName("Test that if not Backstage quality = 0")
  void testBackQualNull() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test
  @DisplayName("Test that SellIn is less than 0 for Conjured")
  void testConjSell() {
    Item element = new Item("Conjured", 1, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(8));
  }

  @Test
  @DisplayName("Test that SellIn is strictly less than 0 for Conjured")
  void testConjSellStrict() {
    Item element = new Item("Conjured", -1, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(6));
  }

  @Test
  @DisplayName("Test that SellIn is less than 0 for Conjured")
  void testConjSellLess() {
    Item element = new Item("Conjured", 0, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(6));
  }

  @Test
  @DisplayName("Test that SellIn is strictly less than 0 for Conjured")
  void testConjSellStrictLess() {
    Item element = new Item("Conjured", 1, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(8));
  }

  @Test
  @DisplayName("Test that SellIn is less than 0")
  void testSellInLess() {
    Item element = new Item("foo", 1, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(9));
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
