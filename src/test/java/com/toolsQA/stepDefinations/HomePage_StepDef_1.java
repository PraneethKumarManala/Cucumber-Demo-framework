package com.toolsQA.stepDefinations;

import com.toolsQA.cucumber.TestContext;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
public class HomePage_StepDef_1 {

	TestContext testContext;
	 HomePage homePage;
	 
	 public HomePage_StepDef_1(TestContext context) {
	 testContext = context;
	 homePage = testContext.getPageObjectManager().getHomePage();
	 }
	 
	 @Given("^user is on Home Page$")
	 public void user_is_on_Home_Page(){
	 homePage.navigateTo_HomePage(); 
	 }
	 
	 @When("^he search for \"([^\"]*)\"$")
	 public void he_search_for(String product)  {
	 homePage.perform_Search(product);
	 }
}
