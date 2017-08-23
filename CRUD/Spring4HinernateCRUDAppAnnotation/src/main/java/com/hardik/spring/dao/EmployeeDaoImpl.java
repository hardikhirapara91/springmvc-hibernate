package com.hardik.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hardik.spring.model.Employee;

/**
 * Employee DAO Implementation
 * 
 * @author HARDIK HIRAPARA
 *
 */
@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

	/**
	 * Get all employees
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {
		Criteria criteria = getSession().createCriteria(Employee.class);
		return criteria.list();
	}

	/**
	 * Get employee by Id
	 */
	@Override
	public Employee getEmployeeById(Integer id) {
		Criteria criteria = getSession().createCriteria(Employee.class);
		return (Employee) criteria.uniqueResult();
	}

	/**
	 * Save employee
	 */
	@Override
	public void saveEmployee(Employee employee) {
		persist(employee);
	}

	/**
	 * Update employee
	 */
	@Override
	public void updateEmployee(Employee employee) {
		// update(employee);
	}

	/**
	 * Delete employee
	 */
	@Override
	public void deleteEmployee(Integer id) {
		Query query = getSession().createQuery("DELETE FROM employee WHERE id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
