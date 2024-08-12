package com.gym.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	int uid;
	String name;
	String user_name;
	String pass;
	String email;
	long contact;
	int age;
	String gender;
	String address;
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="uid")
//	List<Payment> p;
//	public List<Payment> getU() {
//		return p;
//	}
//	public void setU(List<Payment> p) {
//		this.p = p;
//	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String user_name, String pass, String email, int contact, int age, String gender,
			String address) {
		super();
		this.name = name;
		this.user_name = user_name;
		this.pass = pass;
		this.email = email;
		this.contact = contact;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", user_name=" + user_name + ", pass=" + pass + ", email="
				+ email + ", contact=" + contact + ", age=" + age + ", gender=" + gender + ", address=" + address + "]";
	}
	
	

}
