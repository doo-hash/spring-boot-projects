package com.springBasics.mockitoexamples.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListTest {

	@Test
	void test() {
		List ListMock = mock(List.class);
		when(ListMock.size()).thenReturn(10);
		assertEquals(10,ListMock.size());
	}
	@Test
	void test_Multiple() {
		List ListMock = mock(List.class);
		when(ListMock.size()).thenReturn(10).thenReturn(20);
		assertEquals(10,ListMock.size());
		assertEquals(20,ListMock.size());
	}

	@Test
	void test_Get() {
		List ListMock = mock(List.class);
		when(ListMock.get(0)).thenReturn("some string");
		assertEquals("some string",ListMock.get(0));
		assertEquals(null,ListMock.get(1));
	}
	
	@Test
	void test_Generic() {
		List ListMock = mock(List.class);
		when(ListMock.get(Mockito.anyInt())).thenReturn("some string");
		assertEquals("some string",ListMock.get(0));
	}
}
