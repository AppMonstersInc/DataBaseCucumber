package step_definitions.students_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.AllStudentsPage;
import utilities.Log;

import java.util.List;

public class updateStudent_steps {
    AllStudentsPage allStudentsPage = new AllStudentsPage();

    @Given("I click all student button")
    public void i_click_all_student_button() {
       allStudentsPage.allStudentsButton.click();
    }


    @Given("Click on the student that was just created to up date last name")
    public void click_on_the_student_that_was_just_created_to_up_date_last_name() {
        List<WebElement> list = allStudentsPage.allStudentsThreeDots;
        WebElement lastStudent = list.get(list.size() - 1);
        Log.info("Click on dots that was created");
        lastStudent.click();
        List<WebElement> list2 = allStudentsPage.allStudentsEdit;
        WebElement lastStudentEdit = list.get(list2.size() - 1);
        Log.info("Click on edit that was created");
        lastStudent.click();
    }

    @Then("Verify if last last name is updated in data data base")
    public void verify_if_last_last_name_is_updated_in_data_data_base() {

    }


}
