package com.hardik.spring.dao;

import java.util.List;

import com.hardik.spring.model.Contact;

/**
 * Contact DAO
 * 
 * @author HARDIK HIRAPARA
 *
 */
public interface ContactDao {
	public List<Contact> getContacts();

	public Contact getContactById(Integer id);

	public void saveContact(Contact contact);

	public void updateContact(Contact contact);

	public void deleteContact(Integer id);
}
