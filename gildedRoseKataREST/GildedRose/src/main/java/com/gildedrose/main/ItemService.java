package com.gildedrose.main;

import org.springframework.stereotype.Service;
import java.util.Hashtable;

@Service
public class ItemService {
	Hashtable<String, Item> items = new Hashtable<String, Item>();

	public ItemService() {
		Item it = new Item(1, "Aged Brie", 2, 0);
		items.put("1", it);

		it = new Item(2, "Elixir of the Mongoose", 5, 7);
		items.put("2", it);

		it = new Item(3, "Sulfuras, Hand of Ragnaros", 0, 80);
		items.put("3", it);
	}

	public Item getItem(String id) {
		if (items.containsKey(id)) {
			return items.get(id);
		} else
			return null;
	}

	public Hashtable<String, Item> getAll() {
		return items;
	}

}