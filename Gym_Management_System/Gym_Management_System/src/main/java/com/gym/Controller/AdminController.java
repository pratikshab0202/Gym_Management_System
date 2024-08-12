package com.gym.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gym.Entity.Admin;
import com.gym.Entity.Membership;
import com.gym.Entity.Payment;
import com.gym.Entity.Trainer;
import com.gym.Entity.User;
import com.gym.Service.AdminService;
import com.gym.Service.MembershipService;
import com.gym.Service.PaymentService;
import com.gym.Service.TrainerService;
import com.gym.Service.UserService;

@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	UserService u;
	@Autowired
	TrainerService t;
	@Autowired
	AdminService a;
	@Autowired
	MembershipService m;
	@Autowired
	PaymentService p;

	@GetMapping("/addAdmin")
	public void addAdmin() {

		a.addAdmin();
	}
	
	@GetMapping("/allAdmins")
	public List<Admin> allAdmins() {

		return a.allAdmins();
		
	}

	@GetMapping("/allUsers")
	public List<User> allUsers() {

		return u.allUsers();
	}

	@PostMapping("/addUser")
	public void addUser(@RequestBody User us) {
		u.addUser(us);

	}

	@GetMapping("/getUser")
	public User getUser(@RequestParam int uid) {

		return u.getUser(uid);
	}

	@DeleteMapping("/deleteUser")
	public void deleteUser(@RequestParam int uid) {

		u.deleteUser(uid);
	}

	@PutMapping("/updateUser")
	public void updateUser(@RequestBody User us) {
		u.updateUser(us);

	}

	@GetMapping("/allTrainers")
	public List<Trainer> allTrainers() {

		return t.allTrainers();
	}

	@PostMapping("/addTrainer")
	public void addTrainer(@RequestBody Trainer trainer) {

		t.addTrainer(trainer);
	}

	@GetMapping("/getTrainer")
	public Trainer getTrainer(@RequestParam int tid) {

		return t.getTrainer(tid);
	}
	
	@PutMapping("/updateTrainer")
	public void updateTrainer(@RequestBody Trainer trainer) {
		t.updateTrainer(trainer);

	}

	@DeleteMapping("/deleteTrainer")
	public void deleteTrainer(@RequestParam int tid) {

		t.deleteTrainer(tid);
	}

	@GetMapping("/allMemberships")
	public List<Membership> allMemberships() {
		return m.allMemberships();

	}

	@PostMapping("/addMembership")
	public void addMembership(@RequestBody Membership mb) {
		m.addMembership(mb);

	}
	@GetMapping("/getMembership")
	public Membership getMembership(@RequestParam int membershipId) {

		return m.getMembership(membershipId);
	}
	
	@PutMapping("/updateMembership")
	public void updateMembership(@RequestBody Membership membership) {
		m.updateMembership(membership);

	}
	
	@DeleteMapping("/deleteMembership")
	public void deleteMembership(@RequestParam int membershipId) {

		m.deleteMembership(membershipId);
	}

	@PostMapping("/addPayment")
	public void addPayment(@RequestBody Payment payment) {
		
			p.addPayment(payment);
			System.out.println("payment Added Successfully");
		
	}
	
	@GetMapping("/allPayments")
	public List<Payment> allPayments() {

		return p.allPayments();
	}
	
	@GetMapping("/getPayment")
	public Payment getPayment(@RequestParam int paymentId) {

		return p.getPayment(paymentId);
	}
	
	@PutMapping("/updatePayment")
	public void updatePayment(@RequestBody Payment payment) {
		p.updatePayment(payment);

	}

	

}
