package step_definitions.students_steps;

import cucumber.api.java.en.Given;
import pages.AllStudentsPage;

public class updateStudent_steps {
    AllStudentsPage allStudentsPage = new AllStudentsPage();

    @Given("I click all student button")
    public void i_click_all_student_button() {
       allStudentsPage.allStudentsButton.click();
    }

}
