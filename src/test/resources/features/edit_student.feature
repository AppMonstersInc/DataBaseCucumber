@editStudent @Smoke
Feature: Edit student

  Scenario:  Verification of "All students" button
    Given As a User I am in the main menu page
    And user can see students button on the left side
    And user can click students button
    And user can see All student button in students section
    And user can click All students button
    And user should go student main page

  Scenario:  Verification of "cancel" button of the "edit" function
    Given user Is in the students main menu page
    When user can click  top corner three dots of the any student from the table
    And user can see edit and delete buttons
    And user can click edit button
    And user can be navigated to Edit student landing page
    And  user can click cancel button on the bottom of the page
    Then  then user should be navigated to students main menu page

  Scenario: Verification of "EDIT" button to edit the student

    Given user Is in the students main menu page
    When user can click  top corner three dots of the any student from the table
    And user can see edit and delete buttons
    And user can click edit button
    And user can be navigated to Edit student landing page
    And user can update firstname in the Firstname box
    And user can update lastname in the Lastname box
    And user can update Email in the Email box
    And user can update joining date in the JoiningDate box
    And user can update password in the password box
    And user can update ConfirmPassword in the ConfirmPassword box
    And user can update subject in the subject box
    And user can update mobileNumber in the MobileNumber box
    And user can update gender in the Gender box
    And user can update Admission No in the Admission No box
    And user can update bithdate in the BirthDate box
    And user can update major in the Major box
    And user can update batch in the Batch box
    And user can update section in the Section box
    And user can Permanent address name in the Permanent Address box
    And user can Company Information header text
    And User can update company Name input box
    And user can update title input box
    And user can update start date input box
    And user can update city input box
    And user can update street input box
    And user can update zipcode input box
    And use can update update state input box
    And user should  click submit button on the bottom of the page
    Then user can be navigated to All Students page back
    And Click on the student that was just created
    Then user can see new created student in bottom of the All Students page

