package com.haozileung.poker.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.haozileung.poker.common.domain.DomainInterface;
import com.haozileung.poker.dto.UserInfo;

@Entity
@Table(name="t_ssh_user")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class User implements DomainInterface{

	private static final long serialVersionUID = 8254592767704044523L;
	
	@Id
	@GeneratedValue
	private int userId;
	
	@OneToOne(cascade=CascadeType.ALL)  
    @JoinColumn(name="passportId")
	private Passport passport;
	
	@OneToMany(mappedBy="user")
	private Set<UserLog> userLog = new HashSet<UserLog>();
	@ManyToOne
	@JoinColumn(name="deskId")
	private Desk desk;
	
	private String name;
	private int assest;
	private int betMoney;
	private String holdCard;
	
	public Desk getDesk() {
		return desk;
	}

	public void setDesk(Desk desk) {
		this.desk = desk;
	}

	public int getBetMoney() {
		return betMoney;
	}

	public void setBetMoney(int betMoney) {
		this.betMoney = betMoney;
	}

	public String getHoldCard() {
		return holdCard;
	}

	public void setHoldCard(String holdCard) {
		this.holdCard = holdCard;
	}

	public Set<UserLog> getUserLog() {
		return userLog;
	}

	public void setUserLog(Set<UserLog> userLog) {
		this.userLog = userLog;
	}

	public User(){
		
	}
	
	public User(UserInfo userInfo){
		update(userInfo);
	}
	
	private void update(UserInfo userInfo){
		this.assest = userInfo.getAssest();
		this.userId = userInfo.getUserId();
		this.name = userInfo.getName();
		this.betMoney = userInfo.getBetMoney();
		this.desk = userInfo.getDesk();
		this.holdCard = userInfo.getHoldCard();
		this.passport = userInfo.getPassport();
		this.userLog = userInfo.getUserLog();
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAssest() {
		return assest;
	}
	public void setAssest(int assest) {
		this.assest = assest;
	}
	@Override
	public String toString() {
		return "name : "+name + " , assest : "+assest;
	}
	
}
