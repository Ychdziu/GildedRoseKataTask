package com.gildedrosekata.main;

public class GildedRose {

	Item[] items;
	final String CHEESE = "Aged Brie";
	final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
	final String LEGENDARY = "Sulfuras, Hand of Ragnaros";
	final String CONJURED = "conjured";
	
	final int BACKSTAGE_BREAK_1 = 11;
	final int BACKSTAGE_BREAK_2 = 6;
	
	final int MAX_QUALITY = 50;

	public GildedRose(Item[] items) {

		this.items = items;

	}

	public void updateQuality() {

		for (Item item : items) {

			if (item.name.equals(CHEESE)) {
				updateCheese(item);
			} else if (item.name.equals(BACKSTAGE_PASS)) {
				updateBackstagePass(item);
			} else if (item.name.equals(LEGENDARY)) {
				updateLegendary(item);
			} else if (item.name.toLowerCase().contains(CONJURED)) {
				updateConjured(item);
			} else {
				updateCommon(item);
			}
		}
	}

	public void updateCheese(Item item) {
		increaseQuality(item);
		decreaseSellIn(item);
		if (item.sellIn < 0) {
			increaseQuality(item);
		}
	}

	public void updateBackstagePass(Item item) {

		if (item.sellIn < 0) {
			item.quality = 0;
		} else {
			increaseQuality(item);

			if (item.sellIn < BACKSTAGE_BREAK_1) {
				increaseQuality(item);
			}

			if (item.sellIn < BACKSTAGE_BREAK_2) {
				increaseQuality(item);
			}

			decreaseSellIn(item);
		}
	}

	public void updateLegendary(Item item) {
		// Do nothing
	}

	public void updateCommon(Item item) {
		decreaseQuality(item);
		decreaseSellIn(item);
		if (item.sellIn < 0) {
			decreaseQuality(item);
		}
	}
	
	public void updateConjured(Item item) {
		decreaseQuality(item,2);
		decreaseSellIn(item);
	}

	public void decreaseSellIn(Item item) {
		item.sellIn = item.sellIn - 1;
	}

	public void decreaseQuality(Item item) {
		decreaseQuality(item,1);
	}
	
	public void decreaseQuality(Item item, int amount) {
		if (item.quality > 0) {
			item.quality = item.quality - amount;
		}
	}

	public void increaseQuality(Item item) {
		if (item.quality < MAX_QUALITY) {
			item.quality = item.quality + 1;
		}
	}

}
