package com.springbasics.BasicSpringAppln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springbasics.BasicSpringAppln.SearchEx.BinarySearchImpl;
import com.springbasics.BasicSpringAppln.SearchEx.BubbleSort;
import com.springbasics.BasicSpringAppln.SearchEx.QuickSort;

@SpringBootApplication
public class BasicSpringApplnApplication {

	public static void main(String[] args) {
		
//		BinarySearchImpl binarySearchImpl = new BinarySearchImpl(new BubbleSort());
//		BinarySearchImpl binarySearchImpl2 = new BinarySearchImpl(new QuickSort());
		

		ApplicationContext applicationContext = SpringApplication.run(BasicSpringApplnApplication.class, args);
		
//		int Result = binarySearchImpl.binarysearch(new int[] {15,52,48,42}, 5);
//		System.out.println(Result);
		
//		int Result2 = binarySearchImpl2.binarysearch(new int[] {15,52,48,42}, 5);
//		System.out.println(Result2);
		
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		int Result = binarySearch.binarysearch(new int[] {15,52,48,42}, 5);
		System.out.println(Result);
		System.out.println(binarySearch);
		
		
		BinarySearchImpl binarySearch1 = applicationContext.getBean(BinarySearchImpl.class);
		int Result1 = binarySearch1.binarysearch(new int[] {15,52,48,42}, 5);
		System.out.println(Result1);
		System.out.println(binarySearch1);

	}

}
