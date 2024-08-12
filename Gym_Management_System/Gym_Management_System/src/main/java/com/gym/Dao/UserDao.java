package com.gym.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gym.Entity.User;

@Repository
public class UserDao {
	
	@Autowired
	SessionFactory f;

	public List<User> allUsers() {
		// TODO Auto-generated method stub
		Session s=f.openSession();
		Criteria c=s.createCriteria(User.class);
		List<User> lt=c.list();
		return lt;
	}

}
