$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/deleteTeacher.feature");
formatter.feature({
  "name": "As a User I should able to delete teacher",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@deleteTeacher"
    },
    {
      "name": "@Smoke"
    }
  ]
});
formatter.scenario({
  "name": "As a User I should able to delete teacher",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@deleteTeacher"
    },
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User should go to \"http://cybertektraining.com/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_go_to(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should navigate in \"Preschool - Admin Account\" page",
  "keyword": "And "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_navigate_in_page(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to Verify \"Teachers\" button in the left side of the page",
  "keyword": "And "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_be_able_to_see_button_in_the_left_side_of_the_page(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to click on Teacher button",
  "keyword": "And "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_be_able_to_click_on_Teacher_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to Verify \"All Teacher\" button",
  "keyword": "And "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_be_able_to_see_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to click on All Teacher button",
  "keyword": "And "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_be_able_to_click_on_All_Teacher_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to click on teacher profile icon",
  "keyword": "And "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_be_able_to_click_on_teacher_profile_icon()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to get Teacher ID from the teacher info",
  "keyword": "And "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_be_able_to_get_Teacher_ID_from_the_teacher_info()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be return to navigate backward",
  "keyword": "And "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_be_return_to_navigate_backward()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should insert the teacher_ID in Teacher ID filed",
  "keyword": "And "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_insert_the_teacher_ID_in_Teacher_ID_filed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to click on Search button",
  "keyword": "Then "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_be_able_to_click_on_Search_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be navigate in \"School - Admin\" page",
  "keyword": "And "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_be_navigate_in_page(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to click on Three dot in top right corner of Teacher",
  "keyword": "And "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_be_able_to_click_on_Three_dot_in_top_right_corner_of_Teacher()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to click Delete button on teacher profile icon",
  "keyword": "And "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_be_able_to_click_Delete_button_on_teacher_profile_icon()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be see confirmation window",
  "keyword": "Then "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_be_see_confirmation_window()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to click on Delete button",
  "keyword": "And "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_be_able_to_click_on_Delete_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User input the teacher_ID in Teacher ID filed",
  "keyword": "When "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_input_the_teacher_ID_in_Teacher_ID_filed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should click on Search button",
  "keyword": "Then "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.user_should_click_on_Search_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify that No teacher profile icon is Displayed",
  "keyword": "And "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.verify_that_No_teacher_profile_icon_is_Displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the teacher is not on Data base",
  "keyword": "Then "
});
formatter.match({
  "location": "deleteTeacher_steps_Difs.verify_the_teacher_is_not_on_Data_base()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});