package com.ssthouse.officeautomation.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ssthouse.officeautomation.domain.QuestionEntity;

public class TestQuestionEntity {
	
	QuestionEntity questionEntityOne;
	QuestionEntity questionEntityTwo;
	QuestionEntity questionEntityThree;
	QuestionEntity questionEntityFour;

	@Before
	public void setUp() throws Exception {
		questionEntityOne = new QuestionEntity();
		questionEntityOne.setType("textArea");
		questionEntityOne.setTitle("title");
		
		questionEntityTwo = new QuestionEntity();
		questionEntityTwo.setType("textArea");
		
		questionEntityThree = new QuestionEntity();
		questionEntityThree.setType("radio");
		questionEntityThree.setTitle("title");
		questionEntityThree.setSelections("hahaha");
		
		questionEntityFour = new QuestionEntity();
		questionEntityFour.setType("radio");
		questionEntityFour.setTitle("title");
	}

	@Test
	public void testIsValid() {
		assertEquals(questionEntityOne.isValid(), true);
		
		assertEquals(questionEntityTwo.isValid(), false);
		
		assertEquals(questionEntityThree.isValid(), true);
		
		assertEquals(questionEntityFour.isValid(), false);
	}

}
