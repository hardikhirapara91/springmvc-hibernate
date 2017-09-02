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

	public Publication getById(Integer id);

	public void update(Publication publication);

	public void delete(Publication publication);

}
