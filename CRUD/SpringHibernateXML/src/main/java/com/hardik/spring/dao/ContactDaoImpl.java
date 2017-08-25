package com.hardik.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hardik.spring.model.Contact;

/**
 * Contact DAO Implementation
 * 
 * @author HARDIK HIRAPARA
 *
 */
@Repository("contactDao")
public class ContactDaoImpl extends AbstractDao implements ContactDao {

	/**
	 * Get all contacts
	 */
	@SuppressWarnings("unchecked")
	public List<Contact> getContacts() {
		Criteria criteria = getSession().createCriteria(Contact.class);
		return criteria.list();
	}

	/**
	 * Get contacts by id
	 */
	public Contact getContactById(Integer id) {
		Criteria criteria = getSession().createCriteria(Contact.class);
		criteria.add(Restrictions.eq("id", id));
		return (Contact) criteria.uniqueResult();
	}

	/**
	 * Save Contact
	 */
	public void saveContact(Contact contact) {
		persist(contact);
	}

	/**
	 * Update Contact
	 */
	public void updateContact(Contact contact) {
		update(contact);
	}

	/**
	 * Delete Contact
	 */
	public void deleteContact(Integer id) {
		Contact contact = getContactById(id);
		getSession().delete(contact);
	}

}
