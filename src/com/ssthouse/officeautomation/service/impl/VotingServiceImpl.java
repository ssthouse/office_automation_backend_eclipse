package com.ssthouse.officeautomation.service.impl;

import java.util.List;

import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.dao.IVotingDao;
import com.ssthouse.officeautomation.domain.VotingEntity;
import com.ssthouse.officeautomation.service.IVotingService;

public class VotingServiceImpl extends BaseService<IVotingDao> implements IVotingService{

	@Override
	public void saveVoting(VotingEntity votingEntity) {
		getDao().saveVotingEntity(votingEntity);
	}

	@Override
	public VotingEntity getVotingEntity(int votingId) {
		return getDao().getVotingEntity(votingId);
	}

	@Override
	public List<VotingEntity> getVotingList(String username) {
		return getDao().getVotingEntityList(username);
	}

	@Override
	public List<VotingEntity> getOwnedVotingList(String createrId) {
		return getDao().getOwnedVotingList(createrId);
	}

}
