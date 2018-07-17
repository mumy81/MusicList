package org.devcrew.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="track")
public class Track {
	@Id
	@GeneratedValue
	@Column(name="track_id")
	private long trackId;
	@Column(name="name")
	private String name;
	@ManyToOne
	@JoinColumn
	private Artist artist;
	@Column(name="genre")
	private String genre;
	@Column(name="duration")
	private int duration;
	@ManyToOne
	@JoinColumn(name="album_id")
	private Album album;
	@ManyToMany
	@JoinTable(
	        name = "Playlist_Track", 
	        joinColumns = { @JoinColumn(name = "playlist_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "track_id") }
	    )
	private List<Playlist> playlists;
	

	
	public long getTrackId() {
		return trackId;
	}
	public void setTrackId(long trackId) {
		this.trackId = trackId;
	}
	public List<Playlist> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	@Override
	public String toString() {
		return "Track [name=" + name + ", artist=" + artist + ", genre=" + genre + ", duration=" + duration + ", album="
				+ album + "]";
	}
	
	
	
}
