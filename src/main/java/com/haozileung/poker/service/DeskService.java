package com.haozileung.poker.service;

import java.util.List;

import com.haozileung.poker.common.service.Service;
import com.haozileung.poker.dto.UserInfo;

public interface DeskService extends Service {
	public int getHoldCard(UserInfo userInfo);
	public List<Integer> getCommonCard();
}
