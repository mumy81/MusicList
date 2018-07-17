package org.devcrew.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private long userId;
	@Column(name="username")
	private String username;
	@Column(name="email")
	private String email;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="password")
	private String password;
	@Column(name="birthdate")
	private Date birthdate;
	@Column(name="phone")
	private String phone;
	@OneToMany(mappedBy="user")
	private List<Playlist> playlists;
	@Column(name="role")
	private String role;

	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", name=" + name + ", surname=" + surname
				+ ", password=" + password + ", birthdate=" + birthdate + ", phone=" + phone + ", playlists="
				+ playlists + ", role=" + role + "]";
	}
	
	

}
