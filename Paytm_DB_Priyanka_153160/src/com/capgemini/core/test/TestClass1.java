package com.capgemini.core.test;

import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.core.beans.Customer;
import com.capgemini.core.exceptions.InvalidInputException;
import com.capgemini.core.service.WalletService;
import com.capgemini.core.service.WalletServiceImpl;


public class TestClass1 {

	static WalletService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		service = new WalletServiceImpl();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception 
	{
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected=InvalidInputException.class)
	public void testCreateAccount1() throws InvalidInputException 
	{
		service.createAccount(null, "9441844456", new BigDecimal(5000));
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testCreateAccount2() throws InvalidInputException 
	{
		service.createAccount("", "7095213532", new BigDecimal(5000));
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testCreateAccount3() throws InvalidInputException 
	{
		service.createAccount("priya", "800", new BigDecimal(2500));
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testCreateAccount4() throws InvalidInputException 
	{
		service.createAccount("priya", "", new BigDecimal(2500));
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testCreateAccount5() throws InvalidInputException 
	{
		service.createAccount("", "", new BigDecimal(2500));
	}
	
	@Test
	public void testCreateAccount6() throws InvalidInputException 
	{
		Customer customer1 = service.createAccount("priya", "9441844456", new BigDecimal(5000));
		Customer customer2 = null;
		
		assertNotEquals(customer2, customer1);
	}
	
	@Test(expected=InvalidInputException.class)
	public void testCreateAccount7() throws InvalidInputException 
	{
		service.createAccount("hemanthi", "9441844456", new BigDecimal(9000));
		service.createAccount("mouni", "7095213532", new BigDecimal(10000));
	}
	
	

}
