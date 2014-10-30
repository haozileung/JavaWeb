package com.haozileung.poker.domain.support;

import com.haozileung.poker.common.service.AbstractDoToDtoConvertor;
import com.haozileung.poker.common.service.DoToDtoConvertorFactory;
import com.haozileung.poker.domain.Desk;
import com.haozileung.poker.dto.DeskInfo;


public class DeskDoToDtoConvert extends
		AbstractDoToDtoConvertor<Desk, DeskInfo> {

	private DeskDoToDtoConvert() {
	}

	private static DeskDoToDtoConvert instance;

	static {
		instance = new DeskDoToDtoConvert();
		DoToDtoConvertorFactory.register(Desk.class, instance);
	}

	@Override
	public DeskInfo doToDto(Desk obj) {
		if (obj == null){
			return null;
		}
		DeskInfo deskInfo = new DeskInfo();
		deskInfo.setActionUserId(obj.getActionUserId());
		deskInfo.setBetStatus(obj.getBetStatus());
		deskInfo.setBoard(obj.getBoard());
		deskInfo.setBorderPot(obj.getBorderPot());
		deskInfo.setDeskId(obj.getDeskId());
		deskInfo.setMainPot(obj.getMainPot());
		deskInfo.setPosition(obj.getPosition());
		deskInfo.setRoom(obj.getRoom());
		deskInfo.setUsers(obj.getUsers());
		return deskInfo;
	}

}
