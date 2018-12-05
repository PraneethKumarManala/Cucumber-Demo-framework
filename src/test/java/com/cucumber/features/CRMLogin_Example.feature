Feature: CRM Application Login functionality with Example Keyword
Scenario Outline: Verify Login Functionality with Correct UserName and Password
Given  Open the Browser and Enter URLE
Then Verify Title of Login PageE
When User enters "<username>" and "<password>" and Click on Login buttonE
Then Verify Home PageE
Examples:
|username|password|
|praneethmanala|praneethmanala|
|praneeth|praneeth|
