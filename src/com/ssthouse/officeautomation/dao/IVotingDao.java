package com.ssthouse.officeautomation.dao;

import java.util.List;

import com.ssthouse.officeautomation.domain.VotingEntity;

public interface IVotingDao {

	/**
	 * 获取指定voting
	 * 
	 * @param votingId
	 * @return
	 */
	VotingEntity getVotingEntity(int votingId);

	/**
	 * 获取可以填写的投票
	 * 
	 * @param username
	 * @return
	 */
	List<VotingEntity> getVotingEntityList(String username);

	/**
	 * 获取自己管理的投票
	 * 
	 * @param createrId
	 * @return
	 */
	List<VotingEntity> getOwnedVotingList(String createrId);

	/**
	 * 保存投票数据
	 * 
	 * @param votingEntity
	 */
	void saveVotingEntity(VotingEntity votingEntity);

	/**
	 * 更新投票数据
	 * 
	 * @param votingEntity
	 */
	void updateVotingEntity(VotingEntity votingEntity);
}
