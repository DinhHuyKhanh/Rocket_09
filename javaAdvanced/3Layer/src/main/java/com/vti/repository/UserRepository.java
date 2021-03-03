package com.vti.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import com.vti.entity.Department;
import com.vti.entity.User;
import com.vti.filter.FilterDepartment;
import com.vti.utils.HibernateUtils;
import com.vti.utils.Paging;
import com.vti.utils.Sorting;

@Repository
public class UserRepository implements IUserRepository {

	private HibernateUtils hibernateUtils;

	public UserRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

//	@SuppressWarnings({ "unchecked", "deprecation" })
//	public List<User> getAllUsers(Paging paging, Sorting sorting, FilterDepartment filter, @RequestParam(name = "search") String search) {
//
//		Session session = null;
//
//		try {
//
//			// get session
//			session = hibernateUtils.openSession();
//
//			// create hql query
//			Criteria criteria = session.createCriteria(User.class);
//			
//			// search
//			if(!StringUtils.isEmpty(search)) {
//				Criterion seachByName = Restrictions.ilike("name", "%" + search + "%");
//				//Criterion seachByID = Restrictions.like("id", search);
//				//criteria.add(Restrictions.or(seachByName,seachByID));
//				
//				criteria.add(seachByName);
//			}
//			
//			// filter
//			// min Member
//			if(null != filter.getMinMember()) {
//				criteria.add(Restrictions.ge("totalMember", filter.getMinMember().shortValue()));
//			}
//			
//			// max Member
//			if(null != filter.getMaxMember()) {
//				criteria.add(Restrictions.le("totalMember", filter.getMaxMember().shortValue()));
//			}
//
//			// sorting
//			criteria.addOrder(
//					sorting.getSortType().equals("ASC") ? 
//							Order.asc(sorting.getSortField()): 
//							Order.desc(sorting.getSortField()));
//
//			// paging
//			criteria.setFirstResult((paging.getPageNumber() - 1) * paging.getPageSize());
//			criteria.setMaxResults(paging.getPageSize());
//			
//			// return result
//			return criteria.list();
//
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}

	public User getUserByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			User user = session.get(User.class, id);

			return user;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
//
	@SuppressWarnings("unchecked")
	public User getUserByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<User> query = session.createQuery("FROM User WHERE username = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			User user = query.uniqueResult();

			return user;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	public void createDepartment(User user) {
//
//		Session session = null;
//
//		try {
//
//			// get session
//			session = hibernateUtils.openSession();
//			session.beginTransaction();
//
//			// create
//			session.save(user);
//
//			session.getTransaction().commit();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}

//	public void updateUser(short id, String newName, short totalMember) {
//
//		Session session = null;
//
//		try {
//
//			// get session
//			session = hibernateUtils.openSession();
//			session.beginTransaction();
//
//			// get department
//			User user = (User) session.load(User.class, id);
//
//			// update
//			user.setName(newName);
//			user.setTotalMember(totalMember);
//
//			session.getTransaction().commit();
//
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}

//	public void updateDepartment(Department department) {
//
//		Session session = null;
//
//		try {
//
//			// get session
//			session = hibernateUtils.openSession();
//			session.beginTransaction();
//
//			// update
//			session.update(department);
//
//			session.getTransaction().commit();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}
//
//	public void deleteDepartment(short id) {
//
//		Session session = null;
//
//		try {
//
//			// get session
//			session = hibernateUtils.openSession();
//			session.beginTransaction();
//
//			// get department
//			Department department = (Department) session.load(Department.class, id);
//
//			// delete
//			session.delete(department);
//
//			session.getTransaction().commit();
//
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}
//
//	public boolean isDepartmentExistsByID(short id) {
//
//		// get department
//		Department department = getDepartmentByID(id);
//
//		// return result
//		if (department == null) {
//			return false;
//		}
//
//		return true;
//	}
//
//	public boolean isDepartmentExistsByName(String name) {
//		Department department = getDepartmentByName(name);
//
//		if (department == null) {
//			return false;
//		}
//		return true;
//	}

}
