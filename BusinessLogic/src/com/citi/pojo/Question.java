package com.citi.pojo;

public class Question {
private long questionId;
private char response;
private double responseValue;
private double questionWeightage;

public Question() {
	this.response = ' ';
	this.questionId = -1;
	this.responseValue = -1;
	this.questionWeightage = -1;
}

public char getResponse() {
	return response;
}

public void setResponse(char response) {
	this.response = response;
}

public Question(long questionId, char response, double responseValue, double questionWeightage) {
	super();
	this.questionId = questionId;
	this.response=response;
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
