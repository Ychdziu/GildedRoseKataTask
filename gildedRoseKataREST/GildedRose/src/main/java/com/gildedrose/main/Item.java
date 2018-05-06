package com.gildedrose.main;

public class Item {

	public int id;
	public String name;
	public int sellIn;
	public int quality;

	public Item(int id, String name, int sellIn, int quality) {

		this.id = id;
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;

	}

	@Override

	public String toString() {

		return this.name + ", " + this.sellIn + ", " + this.quality;

	}

}