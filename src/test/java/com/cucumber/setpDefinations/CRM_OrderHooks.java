package com.cucumber.setpDefinations;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CRM_OrderHooks {

	   /*The very important thing to note here is:

	    @Before(order = int) : This runs in increment order, means value 0 would run first and 1 would be after 0.
	    @After(order = int) : This runs in decrements order, means apposite of @Before. Value 1 would run first and 0 would be after 1.*/
	
	/*@Before(order = 1)
	public void beforeScenario() {
		System.out.println("This will run before the every Scenario");
	}

	@Before(order = 0)
	public void beforeScenarioStart() {
		System.out.println("-----------------Start of Scenario-----------------");
	}

	@After(order = 0)
	public void afterScenarioFinish() {
		System.out.println("-----------------End of Scenario-----------------");
	}

	@After(order = 1)
	public void afterScenario() {
		System.out.println("This will run after the every Scenario");
	}*/

	@Given("^this is the first stepOrder$")
	public void This_Is_The_First_Step() {
		System.out.println("This is the first step");
	}

	@When("^this is the second stepOrder$")
	public void This_Is_The_Second_Step() {
		System.out.println("This is the second step");
	}

	@Then("^this is the third stepOrder$")
	public void This_Is_The_Third_Step() {
		System.out.println("This is the third step");
	}
}
