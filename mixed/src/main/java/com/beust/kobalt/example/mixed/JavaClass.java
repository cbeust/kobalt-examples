package com.beust.kobalt.example.mixed;

import org.joda.time.LocalDate;

public class JavaClass {
	public String sayHello() {
		LocalDate date = new LocalDate();
		return "JavaClass says hello, the time is " + date;
	}
}