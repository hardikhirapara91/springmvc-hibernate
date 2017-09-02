package com.hardik.springmvc.dao;

import java.util.List;

import com.hardik.springmvc.model.Publication;

/**
 * Publication DAO
 * 
 * @author HARDIK HIRAPARA
 *
 */
public interface PublicationDao {

	public List<Publication> getPublications();

	public Publication getPublication(Integer id);

	public void addPublication(Publication publication);

	public void updatePublication(Publication publication);

	public void deletePublication(Publication publication);

}
