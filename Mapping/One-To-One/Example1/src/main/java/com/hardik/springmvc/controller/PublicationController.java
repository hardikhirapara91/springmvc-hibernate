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

import com.hardik.springmvc.model.Publication;
import com.hardik.springmvc.service.CategoryService;
import com.hardik.springmvc.service.PublicationService;

/**
 * Publication Controller
 * 
 * @author HARDIK HIRAPARA
 *
 */
@Controller
public class PublicationController {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private PublicationService publicationService;

	@Autowired
	private CategoryService categoryService;

	/**
	 * Show Publication View
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/publications", method = RequestMethod.GET)
	public String showPublicationView(ModelMap model) {
		logger.info("PublicationController.showPublicationView() method calling...");

		model.addAttribute("publication", new Publication());
		model.addAttribute("publications", publicationService.getAll());
		model.addAttribute("categories", categoryService.getAll());

		return "publication";
	}

	/**
	 * Add Publication
	 * 
	 * @return
	 */
	@RequestMapping(value = "/publications/add", method = RequestMethod.POST)
	public String addPublication(@ModelAttribute("publication") @Valid Publication publication, BindingResult result,
			ModelMap model) {
		logger.info("PublicationController.addPublication() method calling...");

		model.addAttribute("publications", publicationService.getAll());
		if (result.hasErrors()) {
			return "publication";
		}

		if (publication.getPubId() != null && publication.getPubId() > 0) {
			publicationService.update(publication);
		} else {
			publicationService.save(publication);
		}

		model.addAttribute("publication", new Publication());
		return "redirect:/publications";
	}

	/**
	 * Update Publication
	 * 
	 * @return
	 */
	@RequestMapping(value = "/publications/{id}/update", method = RequestMethod.GET)
	public String updatePublication(@PathVariable("id") Integer id, ModelMap model) {
		logger.info("PublicationController.updateController() method calling...");

		Publication publication = publicationService.getById(id);
		if (publication != null) {
			model.addAttribute("publication", publication);
		} else {
			logger.error("Invalid publication id on updating publication.");
			model.addAttribute("errorMessage", "Invalid publication id.");
			model.addAttribute("publication", new Publication());
		}

		model.addAttribute("publications", publicationService.getAll());
		return "publication";
	}

	/**
	 * Delete Publication
	 * 
	 * @return
	 */
	@RequestMapping(value = "/publications/{id}/delete", method = RequestMethod.GET)
	public String deletePublication(@PathVariable("id") Integer id, ModelMap model) {
		logger.info("PublicationController.deletePublication() method calling...");

		Publication publication = publicationService.getById(id);
		if (publication != null) {
			publicationService.delete(publication);
		} else {
			logger.error("Invalid publication id on deleting publication.");
			model.addAttribute("errorMessage", "Invalid publication id.");
		}
		model.addAttribute("publication", new Publication());
		model.addAttribute("publications", publicationService.getAll());

		return "redirect:/publications";
	}
}
