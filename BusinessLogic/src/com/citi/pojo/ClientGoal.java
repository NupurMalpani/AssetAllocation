package com.citi.pojo;

public class ClientGoal {
private long goalId;
private long goalAmount;
private int currentYear;
private int targetYear;
public ClientGoal() {
	super();
	this.goalId = -1;
	this.goalAmount = -1;
	this.currentYear = -1;
	this.targetYear = -1;
}
public ClientGoal(long goalId, long goalAmount, int currentYear, int targetYear) {
	super();
	this.goalId = goalId;
	this.goalAmount = goalAmount;
	this.currentYear = currentYear;
	this.targetYear = targetYear;
}
public long getGoalId() {
	return goalId;
}
public void setGoalId(long goalId) {
	this.goalId = goalId;
}
public long getGoalAmount() {
	return goalAmount;
}
public void setGoalAmount(long goalAmount) {
	this.goalAmount = goalAmount;
}
public int getCurrentYear() {
	return currentYear;
}
public void setCurrentYear(int currentYear) {
	this.currentYear = currentYear;
}
public int getTargetYear() {
	return targetYear;
}
public void setTargetYear(int targetYear) {
	this.targetYear = targetYear;
}

}
