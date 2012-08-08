package com.haozileung.jbloger.rpst;

import java.io.Serializable;

import com.haozileung.jbloger.domain.Passport;

public interface PassportRepository {
	
	public Serializable savePassport(Passport passport);
	
	public void deletePassport(int id);
	
	public void updatePassport(Passport passport);
	
	public Passport getPassportById(int id);
}
