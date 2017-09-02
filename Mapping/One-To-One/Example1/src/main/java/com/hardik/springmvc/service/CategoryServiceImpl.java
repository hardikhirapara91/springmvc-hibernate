package com.hardik.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hardik.springmvc.controller.CategoryController;
import com.hardik.springmvc.dao.CategoryDao;
import com.hardik.springmvc.model.Category;

/**
 * Category Service Implementation
 * 
 * @author HARDIK HIRAPARA
 *
 */
@Service("categoryService")
@Transactional(propagation = Propagation.SUPPORTS)
public class CategoryServiceImpl implements CategoryService {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryDao categoryDao;

	/**
	 * Get All Categories
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Category> getAll() {
		try {
			return categoryDao.getCategories();
		} catch (Exception ex) {
			logger.error("Exception|CategoryService.getAll()| while getting all categories: ", ex);
		}

		return new ArrayList<Category>();
	}

	/**
	 * Get Category By Id
	 */
	@Override
	@Transactional(readOnly = true)
	public Category getById(Integer categoryId) {
		try {
			return categoryDao.getCategory(categoryId);
		} catch (Exception ex) {
			logger.error("Exception|CategoryService.getById()| while getting category by id: ", ex);
		}

		return new Category();
	}

	/**
	 * Save Category
	 */
	@Override
	public void save(Category category) {
		try {
			categoryDao.addCategory(category);
		} catch (Exception ex) {
			logger.error("Exception|CategoryService.save()| while save category: ", ex);
		}
	}

	/**
	 * Update Category
	 */
	@Override
	public void update(Category category) {
		try {
			categoryDao.updateCategory(category);
		} catch (Exception ex) {
			logger.error("Exception|CategoryService.update()| while updating category: ", ex);
		}
	}

	/**
	 * Delete Category
	 */
	@Override
	public void delete(Category category) {
		try {
			categoryDao.deleteCategory(category);
		} catch (Exception ex) {
			logger.error("Exception|CategoryService.delete()| while deliting category: ", ex);
		}
	}

}
