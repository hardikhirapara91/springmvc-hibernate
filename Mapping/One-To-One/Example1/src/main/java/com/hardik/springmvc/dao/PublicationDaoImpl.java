package com.hardik.springmvc.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
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
		List<Publication> publications = getSession().createCriteria(Publication.class).list();
		logger.info(String.format("Getting publications and found %1$s publications", publications.size()));
		return publications;
	}

	/**
	 * GET BY ID
	 */
	@Override
	public Publication getPublication(Integer id) {
		logger.info("Getting publication by publication id=" + id);
		return (Publication) getSession().createCriteria(Publication.class).add(Restrictions.eq("pubId", id))
				.uniqueResult();
	}

	/**
	 * SAVE
	 */
	@Override
	public void addPublication(Publication publication) {
		logger.info("Saving publication on database.");
		persist(publication);
	}

	/**
	 * UPDATE
	 */
	@Override
	public void updatePublication(Publication publication) {
		logger.info("Updating publication on database.");
		update(publication);
	}

	/**
	 * DELETE
	 */
	@Override
	public void deletePublication(Publication publication) {
		logger.info("Deleting publication on database.");
		delete(publication);
	}

}
