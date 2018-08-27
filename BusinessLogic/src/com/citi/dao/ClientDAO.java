package com.citi.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.citi.connections.MyConnection;
import com.citi.pojo.ClientGoal;
import com.citi.pojo.ClientResponse;
import com.citi.pojo.Questions;
public class ClientDAO {
	public ClientResponse retrieveClientResponse(int clientId){
		Connection conn=MyConnection.getMyConnection();
		ClientResponse clientResponse=new ClientResponse();
		List<Questions> questions=fetchQuestions(conn, clientId);
		List<ClientGoal> goals=fetchGoals(conn,clientId);
		clientResponse=new ClientResponse(clientId, questions,goals );
		
		return clientResponse;
		//clientResponse returned will be default constructor values if client
		//is not present. Check condition: clientId==-1 for client not present
	}
	
	public List<ClientGoal> fetchGoals(Connection conn,int clientId) {
		String FIND_CLIENT_GOALS="SELECT GoalId,GoalAmount,CurrentDate,GoalYear,GoalsMet FROM FinancialGoals WHERE ClientId=?";
		PreparedStatement preparedStatement;
		List<ClientGoal> goals = new ArrayList<>();
		try {
			preparedStatement = conn.prepareStatement(FIND_CLIENT_GOALS);
			preparedStatement.setInt(1,clientId);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) { 
				int goalId,goalYear,currentYear; 
				long goalAmount;
				boolean goalsMet;
				Date currentDate;
				goalId=rs.getInt("GoalId");
				goalAmount=rs.getLong("GoalAmount");
				currentDate=rs.getDate("CurrentDate");
				currentYear=currentDate.getYear();
				goalYear=rs.getInt("GoalYear");
				goalsMet=rs.getBoolean("GoalsMet");	
				ClientGoal goal=new ClientGoal(goalId,goalAmount,currentYear,goalYear,goalsMet);
				goals.add(goal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goals;
	}
	public List<Questions> fetchQuestions(Connection conn,int clientId) {
		String FIND_CLIENT_RESPONSES="SELECT C.ResponseID,ResponseValue,WeightsAllocated FROM ClientResponse C INNER JOIN ResponseValueToWeightsAllocated R ON C.ResponseID=R.ResponseID WHERE C.ClientId=1;";
		PreparedStatement preparedStatement;
		List<Questions> questions = new ArrayList<>();
		try {
			preparedStatement = conn.prepareStatement(FIND_CLIENT_RESPONSES);
			preparedStatement.setInt(1,clientId);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) { 
				int responseId; 
				float responseValue,weightAllocated;
				responseId=rs.getInt("ResponseID");
				responseValue=rs.getFloat("ResponseValue");
				weightAllocated=rs.getFloat("WeightsAllocated");
				Questions question=new Questions(responseId,responseValue,weightAllocated);
				questions.add(question);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questions;
	}
}
