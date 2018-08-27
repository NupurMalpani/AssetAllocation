package com.citi.main;

import java.util.List;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.util.MathArrays.Function;

import com.citi.dao.AssetDAO;
import com.citi.dao.ClientDAO;
import com.citi.operations.Operations;
import com.citi.pojo.Asset;
import com.citi.pojo.ClientResponse;

public class MainClass {
	public static void DetectTriggerResponse(long clientId){
		AssetDAO assetDAO=new AssetDAO();
		List<Asset> assets=assetDAO.retrieveAssetDetails();
		ClientDAO clientDAO=new ClientDAO();
		ClientResponse clientResponse=clientDAO.retrieveClientResponse(clientId);
		double risk=Operations.calculateRisk(assets, clientResponse);
		double reward=Operations.calculateReward(assets, risk, 1);
		double PresentValue=Operations.calculateA(clientResponse, reward);
	}

}
