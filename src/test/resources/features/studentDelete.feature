@Smoke
Feature:Delete Functionality - Student

  Scenario: User should be able to delete student
    Given As a User I am in the main menu page
    And I click to Students button
    Then I should see two buttons All Students and Add Students
    When user click all student button from student functionality
    And it should navigate to user all student page
    When user click three dot
    And edit and delete button should be displayed
    When user click delete button
    And alert page should be displayed and user should be able to confirm
    Then verify student is deleted in the database