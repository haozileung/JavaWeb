package com.haozileung.poker.dto;

import java.util.HashSet;
import java.util.Set;

import com.haozileung.poker.common.dto.DataTransferObject;
import com.haozileung.poker.domain.Desk;

public class RoomInfo implements DataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6092334390466849460L;

	private int roomId;

	private int roomEnterLevel;

	private Set<Desk> deskes = new HashSet<Desk>();

	private int blinds;

	private int roomType;

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

}
