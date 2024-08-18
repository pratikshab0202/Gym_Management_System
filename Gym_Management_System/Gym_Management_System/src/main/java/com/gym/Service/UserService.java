package com.gym.Service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gym.Dao.UserDao;
import com.gym.Entity.User;

@Service
public class UserService {
	
	@Autowired
	SessionFactory f;
	@Autowired
	UserDao u;
	
	public void addUser(User us) {
		// TODO Auto-generated method stub
		
		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		s.saveOrUpdate(us);
		t.commit();
		System.out.println("Added Successfully");
	}

	public List<User> allUsers() {
		// TODO Auto-generated method stub
		return u.allUsers();
	}

	public User getUser(int uid) {
		Session s=f.openSession();
		List<User> lt=u.allUsers();
		User obj=new User();
		for(User u:lt) {
			if(u.getUid()==uid) {
				obj=u;
			}
		}
		
		return obj;
		
	}

	public void deleteUser(int uid) {
		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		List<User> lt=u.allUsers();
        User u=s.load(User.class, uid);

		s.delete(u);
		t.commit();
		System.out.println(" user deleted ");
		
	}

	public void updateUser(User us) {
		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		s.update(us);
		t.commit();
		System.out.println("User Updated");
	}

	public User loginUser(String user_name, String pass) {
        Session s=f.openSession();
        Criteria c=s.createCriteria(User.class);
        List<User>lt=c.list();
        User obj=new User();
        for(User u:lt) {
        	if(u.getUser_name().equals(user_name) && u.getPass().equals(pass)) {
        		obj=u;
        	}
        }
		return obj;
	}

	
}
