Feature: CRM Application Login functionality with Background Keyword

Background:
Given  Open the Browser and Enter URLBackground
Then Verify Title of Login PageBackground

Scenario: Verify Login Functionality with Correct UserName and Password
When User enters Username and Password and Click on Login buttonBackground
Then Verify Home PageBackground


Scenario Outline: Verify Login Functionality with Correct UserName and Password
When User enters "<username>" and "<password>" and Click on Login buttonBackground2
Then Verify Home PageBackground
Examples:
|username|password|
|praneethmanala|praneethmanala|
|praneeth|praneeth|