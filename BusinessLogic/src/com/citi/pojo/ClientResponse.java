package com.citi.pojo;

import java.util.ArrayList;
import java.util.List;

public class ClientResponse {
private long clientId;
private List<Questions> questionsResponses;
private List<ClientGoal> goals;
public ClientResponse() {

	this.clientId = -1;
	this.questionsResponses = new ArrayList<Questions>();
	this.goals = new ArrayList<ClientGoal>();
}

public ClientResponse(long clientId, List<Questions> questionsResponses, List<ClientGoal> goals) {
	super();
	this.clientId = clientId;
	this.questionsResponses = questionsResponses;
	this.goals = goals;
}

public List<ClientGoal> getGoals() {
	return goals;
}

public void setGoals(List<ClientGoal> goals) {
	this.goals = goals;
}

public long getClientId() {
	return clientId;
}
public void setClientId(long clientId) {
	this.clientId = clientId;
}
public List<Questions> getQuestionsResponses() {
	return questionsResponses;
}
public void setQuestionsResponses(List<Questions> questionsResponses) {
	this.questionsResponses = questionsResponses;
}


}
