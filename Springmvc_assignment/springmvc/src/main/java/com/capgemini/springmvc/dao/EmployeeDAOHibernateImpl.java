package com.capgemini.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.springmvc.beans.EmplooyeeInfoBean;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

	@Override
	public EmplooyeeInfoBean getEmployee(int empId) {
		EntityManager manager = factory.createEntityManager();
		EmplooyeeInfoBean emplooyeeInfoBean = manager.find(EmplooyeeInfoBean.class, empId);
		manager.close();
		return emplooyeeInfoBean;
	}

	@Override
	public boolean addEmployee(EmplooyeeInfoBean emplooyeeInfoBean) {
		boolean isAdded = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(emplooyeeInfoBean);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isDeleted = false;
		try {
			transaction.begin();
			EmplooyeeInfoBean emplooyeeInfoBean = manager.find(EmplooyeeInfoBean.class, empId);
			manager.remove(emplooyeeInfoBean);
			transaction.commit();
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return isDeleted;
	}

	@Override
	public boolean updateEmployee(EmplooyeeInfoBean emplooyeeInfoBean) {
		EntityManager manager = factory.createEntityManager();
		EmplooyeeInfoBean bean = manager.find(EmplooyeeInfoBean.class, emplooyeeInfoBean.getEmpId());
		boolean isUpdated = false;
		if (bean != null) {
			try {
				EntityTransaction transaction = manager.getTransaction();
				transaction.begin();
				manager.remove(bean);
				manager.persist(emplooyeeInfoBean);
				transaction.commit();
				isUpdated = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				manager.close();
			}

		}
		return isUpdated;
	}

	@Override
	public List<EmplooyeeInfoBean> getAllEmployees() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "Select e from EmplooyeeInfoBean e";
		Query query = manager.createQuery(jpql);
		List<EmplooyeeInfoBean> list = query.getResultList();
		return list;

	}

}
