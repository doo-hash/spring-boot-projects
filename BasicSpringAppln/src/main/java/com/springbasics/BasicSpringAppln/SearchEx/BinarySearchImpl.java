package com.springbasics.BasicSpringAppln.SearchEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchImpl {

//	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
//		super();
//		this.sortAlgorithm = sortAlgorithm;
//	}
	

//	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//		this.sortAlgorithm = sortAlgorithm;
//	}

	@Autowired
	@Qualifier("quick")
//	private SortAlgorithm bubbleSort;
	private SortAlgorithm sortAlgorithm;
	public int binarysearch(int[] numbers,int numbertosearchfor) {

				
		//bubblesort
//		BubbleSort bubbleSort = new BubbleSort();
//		int[] sortedNumbers1 = bubbleSort.bubbleSort(numbers);
		
		//to also use quick sort we have to change the aboe 2 lines		
		
		//QuickSort
//		QuickSort quickSort = new QuickSort();
//		int[] sortedNumbers2 = quickSort.quickSort(numbers);		
		


		//to do it dynamically, use interface
		int[] sortednumbers = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		
		//using sortedNumbers search the number
		return 5;
	}
}
