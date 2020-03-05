$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/studentCreate.feature");
formatter.feature({
  "name": "As a User I should able to create student",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "As a User I should able to create student",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "name": "As a User I am in the main menu page",
  "keyword": "Given "
});
formatter.match({
  "location": "createStudent_steps.as_a_User_I_am_in_the_main_menu_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click to Students button",
  "keyword": "And "
});
formatter.match({
  "location": "createStudent_steps.i_click_to_Students_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see two buttons All Students and Add Students",
  "keyword": "Then "
});
formatter.match({
  "location": "createStudent_steps.i_should_see_two_buttons_All_Students_and_Add_Students()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click add student from students functionality",
  "keyword": "When "
});
formatter.match({
  "location": "createStudent_steps.i_click_add_student_from_students_functionality()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigated to add student page",
  "keyword": "And "
});
formatter.match({
  "location": "createStudent_steps.i_navigated_to_add_student_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I fill out all information about new student",
  "keyword": "And "
});
formatter.match({
  "location": "createStudent_steps.i_fill_out_all_information_about_new_student()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click submit button",
  "keyword": "When "
});
formatter.match({
  "location": "createStudent_steps.i_click_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "It should see new student in the All students table",
  "keyword": "Then "
});
formatter.match({
  "location": "createStudent_steps.it_should_see_new_student_in_the_All_students_table()"
});
formatter.result({
  "status": "passed"
});
});