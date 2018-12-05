package com.toolsQA.stepDefinations;

import com.toolsQA.cucumber.TestContext;

import cucumber.api.java.en.When;
import pageObjects.CartPage;
 

public class CartPageSteps_SetpDef_3 {
	 TestContext testContext;
	 CartPage cartPage;
	 
	 public CartPageSteps_SetpDef_3(TestContext context) {
	 testContext = context;
	 cartPage = testContext.getPageObjectManager().getCartPage();
	 }
	 
	 @When("^moves to checkout from mini cart$")
	 public void moves_to_checkout_from_mini_cart(){
	 cartPage.clickOn_Cart();
	 cartPage.clickOn_ContinueToCheckout(); 
	 }
}
