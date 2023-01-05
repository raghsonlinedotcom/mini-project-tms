/**
 * 
 */
package com.raghsonline.tutorials.java.initializer;

/**
 * @author raghavan.muthu
 *
 */
public class InitializerTest 
{
	{
		System.out.println("Instance Initializer Block #2 invoked");
		name = "Initializer-2";
	}
	
	static {
		System.out.println("[*][*].... Static Initializer Block #2 invoked");
		color = "red";
		/* ERROR! */ //name = "Arun";
	}
	
	String name;
	
	static String color;
	
	public InitializerTest() {
		System.out.println("Default constructor called");
		System.out.println("Initialized value of name : " + this.name);
		//name =  "Default";
	}
	
	public InitializerTest(String name) {
		System.out.println("Parameterized constructor called");
		System.out.println("Initialized value of name : " + this.name);
		this.name = name;
	}
	
	{
		System.out.println("Instance Initializer Block invoked");
		name = "Initializer";
	}
	
	static {
		System.out.println("[*][*].... Static Initializer Block invoked");
		color = "green";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InitializerTest obj1 = new InitializerTest();
		System.out.println("obj1 name : " + obj1.name);
		System.out.println("Static color  : " + InitializerTest.color);
		System.out.println("---------------------");
		InitializerTest obj2 = new InitializerTest("Raghavan");
		System.out.println("obj2 name : " + obj2.name);
		System.out.println("Static color  : " + InitializerTest.color);
	}

}
