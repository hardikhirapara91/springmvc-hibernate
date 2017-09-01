package com.hardik.springmvc.dao;

import java.util.List;

import com.hardik.springmvc.model.Category;

/**
 * Category DAO
 * 
 * @author HARDIK HIRAPARA
 *
 */
public interface CategoryDao {

	public List<Category> getCategories();

	public Category getCategory(int categoryId);

	public void addCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(int categoryId);

}
