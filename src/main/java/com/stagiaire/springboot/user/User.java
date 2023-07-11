package com.stagiaire.springboot.user;
import java.time.LocalDate;
//import java.util.List;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="test")

public class User {
	@Id
	@SequenceGenerator(
			name="user-sequence",
			sequenceName="user-sequence",
			allocationSize=1
			
			)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="user-sequence"
			)
	
	//@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
   // private List<Book> books;
	
	@Column(name="id")
	private long id;
	@Column(name="fname")
	private String fname;
	@Column(name="lname")
	private String lname;
	@Column(name="dob")
	private LocalDate dob;
	@Column(name="email")
	private String email;
	@Column(name="pass")
	private String password;
	@Column(name="gender")
	private String gender;
	@Column(name="role")
	private String role;
	
	
	public User() {
		
	}
	
	public User(long id, String fname, String lname, LocalDate dob, String email,String password, String gender, String role) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.role= role;

	}
	public User(String fname, String lname, LocalDate dob, String email,String password, String gender, String role) {
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.role= role;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return fname;
	}
	public void setFirstName(String fname) {
		this.fname = fname;
	}
	public String getLastName() {
		return lname;
	}
	public void setLastName(String lname) {
		this.lname = lname;
	}
	public LocalDate getBirthDate() {
		return dob;
	}
	public void setBirthDate(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + fname + ", lastName=" + lname + ", birthDate=" + dob
				+ ", email=" + email + ", password=" + password + ", gender=" + gender + ", role=" + role + "]";
	}
	
	
	
	
	

}
