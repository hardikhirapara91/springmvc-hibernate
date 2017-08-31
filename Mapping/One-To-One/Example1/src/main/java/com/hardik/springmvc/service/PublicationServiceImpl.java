package com.hardik.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hardik.springmvc.bean.Publication;
import com.hardik.springmvc.controller.CategoryController;
import com.hardik.springmvc.dao.PublicationDao;

/**
 * Publication Service Implementation
 * 
 * @author HARDIK HIRAPARA
 *
 */
@Service("publicationService")
@Transactional
public class PublicationServiceImpl implements PublicationService {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private PublicationDao publicationDao;

	/**
	 * Get All Publications
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Publication> getAll() {
		try {
			return publicationDao.getPublications();
		} catch (Exception ex) {
			logger.error("Exception|PublicationService.getAll()| get all publications:", ex);
		}

		return new ArrayList<Publication>();
	}

	/**
	 * Get Publication By Id
	 * 
	 * @param pubId
	 * @return
	 */
	@Override
	@Transactional
	public Publication getById(int pubId) {
		try {
			return publicationDao.getPublication(pubId);
		} catch (Exception ex) {
			logger.error("Exception|PublicationService.getById()| getting by publication id: ", ex);
		}

		return new Publication();
	}

	/**
	 * Save Publication
	 */
	@Override
	public void save(Publication publication) {
		try {
			publicationDao.addPublication(publication);
		} catch (Exception ex) {
			logger.error("Exception|PublicationService.save()| add new publication: ", ex);
		}
	}

	/**
	 * Update Publication
	 */
	@Override
	public void update(Publication publication) {
		try {
			publicationDao.updatePublication(publication);
		} catch (Exception ex) {
			logger.error("Exception|PublicationService.update()| updating publication: ", ex);
		}
	}

	/**
	 * Delete Publication
	 */
	@Override
	public void delete(int pubId) {
		try {
			publicationDao.deletePublication(pubId);
		} catch (Exception ex) {
			logger.error("Exception|PublicationService.delete()| deleting publication: ", ex);
		}
	}

}
