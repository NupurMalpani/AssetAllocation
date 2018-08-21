package com.citi.pojo;

public class AllocatedAssetResult {
private long clientId;
private double allocatedRatioEquity;
private double allocatedRatioFixedIncome;
private double allocatedRatioCommodity;
private int goalsMet;

public AllocatedAssetResult() {
	// TODO Auto-generated constructor stub
	this.clientId = -1;
	this.allocatedRatioEquity = -1;
	this.allocatedRatioFixedIncome = -1;
	this.allocatedRatioCommodity = -1;
	this.goalsMet = -2;
}

public AllocatedAssetResult(long clientId, double allocatedRatioEquity, double allocatedRatioFixedIncome,
		double allocatedRatioCommodity, int goalsMet) {
	super();
	this.clientId = clientId;
	this.allocatedRatioEquity = allocatedRatioEquity;
	this.allocatedRatioFixedIncome = allocatedRatioFixedIncome;
	this.allocatedRatioCommodity = allocatedRatioCommodity;
	this.goalsMet = goalsMet;
}

public long getClientId() {
	return clientId;
}

public void setClientId(long clientId) {
	this.clientId = clientId;
}

public double getAllocatedRatioEquity() {
	return allocatedRatioEquity;
}

public void setAllocatedRatioEquity(double allocatedRatioEquity) {
	this.allocatedRatioEquity = allocatedRatioEquity;
}

public double getAllocatedRatioFixedIncome() {
	return allocatedRatioFixedIncome;
}

public void setAllocatedRatioFixedIncome(double allocatedRatioFixedIncome) {
	this.allocatedRatioFixedIncome = allocatedRatioFixedIncome;
}

public double getAllocatedRatioCommodity() {
	return allocatedRatioCommodity;
}

public void setAllocatedRatioCommodity(double allocatedRatioCommodity) {
	this.allocatedRatioCommodity = allocatedRatioCommodity;
}

public int getGoalsMet() {
	return goalsMet;
}

public void setGoalsMet(int goalsMet) {
	this.goalsMet = goalsMet;
}

}
