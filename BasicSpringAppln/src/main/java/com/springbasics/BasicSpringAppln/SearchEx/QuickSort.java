package com.springbasics.BasicSpringAppln.SearchEx;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("quick")
public class QuickSort implements SortAlgorithm{

//	public int[] quickSort(int[] numbers) {
		//quicksort logic
//		return numbers;
//	}

	
	//using interface method
	@Override
	public int[] sort(int[] numbers) {
		// TODO Auto-generated method stub
		return numbers;
	}
}
