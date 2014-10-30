package com.haozileung.poker.dto;

import java.util.HashSet;
import java.util.Set;

import com.haozileung.poker.common.dto.DataTransferObject;
import com.haozileung.poker.domain.Room;
import com.haozileung.poker.domain.User;

public class DeskInfo implements DataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2010572094378371203L;

	private int deskId;

	private Set<User> users = new HashSet<User>();

	private int betStatus;

	private int mainPot;

	private int borderPot;

	private int actionUserId;

	private String board;

	private int position;

	private Room room;

	public int getDeskId() {
		return deskId;
	}

	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public int getBetStatus() {
		return betStatus;
	}

	public void setBetStatus(int betStatus) {
		this.betStatus = betStatus;
	}

	public int getMainPot() {
		return mainPot;
	}

	public void setMainPot(int mainPot) {
		this.mainPot = mainPot;
	}

	public int getBorderPot() {
		return borderPot;
	}

	public void setBorderPot(int borderPot) {
		this.borderPot = borderPot;
	}

	public int getActionUserId() {
		return actionUserId;
	}

	public void setActionUserId(int actionUserId) {
		this.actionUserId = actionUserId;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
