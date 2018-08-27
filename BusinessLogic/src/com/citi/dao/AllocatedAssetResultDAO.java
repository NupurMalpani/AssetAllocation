package com.citi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import com.citi.connections.MyConnection;
import com.citi.pojo.AllocatedAssetResult;
import com.citi.pojo.Tuple;

public class AllocatedAssetResultDAO {
	public int storeAllocatedAssets(AllocatedAssetResult result) {
		int rowsAffected=0; 
		Connection conn = MyConnection.getMyConnection();
		String INSERT_ALLOCATED_ASSETS="INSERT INTO AllocatedAssetResult VALUES(?,?,?)";
		try {
			int whileCount=0;
			PreparedStatement preparedStatement=conn.prepareStatement(INSERT_ALLOCATED_ASSETS);
			preparedStatement.setLong(1,result.getClientId());
			List<Tuple<Integer,Double>> allocatedAssetResult=result.getAllocatedAssetResult();
			Iterator<Tuple<Integer,Double>> iterator=allocatedAssetResult.iterator();
			while(iterator.hasNext()) {
				Tuple<Integer,Double> tuple=iterator.next();
				int assetId=tuple.getX();
				double allocatedRatio=tuple.getY();
				preparedStatement.setInt(2,assetId);
				preparedStatement.setDouble(3,allocatedRatio);
				rowsAffected=rowsAffected+preparedStatement.executeUpdate();
				whileCount++;
			}
			if(whileCount!=rowsAffected) {
				System.out.println("Error in insertion of allocated results!");
				return -1;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}
}
