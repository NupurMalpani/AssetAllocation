package com.citi.pojo;

public class Question {
private long questionId;
private double responseValue;
private double questionWeightage;

public Question() {
	this.questionId = -1;
	this.responseValue = -1;
	this.questionWeightage = -1;
}

public Question(long questionId, double responseValue, double questionWeightage) {
	super();
	this.questionId = questionId;
	this.responseValue = responseValue;
	this.questionWeightage = questionWeightage;
}

public long getQuestionId() {
	return questionId;
}

public void setQuestionId(long questionId) {
	this.questionId = questionId;
}

public double getResponseValue() {
	return responseValue;
}

public void setResponseValue(double responseValue) {
	this.responseValue = responseValue;
}

public double getQuestionWeightage() {
	return questionWeightage;
}

public void setQuestionWeightage(double questionWeightage) {
	this.questionWeightage = questionWeightage;
}

}
