
package com.codesse.wordgeek;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Copyright (C) 2022 Codesse. All rights reserved.
 * ••••••••••••••••••••••••••••••••••••••••••••••••
 */
public class SubmissionTest {

	static ValidWords validWords;
	WordGeek service;

	@BeforeClass
	public static void oneTimeSetUp() {
		validWords = new ValidWordsImpl();
	}

	@Before
	public void setUp() throws Exception {
		service = new WordGeekImpl("areallylongword", validWords);
	}

	@Test
	public void testSubmission() throws Exception {
		assertEquals(3, service.submitWord("player1", "all"));//is acceptable scoring 3
		assertEquals(4, service.submitWord("player2", "word"));//also acceptable netting 4
		assertEquals(0, service.submitWord("player3", "tale"));//unacceptable due to t
		assertEquals(0, service.submitWord("player4", "glly"));//glly not a valid submissions
		assertEquals(6, service.submitWord("player5", "woolly"));//is accepting garnering 6
		assertEquals(0, service.submitWord("player6", "adder"));//not acceptable because theirs only one d
	}

}
//Specific words can only appear once if it player submits a duplicate it will not add to leaderboard 
//individual players can enter multiple different words but should be independent 
//first submissions with the same score take precedence in the leaderboard
//When more than one player submits entry at the same time multi-threading must be applied to assure the security of the code
//more than one submission by the same player should be counted as sep entries
