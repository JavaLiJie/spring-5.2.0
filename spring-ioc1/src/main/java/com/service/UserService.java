package com.service;

import com.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring
 * @ClassName UserService
 * @description:$
 * @author: 李杰
 * @create: 2020-05-24 15:23
 * @Version 1.0
 **/

//@Service
public class UserService {
	@Autowired
	private List<User> userList;

	//@Autowired
	private User user;

	public UserService(User user) {

	}

	public List<User> getUseList(){
		return userList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

    public void setUser(User user) {
    }
}