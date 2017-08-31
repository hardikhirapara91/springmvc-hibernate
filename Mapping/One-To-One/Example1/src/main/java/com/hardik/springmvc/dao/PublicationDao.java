package com.hardik.springmvc.dao;

import java.util.List;

import com.hardik.springmvc.bean.Publication;

/**
 * Publication DAO
 * 
 * @author HARDIK HIRAPARA
 *
 */
public interface PublicationDao {

	public List<Publication> getPublications();

	public Publication getPublication(int pubId);

	public void addPublication(Publication publication);

	public void updatePublication(Publication publication);

	public void deletePublication(int pubId);

}
