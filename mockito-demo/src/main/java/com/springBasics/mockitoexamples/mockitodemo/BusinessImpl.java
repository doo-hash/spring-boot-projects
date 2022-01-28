package com.springBasics.mockitoexamples.mockitodemo;

public class BusinessImpl {

	private DataService dataService;
	
	public BusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	int findTheGreatest() {
		int[] data = dataService.retrieveAllData();
		int greatest = Integer.MIN_VALUE;
		
		for(int value : data) {
			if(value>greatest) {
				greatest = value;
			}
		}
		return greatest;
	}

}
