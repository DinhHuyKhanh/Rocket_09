package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.entity.User;
import com.vti.filter.FilterDepartment;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IUserRepository;
import com.vti.utils.Paging;
import com.vti.utils.Sorting;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository repository;

//	public List<Department> getAllDepartments(Paging paging, Sorting sorting, FilterDepartment filter, String search) {
//		return repository.getAllDepartments(paging, sorting, filter, search);
//	}
//
	public User getUserByID(short id) {
		return repository.getUserByID(id);
	}
//
	public User getUserByName(String name) {
		return repository.getUserByName(name);
	}
//
//	public void createDepartment(Department department) {
//		repository.createDepartment(department);
//	}
//
//	public void updateDepartment(short id, String newName, short totalMember) {
//		repository.updateDepartment(id, newName,totalMember);
//	}
//
//	public void updateDepartment(Department department) {
//		repository.updateDepartment(department);
//	}
//
//	public void deleteDepartment(short id) {
//		repository.deleteDepartment(id);
//	}
//
//	public boolean isDepartmentExistsByID(short id) {
//		return repository.isDepartmentExistsByID(id);
//	}
//
//	public boolean isDepartmentExistsByName(String name) {
//		return repository.isDepartmentExistsByName(name);
//	}
}
