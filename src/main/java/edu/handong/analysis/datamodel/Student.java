package edu.handong.analysis.datamodel;

public class Student {
	private String name;
	
	public Student(String name) {
		this.name = name;

	}
	//constructor return값 없음
	
	public String getName() {
		return name;
	}
	//getter return값 있
}

//.trim().split(",")[1];