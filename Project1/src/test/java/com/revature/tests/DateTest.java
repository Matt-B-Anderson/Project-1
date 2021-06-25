package com.revature.tests;

import org.junit.Test;

import com.revature.daos.AuthorDAO;
import com.revature.daos.StoryDAO;
import com.revature.services.AuthorServiceImpl;

public class DateTest {

	private AuthorServiceImpl asi = new AuthorServiceImpl();
	private AuthorDAO ad = new AuthorDAO();
	private StoryDAO sd = new StoryDAO();

//	@Test
//	public void test() {
//		DateTimeFormatter myObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");
//		System.out.println(LocalDate.now().format(myObj));
//	}

	@Test
	public void test2() {

		System.out.println(asi.getAuthorById(3));
	}
}
