package com.gym.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gym.Dao.PaymentDao;
import com.gym.Entity.Payment;
import com.gym.Entity.Trainer;
import com.gym.Entity.User;


@Service
public class PaymentService {
	
	@Autowired
	SessionFactory f;
	@Autowired
	PaymentDao d;

	public void addPayment(Payment payment) {
		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		s.saveOrUpdate(payment);
		t.commit();
		System.out.println("Added Successfully");
		
	}

	public List<Payment> allPayments() {
		// TODO Auto-generated method stub
		return d.allPayments();
	}

	public Payment getPayment(int paymentId) {
		List<Payment> lt=d.allPayments();
		Payment obj=new Payment();
		for(Payment p:lt) {
			if(p.getPaymentId()==paymentId) {
				obj=p;
			}
		}
		
		return obj;
			}

	public void updatePayment(Payment payment) {
		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		s.update(payment);
		t.commit();
		System.out.println("Payment Updated");
		
	}

}
