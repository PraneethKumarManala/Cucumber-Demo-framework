Feature: CRM Application Login functionality with Hooks

@SmokeTest
Scenario: Verify Login Functionality with Correct UserName and Password
Given  Open the Browser and Enter URLHooks
Then Verify Title of Login PageHooks
When User enters Username and Password and Click on Login buttonHooks
Then Verify Home PageHooks

@RegressionTest
Scenario Outline: Verify Login Functionality with Correct UserName and Password
Given  Open the Browser and Enter URLHooks
Then Verify Title of Login PageHooks
When User enters "<username>" and "<password>" and Click on Login buttonHooks2
Then Verify Home PageHooks
Examples:
|username|password|
|praneethmanala|praneethmanala|
|praneeth|praneeth|


@RegressionTest @End2EndTest
Scenario: Create a new deal scenario
Given  Open the Browser and Enter URLHooks
Then Verify Title of Login PageHooks
When User enters Username and Password and Click on Login buttonHooks
Then Verify Home PageHooks
Then moves to new deal pageHooks3
Then user enters deal detailsHooks3
|title|amount| probobility|commission |
|Test Deal3| 1000 | 50 | 10 |
|Test Deal4| 2000 | 60 | 20 |
