package com.citi.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.citi.connections.MyConnection;
import com.citi.pojo.ClientResponse;
import com.citi.pojo.Questions;
public class ClientDAO {
	public ClientResponse retrieveClientResponse(int clientId){
		Connection conn=MyConnection.getMyConnection();
		ClientResponse clientResponse=new ClientResponse();
		try {
		String FIND_CLIENT_RESPONSES="SELECT C.ResponseID,ResponseValue,WeightsAllocated FROM ClientResponse C INNER JOIN ResponseValueToWeightsAllocated R ON C.ResponseID=R.ResponseID WHERE C.ClientId=1;";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(FIND_CLIENT_RESPONSES);
		preparedStatement.setInt(1,clientId);
		ResultSet rs=preparedStatement.executeQuery();
		List<Questions> questions = new ArrayList<>();
		while(rs.next()) {
			int responseId;
			float responseValue,weightAllocated;
			responseId=rs.getInt("ResponseID");
			responseValue=rs.getFloat("ResponseValue");
			weightAllocated=rs.getFloat("WeightsAllocated");
			Questions question=new Questions(responseId,responseValue,weightAllocated);
			questions.add(question);
			clientResponse=new ClientResponse(clientId, questions);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientResponse;
		//clientResponse returned will be default constructor values if client
		//is not present. Check condition: clientId==-1 for client not present
	}
	
}
