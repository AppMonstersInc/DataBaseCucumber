
@deleteTeacher
  @Smoke
Feature: As a User I should able to delete teacher

  Scenario: As a User I should able to delete teacher
    Given User should go to "http://cybertektraining.com/"
    And User should navigate in "Preschool - Admin Account" page
    And User should be able to see "Teachers" button in the left side of the page
    And User should be able to click on Teacher button
    And User should be able to see "All Teacher" button
    And User should be able to click on All Teacher button
    And User should be able to insert "605" in teacher id filed
    Then User should be able to click on Search button
    And User should be navigate in "School - Admin" page
    And User should be able to click on Three dot in top right corner of Teacher
    And User should be able to click Delete button
    Then User should be see confirmation window
    And User should be able to click on Delete button
    Then Verify this user deleted from UI
    And  Verify this user not on Data base