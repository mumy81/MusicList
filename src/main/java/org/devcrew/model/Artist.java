package org.devcrew.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="artist")
public class Artist {
	@Id
	@GeneratedValue
	@Column(name="artist_id")
	private long artistId;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="artist")
	private List<Album> albums;
	
	@OneToMany(mappedBy="artist")
	private List<Track> tracks;

	
	
	
	public long getArtistId() {
		return artistId;
	}

	public void setArtistId(long artistId) {
		this.artistId = artistId;
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
	
	

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "Artist [name=" + name + ", albums=" + albums + "]";
	}
	
	

}
