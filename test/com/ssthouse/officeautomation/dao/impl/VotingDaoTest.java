package com.ssthouse.officeautomation.dao.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.domain.VoteOptionEntity;
import com.ssthouse.officeautomation.domain.VotingEntity;
import com.ssthouse.officeautomation.util.Log;

public class VotingDaoTest {

	VotingDaoImpl votingDaoImpl;
	
	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		votingDaoImpl = context.getBean(VotingDaoImpl.class);
	}

	@Test
	public void testGetVotingEntityList() {
		List<VotingEntity> votingEntities = votingDaoImpl.getVotingEntityList("ssthouse");
		Log.error(new Gson().toJson(votingEntities));
	}

	@Test
	public void testGetOwnedVotingList() {
		List<VotingEntity> votingEntities = votingDaoImpl.getVotingEntityList("ssthouse");
		Log.error(new Gson().toJson(votingEntities));
	}

	@Test
	public void testSaveVotingEntity() {
		VotingEntity votingEntity = new VotingEntity();
		votingEntity.setCreaterId("ssthouse");
		votingEntity.setDeadline("this is the deadline");
		votingEntity.setDescription("this is the rescription");
		votingEntity.setTitle("this is the title");
		VoteOptionEntity optionEntity = new VoteOptionEntity();
		optionEntity.setSum(0);
		optionEntity.setId(1);
		optionEntity.setTitle("this is option one title");
		votingEntity.getVoteOptions().add(optionEntity);
		votingDaoImpl.saveVotingEntity(votingEntity);
	}

	@Test
	public void testUpdateVotingEntity() {
		List<VotingEntity> votingEntities = votingDaoImpl.getVotingEntityList("ssthouse");
		Log.error(new Gson().toJson(votingEntities));
		// 尝试修改第一个数据, 看是不是真的改了
		VoteOptionEntity optionEntity = new VoteOptionEntity();
		optionEntity.setTitle("这是我尝试update新加的Title");
		votingEntities.get(0).getVoteOptions().add(optionEntity);
		votingDaoImpl.updateVotingEntity(votingEntities.get(0));
		// 再看看数据
		votingEntities = votingDaoImpl.getVotingEntityList("ssthouse");;
		Log.error(new Gson().toJson(votingEntities));
	}

}
