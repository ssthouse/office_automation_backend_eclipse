package com.ssthouse.officeautomation.service.impl;

import java.util.List;

import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.dao.IMeetingRoomDao;
import com.ssthouse.officeautomation.domain.MeetingRoomEntity;
import com.ssthouse.officeautomation.service.IMeetingRoomService;

public class MeetingRoomServiceImpl extends BaseService<IMeetingRoomDao> implements IMeetingRoomService {

	@Override
	public void saveMeetingRoom(MeetingRoomEntity entity) {
		// TODO check is entiy is valid
		getDao().saveMeetingRoom(entity);
	}

	@Override
	public void updateMeetingRoom(MeetingRoomEntity entity) {
		// TODO check valid
		getDao().updateMeetingRoom(entity);
	}

	@Override
	public MeetingRoomEntity getMeetingRoomEntity(int id) {
		return getDao().getMeetingRoom(id);
	}

	@Override
	public List<MeetingRoomEntity> getMeetingRoomList() {
		return getDao().getMeetingRoomList();
	}

}
