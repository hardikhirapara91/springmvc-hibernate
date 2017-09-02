package com.hardik.springmvc.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hardik.springmvc.controller.CategoryController;
import com.hardik.springmvc.model.Category;

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
		List<Category> categories = getSession().createCriteria(Category.class).list();
		logger.info(String.format("Getting categories on database and found %1$s categories.", categories.size()));
		return categories;
	}

	/**
	 * GET BY ID
	 */
	@Override
	public Category getCategory(Integer id) {
		logger.info("Getting category by categoryId=" + id);
		return (Category) getSession().createCriteria(Category.class).add(Restrictions.eq("categoryId", id))
				.uniqueResult();
	}

	/**
	 * SAVE
	 */
	@Override
	public void addCategory(Category category) {
		logger.info("Saving category on database.");
		persist(category);
	}

	/**
	 * UPDATE
	 */
	@Override
	public void updateCategory(Category category) {
		logger.info("Updating category on database.");
		update(category);
	}

	/**
	 * DELETE
	 */
	@Override
	public void deleteCategory(Category category) {
		logger.info("Deleting category on database.");
		delete(category);
	}

}
