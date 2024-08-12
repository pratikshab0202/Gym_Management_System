package com.gym.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gym.Entity.Payment;
import com.gym.Entity.User;

@Repository
public class PaymentDao {
	
	@Autowired
	SessionFactory f;

	public List<Payment> allPayments() {
		Session s=f.openSession();
		Criteria c=s.createCriteria(Payment.class);
		List<Payment> lt=c.list();
		return lt;
	}
	
	

}
