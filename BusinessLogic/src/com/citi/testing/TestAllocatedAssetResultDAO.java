package com.citi.testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.citi.dao.AllocatedAssetResultDAO;
import com.citi.pojo.AllocatedAssetResult;

public class TestAllocatedAssetResultDAO {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStoreAllocatedAssetsPositive() {
		AllocatedAssetResultDAO allocatedAssetResultDAO=new AllocatedAssetResultDAO();
		AllocatedAssetResult result=new AllocatedAssetResult();
		int rowsAffected=allocatedAssetResultDAO.storeAllocatedAssets(result);
		assertTrue(rowsAffected!=0);
	}
	@Test
	public void testStoreAllocatedAssetsNegative() {
		fail("Not yet implemented");
	}


}
