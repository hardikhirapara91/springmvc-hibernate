package com.hardik.springmvc.controller;

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
	public String getCagegory(ModelMap model) {
		model.addAttribute("category", new Category());
		model.addAttribute("categories", categoryService.getAll());

		System.out.println(categoryService.getAll());

		return "category";
	}

	/**
	 * Add Category
	 * 
	 * @param category
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("category") @Valid Category category, BindingResult result,
			ModelMap model) {

		model.addAttribute("categories", categoryService.getAll());
		if (result.hasErrors()) {
			return "category";
		}

		categoryService.save(category);
		model.addAttribute("category", new Category());

		return "redirect:/";
	}

	/**
	 * Get Category
	 * 
	 * @param category
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/category/{id}/update", method = RequestMethod.GET)
	public String updateCategory(@PathVariable("id") Integer id, ModelMap model) {

		model.addAttribute("category", categoryService.getById(id));
		return "category";
	}
}
