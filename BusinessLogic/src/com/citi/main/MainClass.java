package com.citi.main;

import java.util.List;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.util.MathArrays.Function;

import com.citi.dao.AssetDAO;
import com.citi.dao.ClientDAO;
import com.citi.operations.Operations;
import com.citi.pojo.Asset;
import com.citi.pojo.ClientGoal;
import com.citi.pojo.ClientResponse;
import com.citi.pojo.Tuple;

public class MainClass {
	public static void DetectTriggerResponse(long clientId){
		AssetDAO assetDAO=new AssetDAO();
		List<Asset> assets=assetDAO.retrieveAssetDetails();
		ClientDAO clientDAO=new ClientDAO();
		ClientResponse clientResponse=clientDAO.retrieveClientResponsesAndGoals(clientId);
		double risk=Operations.calculateRisk(assets, clientResponse);
		double reward=Operations.calculateReward(assets, risk, 1);
		double PresentValue=Operations.calculateA(clientResponse, reward);
		List<Tuple<Long, Boolean>> ans=Operations.goalsMet(PresentValue, reward, clientResponse.getGoals());
		Tuple<Long, List<Tuple<Long, Boolean>>> lists=new Tuple<Long, List<Tuple<Long,Boolean>>>(clientResponse.getClientId(),ans );
		
		
	}

}
