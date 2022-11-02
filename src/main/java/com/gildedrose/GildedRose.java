package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void setItems(Item[] items) {
    	this.items = items;
    }
    
    Item[] getItems() {
    	return this.items;
    }

    public void updateQuality() {
    	for (Item item : items) {
    		item.updateQuality();
    	}
    }
}