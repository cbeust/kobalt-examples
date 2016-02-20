package com.beust.kobalt.example;

import org.testng.annotations.Test;

public class ATest {
	@Test(groups = "broken")
	public void broken() {
		System.out.println("Running test broken");
	}

	@Test
	public void works() {
		System.out.println("Running test works");
	}
}