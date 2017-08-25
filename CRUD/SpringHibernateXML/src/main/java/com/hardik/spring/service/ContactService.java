package com.hardik.spring.service;

import java.util.List;

import com.hardik.spring.model.Contact;

/**
 * Contact Service
 * 
 * @author HARDIK HIRAPARA
 *
 */
public interface ContactService {
	public List<Contact> getAll();

	public Contact getById(Integer id);

	public void save(Contact contact);

	public void update(Contact contact);

	public void delete(Integer id);
}
