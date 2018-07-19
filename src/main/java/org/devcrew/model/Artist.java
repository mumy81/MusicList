package org.devcrew.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="artist")
public class Artist {
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="artist")
	private List<Album> albums;
	
	@OneToMany(mappedBy="artist")
	private List<Track> tracks;

	
	
	
	public long getArtistId() {
		return id;
	}

	public void setArtistId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
		
	@JsonIgnore
	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", albums=" + albums + ", tracks=" + tracks + "]";
	}

	
	
	

}
