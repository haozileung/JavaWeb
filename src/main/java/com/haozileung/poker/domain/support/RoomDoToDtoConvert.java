package com.haozileung.poker.domain.support;

import com.haozileung.poker.common.service.AbstractDoToDtoConvertor;
import com.haozileung.poker.common.service.DoToDtoConvertorFactory;
import com.haozileung.poker.domain.Room;
import com.haozileung.poker.dto.RoomInfo;

public class RoomDoToDtoConvert extends
		AbstractDoToDtoConvertor<Room, RoomInfo> {

	private RoomDoToDtoConvert() {
	}

	private static RoomDoToDtoConvert instance;

	static {
		instance = new RoomDoToDtoConvert();
		DoToDtoConvertorFactory.register(Room.class, instance);
	}

	@Override
	public RoomInfo doToDto(Room obj) {
		if (obj == null) {
			return null;
		}
		RoomInfo roomInfo = new RoomInfo();
		roomInfo.setBlinds(obj.getBlinds());
		roomInfo.setDeskes(obj.getDeskes());
		roomInfo.setRoomEnterLevel(obj.getRoomEnterLevel());
		roomInfo.setRoomId(obj.getRoomId());
		roomInfo.setRoomType(obj.getRoomType());
		return roomInfo;
	}

}
