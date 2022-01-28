package com.springBasics.mockitoexamples.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessStubTest {

	@Test
	void testFindTheGreatest() {
		BusinessImpl businessImpl = new BusinessImpl(new DataServiceStub());
		int result = businessImpl.findTheGreatest();
		assertEquals(95,result);
	}

}

class DataServiceStub implements DataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {54,87,26,95,73,46};
	}
	
}