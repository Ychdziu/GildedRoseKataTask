package com.gildedrosekata.main;

public class GildedRose {

	Item[] items;

	public GildedRose(Item[] items) {

		this.items = items;

	}

	public void updateQuality() {

		for (Item item : items) {

			updateQuality(item);

			updateSellIn(item);

			updateExpired(item);

		}

	}

	public void updateQuality(Item item) {
		if (!item.name.equals("Aged Brie")

				&& !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

			if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {

				decreaseQuality(item);

			}

		} else {

			increaseQuality(item);

			if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

				if (item.sellIn < 11) {

					increaseQuality(item);

				}

				if (item.sellIn < 6) {

					increaseQuality(item);

				}

			}

		}
	}

	public void updateSellIn(Item item) {
		if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {

			item.sellIn = item.sellIn - 1;

		}
	}

	public void updateExpired(Item item) {
		if (item.sellIn < 0) {

			if (!item.name.equals("Aged Brie")) {

				if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

					if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {

						decreaseQuality(item);

					}

				} else {

					item.quality = 0;

				}

			} else {

				increaseQuality(item);

			}

		}
	}

	public void decreaseQuality(Item item) {
		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}
	}

	public void increaseQuality(Item item) {
		if (item.quality < 50) {
			item.quality = item.quality + 1;
		}
	}

}
