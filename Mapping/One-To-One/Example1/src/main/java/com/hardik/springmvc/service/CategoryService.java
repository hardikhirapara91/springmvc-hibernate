package com.hardik.springmvc.service;

import java.util.List;

import com.hardik.springmvc.bean.Category;

/**
 * Category Service
 * 
 * @author HARDIK HIRAPARA
 *
 */
public interface CategoryService {

	public List<Category> getAll();

	public Category getById(Integer categoryId);

	public void save(Category category);

	public void update(Category category);

	public void delete(Integer categoryId);
}
