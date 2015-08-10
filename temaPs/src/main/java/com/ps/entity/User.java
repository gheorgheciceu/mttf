package com.ps.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Email;

@Entity
public class User {
	
	
	@Id
	@GeneratedValue
	int id;
	
	@ManyToOne
	@JoinColumn(name = "role")
	private Role role;
	
	
	@Email
	private String username;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	@Lob
	@Column(length = 25 * 1024 * 1024)
	// 5 mb
	private byte[] image;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
	private List<Operation> operations;
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@JsonIgnore
	public List<Operation> getOperations() {
		return operations;
	}
	@JsonIgnore
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
}
