package com.gym.Service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gym.Dao.TrainerDao;
import com.gym.Dao.UserDao;
import com.gym.Entity.Trainer;
import com.gym.Entity.User;

@Service
public class TrainerService {
	
	@Autowired
	SessionFactory f;
	@Autowired
	TrainerDao td;
	
	public void addTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		
		Session s=f.openSession();
		Transaction tr=s.beginTransaction();
		s.saveOrUpdate(trainer);
		tr.commit();
		System.out.println("Added Successfully");
	}

	public List<Trainer> allTrainers() {
		// TODO Auto-generated method stub
		return td.allTrainers();
	}

	public Trainer getTrainer(int tid) {
		Session s=f.openSession();
		Criteria c=s.createCriteria(Trainer.class);
		List<Trainer> lt=c.list();
		Trainer obj=new Trainer();
		for(Trainer t:lt) {
			if(t.getTrainerId()==tid) {
				obj=t;
			}
		}
		
		return obj;	}
	
//	public void addTrainerToUser() {
//		// TODO Auto-generated method stub
//		
//		Session s=f.openSession();
//		Transaction tr=s.beginTransaction();
//		Trainer t=new Trainer(1);
//		User u=new User("Raj","Raj@123","123","Raj@gmail.com",76454321,22,"male","Pune");
//		User u2=new User("Rohit","Rohit@123","123","Rohit@gmail.com",76454321,22,"male","Mumbai");
//        ArrayList<User> al=new ArrayList<User>();
//        al.add(u);
//        al.add(u2);
//        t.setU(al);
//		s.saveOrUpdate(t);
//		tr.commit();
//		System.out.println("Added Successfully");
//	}

	public void deleteTrainer(int tid) {
		Session s=f.openSession();
		Transaction tr=s.beginTransaction();
		List<Trainer> lt=td.allTrainers();
        Trainer obj=s.load(Trainer.class, tid);

		s.delete(obj);
		tr.commit();
		System.out.println(" Trainer deleted ");
		
	}

	public void updateTrainer(Trainer trainer) {
		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		s.update(trainer);
		t.commit();
		System.out.println("Trainer Updated");		
	}

}
