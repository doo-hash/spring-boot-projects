package com.springbasics.BasicSpringAppln.SearchEx;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bubble")
public class BubbleSort implements SortAlgorithm {

	//public int[] bubbleSort(int[] numbers) {
		//bubblesort logic
	//	return numbers;
	//}

	//using interface method
	@Override
	public int[] sort(int[] numbers) {
		// TODO Auto-generated method stub
		return numbers;
	}
}
