package com.ssthouse.officeautomation.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IVotingDao;
import com.ssthouse.officeautomation.domain.VoteOptionEntity;
import com.ssthouse.officeautomation.domain.VotingEntity;
import com.ssthouse.officeautomation.util.Log;

public class VotingDaoImpl extends BaseDao implements IVotingDao {

	@Override
	public VotingEntity getVotingEntity(int votingId) {
		Session session = openSession();
		session.beginTransaction();
		VotingEntity votingEntity = (VotingEntity) session.createCriteria(VotingEntity.class)
				.add(Restrictions.eq(VotingEntity.PROPERTY_VOTING_ID, votingId)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return votingEntity;
	}

	@Override
	public List<VotingEntity> getVotingEntityList(String username) {
		Session session = openSession();
		session.beginTransaction();
		List<VotingEntity> result = session.createCriteria(VotingEntity.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}

	@Override
	public List<VotingEntity> getOwnedVotingList(String createrId) {
		Session session = openSession();
		session.beginTransaction();
		List<VotingEntity> result = session.createCriteria(VotingEntity.class)
				.add(Restrictions.eq(VotingEntity.PROPERTY_CREATER_ID, createrId))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}

	@Override
	public void saveVotingEntity(VotingEntity votingEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.save(votingEntity);
		// set the generated voting_id to vote option beans
		for (VoteOptionEntity voteOption : votingEntity.getVoteOptions()) {
			voteOption.setVotingId(votingEntity.getVotingId());
		}
		session.update(votingEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateVotingEntity(VotingEntity votingEntity) {
		Session session = openSession();
		session.beginTransaction();
		// delete the options first
		List<VoteOptionEntity> oldOptions = session.createCriteria(VoteOptionEntity.class)
				.add(Restrictions.eq(VoteOptionEntity.PROPERTY_VOTING_ID, votingEntity.getVotingId())).list();
		for (VoteOptionEntity optionEntity : oldOptions) {
			session.delete(optionEntity);
		}
		session.getTransaction().commit();
		// add new options
		session = openSession();
		session.beginTransaction();
		for (VoteOptionEntity voteOptionEntity : votingEntity.getVoteOptions()) {
			voteOptionEntity.setVotingId(votingEntity.getVotingId());
			session.save(voteOptionEntity);
		}
		session.update(votingEntity);
		session.getTransaction().commit();
		session.close();
	}

}
