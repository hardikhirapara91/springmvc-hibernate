package com.hardik.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hardik.spring.model.Contact;
import com.hardik.spring.service.ContactService;

/**
 * Contact Controller
 * 
 * @author HARDIK HIRAPARA
 *
 */
@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	/**
	 * Show Contact Form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public String showContacts(ModelMap model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("createContact", true);
		model.addAttribute("contacts", contactService.getAll());
		return "contacts";
	}

	/**
	 * Show Contact
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
	public String showContact(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("contact", contactService.getById(id));
		model.addAttribute("createContact", false);
		model.addAttribute("contacts", contactService.getAll());
		return "contacts";
	}

	/**
	 * Add or Update Contact
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") @Valid Contact contact, BindingResult result, ModelMap model) {

		model.addAttribute("contacts", contactService.getAll());

		if (result.hasErrors()) {
			return "contacts";
		}

		if (contact.getId() != null && contact.getId() > 0) {
			contactService.update(contact);
		} else {
			contactService.save(contact);
		}

		model.addAttribute("createContact", true);
		model.addAttribute("contact", new Contact());
		return "redirect:contacts";
	}

	/**
	 * Delete Contact
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteContact(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("createContact", true);
		model.addAttribute("contacts", contactService.getAll());
		contactService.delete(id);
		return "redirect:/contacts";
	}
}
