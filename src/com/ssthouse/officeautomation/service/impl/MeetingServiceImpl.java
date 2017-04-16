package com.ssthouse.officeautomation.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.dao.IMeetingDao;
import com.ssthouse.officeautomation.domain.MeetingEntity;
import com.ssthouse.officeautomation.service.IMeetingService;
import com.ssthouse.officeautomation.util.Log;
import com.ssthouse.officeautomation.util.StringUtil;

public class MeetingServiceImpl extends BaseService<IMeetingDao> implements IMeetingService {

	@Override
	public void saveMeeting(MeetingEntity entity) {
		if (entity == null) {
			Log.error("invalid meeting data to save");
			return;
		}
		getDao().saveMeeting(entity);
	}

	@Override
	public void updateMeeting(MeetingEntity entity) {
		if (entity == null || entity.getId() == 0) {
			Log.error("invalid meeting data to update");
			return;
		}
		getDao().updateMeeting(entity);
	}

	@Override
	public List<MeetingEntity> getOpenMeetingList(String username) {
		if (StringUtil.isEmpty(username)) {
			Log.error("invalid username to get open meeting list");
			return new ArrayList<>();
		}
		return getDao().getOpenMeetingList(username);
	}

	@Override
	public List<MeetingEntity> getOwnedMeetingList(String username) {
		if (StringUtil.isEmpty(username)) {
			Log.error("invalid username to get owned meeting list");
			return new ArrayList<>();
		}
		return getDao().getOwnedMeetingList(username);
	}

}
