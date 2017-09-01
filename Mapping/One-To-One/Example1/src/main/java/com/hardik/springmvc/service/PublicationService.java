package com.hardik.springmvc.service;

import java.util.List;

import com.hardik.springmvc.model.Publication;

/**
 * Publication Service
 * 
 * @author HARDIK HIRAPARA
 *
 */
public interface PublicationService {

	public void save(Publication publication);

	public List<Publication> getAll();

	public Publication getById(int pubId);

	public void update(Publication publication);

	public void delete(int pubId);

}
