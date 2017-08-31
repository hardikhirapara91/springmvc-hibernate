package com.hardik.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
