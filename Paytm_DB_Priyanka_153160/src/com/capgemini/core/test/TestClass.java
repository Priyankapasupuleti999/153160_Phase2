package com.capgemini.core.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.*;

import com.capgemini.core.beans.Customer;
import com.capgemini.core.beans.Wallet;
import com.capgemini.core.exceptions.InsufficientBalanceException;
import com.capgemini.core.exceptions.InvalidInputException;
import com.capgemini.core.service.WalletService;
import com.capgemini.core.service.WalletServiceImpl;

public class TestClass {

	static WalletService walletService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		walletService = new WalletServiceImpl();
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateAccount() throws InvalidInputException {
		
		Customer customer = new Customer();
		Wallet wallet = new Wallet();
		
		String name = "priya";
		String number = "8008407446";
		BigDecimal amount = new BigDecimal(5000);
		
		customer.setName(name);
		customer.setMobileNo(number);
		wallet.setBalance(amount);
		customer.setWallet(wallet);
		
		customer = walletService.createAccount(name, number, amount);
		
		assertNotEquals(null, customer);
	}
	
	@Test
	public void testshowBalance() throws InvalidInputException {
	
		String number = "8008407446";
		
		Customer customer = walletService.showBalance(number);
		
		assertNotEquals(null,customer);
	}
	
	@Test(expected = InsufficientBalanceException.class)
	public void testWithdrawAmount() throws InvalidInputException, InsufficientBalanceException {
		
		String name = "priya";
		String mobileNumber = "8008407446";
		BigDecimal balance = new BigDecimal(2000);
		
		walletService.createAccount(name, mobileNumber, balance);
		
		BigDecimal amount = new BigDecimal(3000);
		
		walletService.withdrawAmount(mobileNumber, amount);
	}
	
	@Test
	public void testDepositAmount() throws InvalidInputException {
		
		String name = "priya";
		String mobileNumber = "8008407446";
		BigDecimal balance = new BigDecimal(3000);
		
		Customer customer = walletService.createAccount(name, mobileNumber, balance);
		System.out.println(customer.getWallet().getBalance());
		Customer customer1 = walletService.depositAmount(mobileNumber, new BigDecimal(3000));
		System.out.println(customer1.getWallet().getBalance());
		assertEquals(6000 , customer1.getWallet().getBalance());
	}
	
	@Test(expected = InvalidInputException.class)
	public void testMobileNumber() throws InvalidInputException, InsufficientBalanceException {
		
		String name = "priya";
		String mobileNumber = "8008407446";
		BigDecimal balance = new BigDecimal(3000);
		
		walletService.createAccount(name, mobileNumber, balance);
		
		BigDecimal amount = new BigDecimal(3000);
		
		walletService.withdrawAmount(mobileNumber, amount);
	}
}
