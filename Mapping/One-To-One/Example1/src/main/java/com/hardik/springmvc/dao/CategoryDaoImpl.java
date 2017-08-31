package com.hardik.springmvc.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hardik.springmvc.bean.Category;
import com.hardik.springmvc.controller.CategoryController;

/**
 * Category DAO Implementation
 * 
 * @author HARDIK HIRAPARA
 *
 */
@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao implements CategoryDao {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	/**
	 * GET ALL
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Category> getCategories() {
		return getSession().createCriteria(Category.class).list();
	}

	/**
	 * GET BY ID
	 */
	@Override
	public Category getCategory(int categoryId) {
		return (Category) getSession().createCriteria(Category.class)
				.add(Restrictions.eqOrIsNull("cagegoryId", categoryId)).uniqueResult();
	}

	/**
	 * SAVE
	 */
	@Override
	public void addCategory(Category category) {
		persist(category);
	}

	/**
	 * UPDATE
	 */
	@Override
	public void updateCategory(Category category) {
		update(category);
	}

	/**
	 * DELETE
	 */
	@Override
	public void deleteCategory(int categoryId) {
		Category category = getCategory(categoryId);
		if (category != null) {
			delete(category);
		}
	}

}
