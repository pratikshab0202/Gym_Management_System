package com.gym.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gym.Dao.AdminDao;
import com.gym.Entity.Admin;

@Service
public class AdminService {
	
	@Autowired
	SessionFactory f;
	@Autowired
	AdminDao a;


	public void addAdmin() {
		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		Admin a=new Admin("admin","pratu@123");
		s.saveOrUpdate(a);
		t.commit();
		System.out.println("added successfully");
		
	}

	public List<Admin> allAdmins() {
		return a.allAdmins();	
		}

}
