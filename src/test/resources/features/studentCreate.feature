Feature: As a User I should able to create student

  @Smoke
  Scenario: As a User I should able to create student
    Given As a User I am in the main menu page
    And I click to Students button
    Then I should see two buttons All Students and Add Students
    When I click add student from students functionality
    And I navigated to add student page
    And I fill out all information about new student
    When I click submit button
    Then It should see new student in the All students table
    And Click on the student that was just created
    Then Verify if full name of new student matching in data base
    Then Verify student join date is matching in data base
    Then verify student admission number is matching in data base
    Then Verify student birthday and start date matching in data base
    Then Verify student gender is matching in data base
    Then Verify student section is matching in data base
    Then Verify student subject is matching in data base

  Scenario: As a User I should able to update student
    Given As a User I am in the main menu page
    And I click to Students button
    And I click all student button
    And Click on the student that was just created to up date last name
    Then Verify if last last name is updated in data data base

  Scenario: As a User I should able to delete the student
    Given As a User I am in the main menu page
    And I click to Students button
    And I click all student button
    And Click on the student that was just created and take this id
    And I put the id in search box
    Then I verify this user is displayed
    And Delete this student
    Then Verify student was deleted from UI
    Then Verify student was deleted from DB




