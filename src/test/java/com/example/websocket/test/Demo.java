package com.example.websocket.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo {
	long begin;
	long end;
	
	@BeforeSuite
	public void beforeSuite() {System.out.println("BeforeSuite");}
	@AfterSuite
	public void afterSuite() {System.out.println("AfterSuite");}
	@BeforeTest
	public void beforeTest() {System.out.println("-BeforeTest");}
	@AfterTest
	public void afterTest() {System.out.println("-AfterTest");}
	@BeforeClass
	public void beforeClass() {System.out.println("--BeforeClass");begin=System.currentTimeMillis();}
	@AfterClass
	public void afterClass() {System.out.println("--AfterClass");end=System.currentTimeMillis();System.out.println("耗时"+(end-begin));}
	@BeforeMethod
	public void beforeMethod() {System.out.println("---BeforeMethod");}
	@AfterMethod
	public void afterMethod() {System.out.println("---AfterMethod");}

	@Test
	public void t1() {System.out.println(Thread.currentThread().getName());}
	@Test
	public void t2() {System.out.println(Thread.currentThread().getName());}
	@Test
	public void t3() {System.out.println(Thread.currentThread().getName());}
	@Test
	public void t4() {System.out.println(Thread.currentThread().getName());}
	@Test
	public void t5() {System.out.println(Thread.currentThread().getName());}
	
}
