package com.citi.pojo;

import java.util.ArrayList;
import java.util.List;

public class ClientResponse {
private long clientId;
private List<Questions> questionsResponses;
public ClientResponse() {

	this.clientId = -1;
	this.questionsResponses = new ArrayList<Questions>();
}
public ClientResponse(long clientId, List<Questions> questionsResponses) {
	super();
	clientId = clientId;
	this.questionsResponses = questionsResponses;
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
