package org.devcrew.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
@Entity
@Table(name="playlist")
public class Playlist {

	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	@Column(name="name")
	private String name;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="user")
	@JsonProperty(access = Access.WRITE_ONLY)
	private User user;
	@ManyToMany(mappedBy = "playlists")
	private Set<Track> tracks;
	@Column(name="create_date")
	private Date createDate;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@JsonIgnore
	public User getUser() {
		return user;
	}
	@JsonIgnore
	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + id + ", name=" + name + ", user=" + user + ", tracks=" + tracks + ", createDate="
				+ createDate + "]";
	}
}
