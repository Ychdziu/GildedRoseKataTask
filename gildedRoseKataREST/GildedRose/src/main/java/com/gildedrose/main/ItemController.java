package com.gildedrose.main;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	ItemService is;

	@RequestMapping("/all")
	public Hashtable<String, Item> getAll() {
		return is.getAll();
	}

	@RequestMapping("{id}")
	public Item getItem(@PathVariable("id") String id) {
		return is.getItem(id);
	}

}