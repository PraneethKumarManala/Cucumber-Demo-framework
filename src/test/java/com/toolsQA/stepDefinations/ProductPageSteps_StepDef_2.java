package com.toolsQA.stepDefinations;


import com.toolsQA.cucumber.TestContext;

import cucumber.api.java.en.When;
import pageObjects.ProductListingPage;

public class ProductPageSteps_StepDef_2 {
	 TestContext testContext;
	 ProductListingPage productListingPage;
	 
	 public ProductPageSteps_StepDef_2(TestContext context) {
	 testContext = context;
	 productListingPage = testContext.getPageObjectManager().getProductListingPage();
	 }
	 
	 @When("^choose to buy the first item$")
	 public void choose_to_buy_the_first_item() {
	 productListingPage.select_Product(0);
	 productListingPage.clickOn_AddToCart(); 
	 }
}
