package com.hardik.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hardik.springmvc.model.Category;
import com.hardik.springmvc.service.CategoryService;

/**
 * Welcome Controller
 * 
 * @author HARDIK HIRAPARA
 *
 */
@Controller
@RequestMapping("/")
public class CategoryController {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	/**
	 * Show Category View
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String showCategoryView(ModelMap model) {
		logger.info("CategoryController.getCategory() method calling...");

		model.addAttribute("category", new Category());
		model.addAttribute("categories", categoryService.getAll());
		return "category";
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public List<Category> getCategories(ModelMap model) {
		return categoryService.getAll();
	}

	/**
	 * Add Category
	 * 
	 * @param category
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/categories/add", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("category") @Valid Category category, BindingResult result,
			ModelMap model) {
		logger.info("CategoryController.saveCategory() method calling...");

		model.addAttribute("categories", categoryService.getAll());
		if (result.hasErrors()) {
			return "category";
		}

		if (category.getCategoryId() != null && category.getCategoryId() > 0) {
			categoryService.update(category);
		} else {
			categoryService.save(category);
		}

		model.addAttribute("category", new Category());
		return "redirect:/";
	}

	/**
	 * Update Category
	 * 
	 * @param category
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/categories/{id}/update", method = RequestMethod.GET)
	public String updateCategory(@PathVariable("id") Integer id, ModelMap model) {
		logger.info("CategoryController.updateCategory() method calling...");

		Category category = categoryService.getById(id);
		if (category != null) {
			model.addAttribute("category", categoryService.getById(id));
		} else {
			logger.info("Invalid category id on updating category.");
			model.addAttribute("category", new Category());
			model.addAttribute("errorMessage", "Invalid category id.");
		}

		model.addAttribute("categories", categoryService.getAll());
		return "category";
	}

	/**
	 * Delete Category
	 * 
	 * @param category
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/categories/{id}/delete", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") Integer id, ModelMap model) {
		logger.debug("CategoryController.deleteCategory() method calling...");

		Category category = categoryService.getById(id);
		if (category != null) {
			categoryService.delete(category);
		} else {
			logger.error("Invalid category id while deleting category.");
			model.addAttribute("errorMessage", "Invalid category id.");
		}

		model.addAttribute("category", new Category());
		model.addAttribute("categories", categoryService.getAll());
		return "redirect:/";
	}
}
