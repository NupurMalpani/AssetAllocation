package com.citi.testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.citi.operations.Operations;
import com.citi.pojo.Asset;
import com.citi.pojo.ClientGoal;
import com.citi.pojo.ClientResponse;
import com.citi.pojo.Commodity;
import com.citi.pojo.Equity;
import com.citi.pojo.FixedIncome;
import com.citi.pojo.Question;

public class TestOperations {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateRatio() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculateRisk_Negative() {
		List<Question> questions=new ArrayList<>();
		for(int i=0;i<5;i++){
			questions.add(new Question(i, -1, 1));
		}
		List<Asset> assets=new ArrayList<>();
		Equity equity=new Equity(3, 3);
		boolean testBoolValue=false;
		FixedIncome fixedIncome=new FixedIncome(1, 1);
		Commodity commodity=new Commodity(2, 2);
		assets.add(fixedIncome);
		assets.add(equity);
		assets.add(commodity);
		int random = (int)(Math.random()*100);
		if(random%2==0) {
			testBoolValue=true;
		}
		else {
			testBoolValue=false;
		}
		List<ClientGoal> goals=new ArrayList<>();
		for(int i=0;i<5;i++){
			goals.add(new ClientGoal(i, 20000, 2018, 2020,testBoolValue));//change true to random bool
		}
		ClientResponse clientResponse=new ClientResponse(1, questions, goals);
		double ans=Operations.calculateRisk(assets, clientResponse);
		assertEquals(0,ans,0);
	}
	@Test
	public void testCalculateRisk_Positive() {
		List<Question> questions=new ArrayList<>();
		for(int i=0;i<5;i++){
			questions.add(new Question(i, 0.5, 1));
		}
		List<Asset> assets=new ArrayList<>();
		Equity equity=new Equity(3, 3);
		FixedIncome fixedIncome=new FixedIncome(1, 1);
		Commodity commodity=new Commodity(2, 2);
		boolean testBoolValue=false;
		int random = (int)(Math.random()*100);
		if(random%2==0) {
			testBoolValue=true;
		}
		else {
			testBoolValue=false;
		}
		assets.add(fixedIncome);
		assets.add(equity);
		assets.add(commodity);
		List<ClientGoal> goals=new ArrayList<>();
		for(int i=0;i<5;i++){


			goals.add(new ClientGoal(i, 20000, 2018, 2020,testBoolValue));
		}
		ClientResponse clientResponse=new ClientResponse(1, questions, goals);
		double ans=Operations.calculateRisk(assets, clientResponse);
		assertEquals(2,ans,0);
	}


}
