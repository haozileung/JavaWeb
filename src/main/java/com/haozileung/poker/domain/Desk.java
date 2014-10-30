package com.haozileung.poker.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.haozileung.poker.common.domain.DomainInterface;
import com.haozileung.poker.dto.DeskInfo;

@Entity
@Table(name = "t_ssh_desk")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Desk implements DomainInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3531169724762333814L;
	@Id
	@GeneratedValue
	private int deskId;
	@OneToMany(mappedBy="desk")
	private Set<User> users = new HashSet<User>();
	
	private int betStatus;
	
	private int mainPot;
	
	private int borderPot;
	
	private int actionUserId;
	
	private String board;
	
	private int position;
	@ManyToOne
	@JoinColumn(name="roomId")
	private Room room;
	
	public Desk(){}
	
	public Desk(DeskInfo deskInfo){
		this.actionUserId = deskInfo.getActionUserId();
		this.betStatus = deskInfo.getBetStatus();
		this.board = deskInfo.getBoard();
		this.borderPot = deskInfo.getBorderPot();
		this.deskId = deskInfo.getDeskId();
		this.mainPot = deskInfo.getMainPot();
		this.position = deskInfo.getPosition();
		this.room = deskInfo.getRoom();
		this.users = deskInfo.getUsers();
	}
	
	public int getBetStatus() {
		return betStatus;
	}

	public void setBetStatus(int betStatus) {
		this.betStatus = betStatus;
	}


	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
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

	public int getActionUser() {
		return actionUserId;
	}

	public void setActionUser(int actionUser) {
		this.actionUserId = actionUser;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

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

}
