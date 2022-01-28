package com.springBasics.mockitoexamples.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class SomeBusinessMockAnnotationsTest {

	@Mock
	DataService dataServiceMock;
	
	@InjectMocks
	BusinessImpl businessImpl;
	
	@Test
	void testFindTheGreatest() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {21,54,14});		
		int result = businessImpl.findTheGreatest();
		System.out.println(result);
		assertEquals(84,result);
	}
	
	@Test
	void testFindTheGreatest_fornone() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		int result = businessImpl.findTheGreatest();
		assertEquals(Integer.MIN_VALUE,result);
	}
	
	@Test
	void testFindTheGreatest_forone() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {54});
		int result = businessImpl.findTheGreatest();
		assertEquals(54,result);
	}

}

