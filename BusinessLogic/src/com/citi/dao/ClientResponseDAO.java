package com.citi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.citi.connections.MyConnection;
import com.citi.pojo.Questions;

public class ClientResponseDAO {
	public List<Questions> fetchResponses(long clientId) {
		Connection conn=MyConnection.getMyConnection();
		String FIND_CLIENT_RESPONSES="SELECT C.ResponseID,ResponseValue,WeightsAllocated FROM ClientResponse C INNER JOIN ResponseValueToWeightsAllocated R ON C.ResponseID=R.ResponseID WHERE C.ClientId=1;";
		PreparedStatement preparedStatement;
		List<Questions> questions = new ArrayList<>();
		try {
			preparedStatement = conn.prepareStatement(FIND_CLIENT_RESPONSES);
			preparedStatement.setLong(1,clientId);
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
