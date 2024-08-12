package com.gym.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gym.Dao.MembershipDao;
import com.gym.Entity.Membership;
import com.gym.Entity.Payment;
import com.gym.Entity.Trainer;

@Service
public class MembershipService {
	
	@Autowired
	SessionFactory f;
	@Autowired
	MembershipDao m;

	public List<Membership> allMemberships() {
		// TODO Auto-generated method stub
		return m.allMemberships();
	}

	public void addMembership(Membership mb) {

		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		s.save(mb);
		t.commit();
	}

	public Membership getMembership(int membershipId) {
		// TODO Auto-generated method stub
		List<Membership> lt=m.allMemberships();
		Membership obj=new Membership();
		for(Membership p:lt) {
			if(p.getMembershipId()==membershipId) {
				obj=p;
			}
		}
		
		return obj;
			}

	public void deleteMembership(int membershipId) {
		Session s=f.openSession();
		Transaction tr=s.beginTransaction();
		List<Membership> lt=m.allMemberships();
		Membership obj=s.load(Membership.class, membershipId);

		s.delete(obj);
		tr.commit();
		System.out.println(" Membership deleted ");		
	}

	public void updateMembership(Membership membership) {
		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		s.update(membership);
		t.commit();
		System.out.println("Membership Updated");
		
	}

}
