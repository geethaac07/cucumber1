Feature: Login Functionality

  Background: 
    Given user opens salesforce application

  Scenario: Login error message validation
    When user is on "LoginPage"
    When I enter valid username only
    And click on Login button
    Then verify error message "Please enter your password."

  Scenario: Successful login with valid credentials
    When user is on "LoginPage"
    When I enter valid username and valid password
    And click on Login button
    When user on "HomePage"
    Then verify Getting started heading

  Scenario: Successful login with remember me checked
    When User is on "LoginPage"
    When I enter valid username and valid password
    When click remember me checkbox
    When click on Login button
    When user on "HomePage"
    And click logout
    Then user should be logged out
    And username is entered in the text field
