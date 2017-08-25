package com.hardik.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hardik.spring.dao.ContactDao;
import com.hardik.spring.model.Contact;

/**
 * Contact Service Implementation
 * 
 * @author HARDIK HIRAPARA
 *
 */
@Service("contactService")
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao contactDao;

	/**
	 * Get all
	 */
	@Transactional(readOnly = true)
	public List<Contact> getAll() {
		try {
			return contactDao.getContacts();
		} catch (Exception ex) {
			System.out.println("Exception: ContactService.() : " + ex);
		}

		return new ArrayList<Contact>();
	}

	/**
	 * Get by Id
	 */
	@Transactional(readOnly = true)
	public Contact getById(Integer id) {
		try {
			return contactDao.getContactById(id);
		} catch (Exception ex) {
			System.out.println("Exception: ContactService.() : " + ex);
		}

		return new Contact();
	}

	/**
	 * Save
	 */
	public void save(Contact contact) {
		try {
			contactDao.saveContact(contact);
		} catch (Exception ex) {
			System.out.println("Exception: ContactService.save() : " + ex);
		}
	}

	/**
	 * Update
	 */
	public void update(Contact contact) {
		try {
			contactDao.updateContact(contact);
		} catch (Exception ex) {
			System.out.println("Exception: ContactService.update() : " + ex);
		}
	}

	/**
	 * Delete
	 */
	public void delete(Integer id) {
		try {
			contactDao.deleteContact(id);
		} catch (Exception ex) {
			System.out.println("Exception: ContactService.delete() : " + ex);
		}
	}

}
