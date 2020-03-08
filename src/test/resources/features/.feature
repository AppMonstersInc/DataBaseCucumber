Feature: As a User I should able to create student

 // @Smoke
  Scenario: As a User I should able to create student
    Given As a User I am in the main menu page
    And I click to Students button
    Then I should see two buttons All Students and Add Students
    When I click add student from students functionality
    And I navigated to add student page
    And I fill out all information about new student
    And I fill out all information about new student with value
      | FIRST_NAME        | John                    |
      | LAST_NAME         | Travolta                |
      | PHONE             | 9302095811              |
      | DEPARTMENT        | Cinema                  |
      | JOIN_DATE         | 10/20/2012              |
      | PREMANENT_ADDRESS | 345 Chicago ln, Indiana |
      | EMAIL_ADDRESS     | john_travolta@gmail.com |
      | PASSWORD          | 123                     |
      | BIRTH_DATE        | 01/19/1962              |
      | GENDER            | Male                    |
      | SUBJECT           | Uma Turman              |
      | BATCH             | 1                       |
      | SECTION           | ACT                     |
      | MAJOR             | DOOM                    |

    When I click submit button
    Then It should see new student in the All students table
    And Click on the student that was just created
