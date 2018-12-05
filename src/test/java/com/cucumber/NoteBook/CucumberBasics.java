package com.cucumber.NoteBook;

public class CucumberBasics {

	
	/* 1. Cucumber Dependencies
	 * **********************
	 * 1.cucumber-core
	 * 2.cucumber-java
	 * 3.cucumber-junit
	 * 4.cucumber-testNG
	 * 5.cucumber-jvm-deps
	 * 6.cucumber-reporting
	 * 7.gherkin
	 * 8.junit
	 * 9.testNG
	 * 10.mockito-all cobertura
	 * 
	 * 2. Regular Expression
	 * ****************
	 *   Given User is on store.demoqa.com
	 *              ||
	 *              ||( we can write this in step Defination as )
	 *   @Given("^User is on store\\.demoqa\\.com$")            
	 *    ^ --> Hat operator should start with User
	 *    $ --> Doller operator should end with .com
	 * 
	 * 3. Capture Group
	 * *********************
	 *  Feature File : Given user enters UserName praneethmanala and Password praneethmanala
	 *                                              ||
	 *                                              ||( we can write this in step Defination as )
	 *                                              
	 *                                                           
	 *                   @Given("^user enters UserName (.*) and Password (.*) $")
	 *                    public void login(String Username ,String password){
	 *                    
	 *                    
	 *                    }
	 *   
	 * 4.Alternation Keyword(|)
	 * *********************
	 * Feature File: Navigate to http://toolsqa.com
	 *               Open http://toolsqa.com
	 *               Launch http://toolsqa.com
	 *               ||
	 *               ||( we can write this in step Defination as )
	 *              @Given("^(Navigate to|Open|Launch) http://toolsqa.com$")
	 *              public void navigateTo(String url){
	 *              
	 *               }
	 * 
	 * 5.?: expression
	 * ****************
	 *              @Given("^User (?:Navigate to|Open|Launch) (http.*com)$")
	 *              public void navigateTo(String url){
	 *              
	 *               } 
	 *                                  
	 *                    
	 *                    
	 *                    
	 *                    
	 *                    
	 *                    
	 *                    
	 *                    
	 *                    
	 *                    
	 *                    
	 */
	
	
	
}
