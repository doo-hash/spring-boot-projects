package com.springBasics.mockitoexamples.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class SomeBusinessMockTest {

	@Test
	void testFindTheGreatest() {
		DataService dataserviceMock = mock(DataService.class);
		when(dataserviceMock.retrieveAllData()).thenReturn(new int[] {54,24,84,76});
		
		BusinessImpl businessImpl = new BusinessImpl(dataserviceMock);
		int result = businessImpl.findTheGreatest();
		assertEquals(84,result);
	}
	
	@Test
	void testFindTheGreatest_fornone() {
		DataService dataserviceMock = mock(DataService.class);
		when(dataserviceMock.retrieveAllData()).thenReturn(new int[] {});
		
		BusinessImpl businessImpl = new BusinessImpl(dataserviceMock);
		int result = businessImpl.findTheGreatest();
		assertEquals(Integer.MIN_VALUE,result);
	}
	
	@Test
	void testFindTheGreatest_forone() {
		DataService dataserviceMock = mock(DataService.class);
		when(dataserviceMock.retrieveAllData()).thenReturn(new int[] {54});
		
		BusinessImpl businessImpl = new BusinessImpl(dataserviceMock);
		int result = businessImpl.findTheGreatest();
		assertEquals(54,result);
	}

}

