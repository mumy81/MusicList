package org.devcrew.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="playlist")
public class Playlist {

	@Id
	@GeneratedValue
	@Column(name="playlist_id")
	private long playlistId;
	@Column(name="name")
	private String name;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@ManyToMany(mappedBy = "playlists")
	private List<Track> tracks;
	@Column(name="create_date")
	private Date createDate;

	
	public long getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(long playlistId) {
		this.playlistId = playlistId;
	}

	public User getUser() {
		return user;
	}

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

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "Playlist [name=" + name + ", tracks=" + tracks + ", createDate=" + createDate + "]";
	}
	
	

}
