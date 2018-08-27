package com.citi.operations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
import org.apache.commons.math3.util.MathArrays.Function;

import com.citi.pojo.AllocatedAssetResult;
import com.citi.pojo.Asset;
import com.citi.pojo.ClientResponse;
import com.citi.pojo.Questions;
import com.citi.pojo.Tuple;

import edu.rit.numeric.NonNegativeLeastSquares;

public class Operations {
		public   static PolynomialFunction fit_polynomial_curve(ArrayList<Asset> graphAssetPoints,int degree) {
			final WeightedObservedPoints obs = new WeightedObservedPoints();
			//x-axis is risk, y-axis is reward.
			//points in form of (x,y)
			//degree = 1 straight line etc...
			for(Asset asset:graphAssetPoints) {
				obs.add(asset.getRisk(),asset.getReward());
			}
			final PolynomialCurveFitter fitter = PolynomialCurveFitter.create(1);
			final double[] coeff = fitter.fit(obs.toList());
			return new PolynomialFunction(coeff);
		}
		public static double calculateReward(Function function,double risk) {
			//this is already scaled risk
			double arr[] = {risk};
			return function.evaluate(arr);
		}
		//Ax = b
		// number of rows = equation, number of columns = variables
		private static double[][] createMatrixA(List<Asset> assets) {
			ArrayList<ArrayList<Double>> a = new ArrayList<ArrayList<Double>>();
			ArrayList<Double> risk= new ArrayList<Double>();
			ArrayList<Double> reward = new ArrayList<Double>();
			ArrayList<Integer> assetId = new ArrayList<Integer>();
			ArrayList<Double> ratioList = new ArrayList<Double>();
			assets.forEach(asset -> {risk.add(asset.getRisk()); reward.add(asset.getReward()); ratioList.add(1.0);});
			Collections.addAll(a,risk,reward,ratioList);
			return (double[][])a.toArray();
		}
		private static double[] createMatrixB(double calculatedRisk,double calculatedReward,double ratio) {
			double[] b = new double[3];
			b[0] = calculatedRisk;
			b[1] = calculatedReward;
			b[2] =ratio;
			return b;
		}
		public static List<Tuple<Integer, Double>> calculateRatio(List<Asset> assets,double calculatedRisk,double calculatedReward) {
			int eqns = 3; 
			int variables = 3;
			double ratio =1.0;
			double [][]a = createMatrixA(assets);
			double [] b = createMatrixB(calculatedRisk, calculatedReward, ratio);
			NonNegativeLeastSquares leastSquares = solveEquation(eqns, variables, a, b);
			double[]x  = leastSquares.x;
			int [] index = leastSquares.index;
			List<Tuple<Integer,Double>> allocation = new ArrayList<Tuple<Integer,Double>>();
			for(int i = 0; i < x.length; i++) {
				Tuple <Integer,Double> assetRatioTuple = new Tuple<Integer, Double>(assets.get(index[i]).getAssetId(),x[i]);
				allocation.add(assetRatioTuple);
			}
			return allocation;
		}
		private static NonNegativeLeastSquares solveEquation(int eqns,int variables,double[][] a,double [] b) {
			//eqns = number of eqns
			//vars =number of variables
			NonNegativeLeastSquares leastSquares = new NonNegativeLeastSquares(eqns,variables);
			for(int eqn = 0; eqn < eqns; eqn++){
				leastSquares.a[eqn] = Arrays.copyOfRange(a[eqn], 0, variables);

			}
			leastSquares.nsetp = variables;
			System.arraycopy(IntStream.range(0,variables).toArray(),0,leastSquares.index,0,variables);
			leastSquares.solve();
			return leastSquares;
		}
		public static double calculateRisk(List<Asset> assets,ClientResponse clientResponse){
			double ans=0;
			List<Questions> questions=clientResponse.getQuestionsResponses();
			double sum=0;
			for(Questions question:questions){
				if(question.getResponseValue()>0){
				sum=sum+(question.getResponseValue())*(question.getQuestionWeightage());
				}
			}
			double avg=sum/questions.size();
			if(avg==0)
				return 0;
			ans=riskScaler(avg,assets);
			return ans;
		}
		private static double riskScaler(double avg,List<Asset> asssets){
			double rMin=Double.MAX_VALUE,rMax=Double.MIN_VALUE;
		    for(Asset asset:asssets){
		    	rMin=Math.min(rMin, asset.getRisk());
		    	rMax=Math.max(rMax, asset.getRisk());
		    }
		    return rMin+(rMax-rMin)*avg;
		}
		
}
