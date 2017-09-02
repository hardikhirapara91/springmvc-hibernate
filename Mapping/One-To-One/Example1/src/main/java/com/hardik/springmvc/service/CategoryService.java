package com.hardik.springmvc.service;

import java.util.List;

import com.hardik.springmvc.model.Category;

/**
 * Category Service
 * 
 * @author HARDIK HIRAPARA
 *
 */
public interface CategoryService {

	public List<Category> getAll();

	public Category getById(Integer id);

	public void save(Category category);

	public void update(Category category);

	public void delete(Category category);
}
