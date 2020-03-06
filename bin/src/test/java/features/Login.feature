Feature: Login into Application

Scenario Outline: Positive test validating login

Given Initialize the browser with chrome
And Navigate to the "http://qaclickacademy.com/" site
And Click on Login link in home page to land on Secure sign in page
When User enters "<username>" and "<password>" and logs in 
Then Verife that user is succesfuly login
And Close browsers

Examples: 
|username			|password	|
|test99@gmail.com	|123456		|
|test123@gmail.com	|12345		|