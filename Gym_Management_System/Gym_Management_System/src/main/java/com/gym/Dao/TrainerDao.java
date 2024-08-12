package com.gym.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gym.Entity.Trainer;
import com.gym.Entity.User;

@Repository
public class TrainerDao {
	
	@Autowired
	SessionFactory f;

	public List<Trainer> allTrainers() {
		// TODO Auto-generated method stub
		Session s=f.openSession();
		Criteria c=s.createCriteria(Trainer.class);
		List<Trainer> lt=c.list();
		return lt;
	}

}
