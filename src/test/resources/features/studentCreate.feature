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