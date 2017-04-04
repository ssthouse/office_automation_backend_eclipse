package com.ssthouse.officeautomation.service;

import java.util.List;

import com.ssthouse.officeautomation.domain.VoteOptionEntity;
import com.ssthouse.officeautomation.domain.VotingEntity;

public interface IVotingService {

	/**
	 * 保存Voting
	 * 
	 * @param votingEntity
	 */
	void saveVoting(VotingEntity votingEntity);

	/**
	 * 获取指定viting
	 * 
	 * @param votingId
	 * @return
	 */
	VotingEntity getVotingEntity(int votingId);

	/**
	 * 获取需要填写的voting
	 * 
	 * @param username
	 * @return
	 */
	List<VotingEntity> getVotingList(String username);

	/**
	 * 获取自己管理的Voting
	 * 
	 * @param createrId
	 * @return
	 */
	List<VotingEntity> getOwnedVotingList(String createrId);
	
	/**
	 * 保存新提交的投票
	 * @param voteOptionList
	 */
	void saveVoteOptionList(List<VoteOptionEntity> voteOptionList);
}
