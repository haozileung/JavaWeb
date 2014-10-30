package com.haozileung.poker.rpst.impl;

import org.springframework.stereotype.Repository;

import com.haozileung.poker.common.domain.AbstractDomainRepository;
import com.haozileung.poker.domain.Desk;
import com.haozileung.poker.dto.DeskInfo;
import com.haozileung.poker.rpst.DeskRepository;

@Repository("deskRepository")
public class DeskRepositoryImpl extends AbstractDomainRepository<Desk, DeskInfo>
		implements DeskRepository {

	@Override
	protected Class<Desk> getDomainObjectClass() {
		return Desk.class;
	}
}
