 @Smoke
Feature: As a User I should able to delete teacher

  Scenario: As a User I should able to delete teacher
    Given User should go to "http://cybertektraining.com/"
    And User should navigate in "Preschool - Admin Account" page
    And User should be able to Verify "Teachers" button in the left side of the page
    And User should be able to click on Teacher button
    And User should be able to Verify "All Teacher" button
    And User should be able to click on All Teacher button
    And User should be able to click on teacher profile icon
    And User should be able to get Teacher ID from the teacher info
    And User should be return to navigate backward
    And User should insert the teacher_ID in Teacher ID filed
    Then User should be able to click on Search button
    And User should be navigate in "School - Admin" page
    And User should be able to click on Three dot in top right corner of Teacher
    And User should be able to click Delete button on teacher profile icon
    Then User should be see confirmation window
    And User should be able to click on Delete button
    When User input the teacher_ID in Teacher ID filed
    Then User should click on Search button
    And Verify that No teacher profile icon is Displayed
    Then Verify the teacher is not on Data base
