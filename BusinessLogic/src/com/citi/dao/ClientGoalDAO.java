package com.citi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.citi.connections.MyConnection;
import com.citi.pojo.ClientGoal;

public class ClientGoalDAO {
	public List<ClientGoal> fetchGoals(long clientId) {
		Connection conn=MyConnection.getMyConnection();
		String FIND_CLIENT_GOALS="SELECT GoalId,GoalAmount,CurrentYear,GoalYear,GoalsMet FROM FinancialGoals WHERE ClientId=?";
		PreparedStatement preparedStatement;
		List<ClientGoal> goals = new ArrayList<>();
		try {
			preparedStatement = conn.prepareStatement(FIND_CLIENT_GOALS);
			preparedStatement.setLong(1,clientId);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) { 
				int goalId,goalYear,currentYear; 
				long goalAmount;
				boolean goalsMet;
				goalId=rs.getInt("GoalId");
				goalAmount=rs.getLong("GoalAmount");
				currentYear=rs.getInt("CurrentYear");
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
}