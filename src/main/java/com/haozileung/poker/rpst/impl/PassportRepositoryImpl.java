package com.haozileung.poker.rpst.impl;

import org.springframework.stereotype.Repository;

import com.haozileung.poker.common.domain.AbstractDomainRepository;
import com.haozileung.poker.domain.Passport;
import com.haozileung.poker.dto.PassportInfo;
import com.haozileung.poker.rpst.PassportRepository;

@Repository("passportRepository")
public class PassportRepositoryImpl extends AbstractDomainRepository<Passport,PassportInfo> implements PassportRepository {
	@Override
	protected Class<Passport> getDomainObjectClass() {
		return Passport.class;
	}
}
