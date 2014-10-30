package com.haozileung.poker.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.haozileung.poker.common.domain.DomainInterface;

@Entity
@Table(name = "t_ssh_room")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Room implements DomainInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 801137592862439347L;
	@Id
	@GeneratedValue
	private int roomId;
	
	private int roomEnterLevel;
	@OneToMany(mappedBy="room")
	private Set<Desk> deskes = new HashSet<Desk>();
	
	private int blinds;
	
	private int roomType;
	
	public Set<Desk> getDeskes() {
		return deskes;
	}

	public void setDeskes(Set<Desk> deskes) {
		this.deskes = deskes;
	}

	public int getBlinds() {
		return blinds;
	}

	public void setBlinds(int blinds) {
		this.blinds = blinds;
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getRoomEnterLevel() {
		return roomEnterLevel;
	}

	public void setRoomEnterLevel(int roomEnterLevel) {
		this.roomEnterLevel = roomEnterLevel;
	}

	public Set<Desk> getTables() {
		return deskes;
	}

	public void setTables(Set<Desk> tables) {
		this.deskes = tables;
	}
}
