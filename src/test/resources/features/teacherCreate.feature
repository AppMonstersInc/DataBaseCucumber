@Smoke
Feature: As a User I should able to create teacher

  Scenario: I should be able to add a new teacher
    Given As a User I am in the main menu page
    And I verify if Teachers button is displayed on the left side of the main page
    When I click on teachers button
    And I verify if Add Teacher button is displayed
    When I click on Add Teacher button
    And I should be navigated to Add Teacher page
    And I fill out all information about new Teacher
    When I click on submit button
    Then I verify if new teacher information is matching to database