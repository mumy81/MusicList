package org.devcrew.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="album")
public class Album {
	
	@Id
	@GeneratedValue
	@Column(name="album_id")
	private long albumId;
	
	
	private String name;
	
	@JsonIgnoreProperties(value="albums")
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="art_id")
	private Artist artist;
	
	@Column(name="date")
	private Date date;
	
	@OneToMany(mappedBy="album")
	private List<Track> tracks;
		
	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "Album [name=" + name + ", artist=" + artist + ", date=" + date + ", tracks=" + tracks + "]";
	}
	
	
	
	

}
