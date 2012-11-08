package com.haozileung.poker.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.haozileung.poker.common.domain.DomainInterface;
import com.haozileung.poker.dto.UserLogInfo;

@Entity
@Table(name = "t_ssh_userlog")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class UserLog implements DomainInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7869311965591348464L;

	@Id
	@GeneratedValue
	private int userLogId;

	private int operation;

	private int gold;

	private Timestamp opTime;
	@ManyToOne
	@JoinColumn(name = "usertId")
	private User user;

	public UserLog() {
	}

	public UserLog(UserLogInfo userLogInfo) {
		update(userLogInfo);
	}

	private void update(UserLogInfo userLogInfo) {
		this.gold = userLogInfo.getGold();
		this.operation = userLogInfo.getOperation();
		this.opTime = userLogInfo.getOpTime();
		this.userLogId = userLogInfo.getUserLogId();
		this.user = userLogInfo.getUser();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUserLogId() {
		return userLogId;
	}

	public void setUserLogId(int userLogId) {
		this.userLogId = userLogId;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public Timestamp getOpTime() {
		return opTime;
	}

	public void setOpTime(Timestamp opTime) {
		this.opTime = opTime;
	}

}
