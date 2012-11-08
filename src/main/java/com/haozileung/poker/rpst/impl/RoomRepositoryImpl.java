package com.haozileung.poker.rpst.impl;

import org.springframework.stereotype.Repository;

import com.haozileung.poker.common.domain.AbstractDomainRepository;
import com.haozileung.poker.domain.Room;
import com.haozileung.poker.dto.RoomInfo;
import com.haozileung.poker.rpst.RoomRepository;
@Repository("roomRepository")
public class RoomRepositoryImpl extends AbstractDomainRepository<Room, RoomInfo>
		implements RoomRepository {

	@Override
	protected Class<Room> getDomainObjectClass() {
		return Room.class;
	}

}
