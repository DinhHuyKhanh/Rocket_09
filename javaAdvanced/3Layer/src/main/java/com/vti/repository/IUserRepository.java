package com.vti.repository;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.vti.entity.User;
import com.vti.filter.FilterDepartment;
import com.vti.utils.Paging;
import com.vti.utils.Sorting;

public interface IUserRepository {
//	public List<User> getAllUsers(Paging paging, Sorting sorting, FilterDepartment filter, @RequestParam(name = "search") String search);
	public User getUserByID(short id);
	public User getUserByName(String name);

}
