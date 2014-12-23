package com.volnoboy.jb.service;

import com.volnoboy.jb.entity.Item;
import com.volnoboy.jb.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by volnoboy on 12/23/14.
 */
@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> getItems() {
		return itemRepository.findAll(new PageRequest(0, 20, Sort.Direction.DESC, "publishedDate")).getContent();
	}
}
