package com.StringCrud;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMain {
	StringCRUD crud = new StringCRUD();

	@Test
	public void checkempty() {
		StringCRUD.str = "Create  ".split(" ");
		String actualProduct = crud.getAnswer();
		String expectedProduct = "String  invalid";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void CheckSingleSpaceInput() {
		StringCRUD.str = "CREATE Hello".split(" ");
		String actualProduct = crud.getAnswer();
		String expectedProduct = "String Hello created";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void CheckSerevalSpaceInput() {
		StringCRUD.str = "CREATE                  ".split(" ");
		String actualProduct = crud.getAnswer();
		String expectedProduct = "String  invalid";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void CheckSingleCharacterInput() {
		StringCRUD.str = "CREATE c".split(" ");
		String actualProduct = crud.getAnswer();
		String expectedProduct = "String c created";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void CheckMultipleSameLetterInput() {
		StringCRUD.str = "CREATE ssssssssssssssssssssss".split(" ");
		String actualProduct = crud.getAnswer();
		String expectedProduct = "String ssssssssssssssssssssss created";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void CheckTheSameCharacterInLowerAndUpperCasesMixedInTheInput() {
		StringCRUD.str = "CREATE sSsssSssSssSssSssSss".split(" ");
		String actualProduct = crud.getAnswer();
		String expectedProduct = "String sSsssSssSssSssSssSss created";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void CheckWordWithDifferentLetters() {
		StringCRUD.str = "CREATE Hello world!".split(" ");
		String actualProduct = crud.getAnswer();
		String expectedProduct = "String Hello created";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void CheckOnlySymbols() {
		StringCRUD.str = "CREATE qqqqqqqq q q q q qq qq q ".split(" ");
		String actualProduct = crud.getAnswer();
		String expectedProduct = "String qqqqqqqq created";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void checkSeveralWords() {
		StringCRUD.str = "CREATE Hello how are you?".split(" ");
		String actualProduct = crud.getAnswer();
		String expectedProduct = "String Hello created";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void getByIndex() {
		StringCRUD.str = "GET 5".split(" ");
		String actualProduct = crud.getAnswer();
		String expectedProduct = "5-world!";
		assertEquals(expectedProduct, actualProduct);
	}
	@Test
	public void get() {
		StringCRUD.str = "GET".split(" ");
		String actualProduct = crud.getAnswer();
		String expectedProduct = " 0-hello 1-my 2-dear 3-friend! 4-qqqqqqqq 5-world! 6-ssssssssssssssssssssss 7-Hello 8-sSsssSssSssSssSssSss";
		assertEquals(expectedProduct, actualProduct);
	}
	@Test
	public void updateByIndex() {
		StringCRUD.str = "UPDATE 5 world!".split(" ");
		String actualProduct = crud.getAnswer();
		String expectedProduct = "String with id = 5 updated";
		assertEquals(expectedProduct, actualProduct);
	}
	@Test
	public void delete() {
		StringCRUD.str = "DELETE 5".split(" ");
		String actualProduct = crud.getAnswer();
		String expectedProduct = "String  deleted";
		assertEquals(expectedProduct, actualProduct);
	}
}
