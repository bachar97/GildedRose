package com.gildedrose;

public class Item {

	private static final String aBrie = "Aged Brie";
	private static final String backstageTC = "Backstage passes to a TAFKAL80ETC concert";
	private static final String Conjured = "Conjured";
	private static final String Sulfuras = "Sulfuras, Hand of Ragnaros";
	private static final int minQuality = 0;
	private static final int maxQuality = 50;
	private static final int[] sellInRange = {0, 5, 10};
	
    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setSellIn(int sellIn) {
    	this.sellIn = sellIn;
    }
    
    public void setQuality(int quality) {
    	this.quality = quality;
    	
    	if(quality < minQuality) {
    		this.quality = minQuality;
    	}
    	
    	if(quality > maxQuality) {
    		this.quality = maxQuality;
    	}
    }
    
    public String getName() {
    	return this.name;
    }
    
    public int getSellIn() {
    	return this.sellIn;
    }
    
    public int getQuality() {
    	return this.quality;
    }

	public void updateQuality() {

		if (this.name.equals(Sulfuras)){
			return;
		}

		this.sellIn -= 1;
		
		switch(this.name) {
		case aBrie:
			if(this.sellIn < sellInRange[0]){
				this.setQuality(this.quality + 2);
			}else{
				this.setQuality(this.quality + 1);
			}
			break;
		case backstageTC:
			if(this.sellIn < sellInRange[0]) {
				this.setQuality(0);
			} else if(this.sellIn < sellInRange[1]) {
				this.setQuality(this.quality + 3);
			} else if(this.sellIn < sellInRange[2]) {
				this.setQuality(this.quality + 2);
			} else {
				this.setQuality(this.quality + 1);
			}
			break;
		case Conjured:
			if(this.sellIn < sellInRange[0]){
				this.setQuality(this.quality - 4);
			}else{
				this.setQuality(this.quality - 2);
			}
			break;
		default:
			if(this.sellIn < sellInRange[0]){
				this.setQuality(this.quality - 2);
			}else{
				this.setQuality(this.quality - 1);
			}
		}
	}
    
   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
