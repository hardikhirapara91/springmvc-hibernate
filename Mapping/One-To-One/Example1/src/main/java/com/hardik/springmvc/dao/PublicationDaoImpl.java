package com.hardik.springmvc.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hardik.springmvc.controller.CategoryController;
import com.hardik.springmvc.model.Publication;

/**
 * Publication DAO Implementation
 * 
 * @author HARDIK HIRAPARA
 *
 */
@Repository("publicationDao")
public class PublicationDaoImpl extends AbstractDao implements PublicationDao {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	/**
	 * GET ALL
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Publication> getPublications() {
		return getSession().createCriteria(Publication.class).list();
	}

	/**
	 * GET BY ID
	 */
	@Override
	public Publication getPublication(int pubId) {
		return (Publication) getSession().load(Publication.class, pubId);
	}

	/**
	 * SAVE
	 */
	@Override
	public void addPublication(Publication publication) {
		persist(publication);
	}

	/**
	 * UPDATE
	 */
	@Override
	public void updatePublication(Publication publication) {
		update(publication);
	}

	/**
	 * DELETE
	 */
	@Override
	public void deletePublication(int pubId) {
		Publication publication = getPublication(pubId);
		if (publication != null) {
			delete(publication);
		}
	}

}
