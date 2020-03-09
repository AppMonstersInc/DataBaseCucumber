package step_definitions.students_steps;

import cucumber.api.java.bs.A;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AllStudentsPage;
import utilities.DBUtility;
import utilities.Driver;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class deleteStudent_steps {

    AllStudentsPage allStudentsPage=new AllStudentsPage();
    List<Map<Object, Object>> data;
    List<WebElement> student;
    String id;



    @When("user click all student button from student functionality")
    public void user_click_all_student_button_from_student_functionality() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),5);
        wait.until(ExpectedConditions.elementToBeClickable(allStudentsPage.allStudentsButton));
     allStudentsPage.allStudentsButton.click();
        student= allStudentsPage.allStudentsNames;

    }

    @When("it should navigate to user all student page")
    public void it_should_navigate_to_user_all_student_page() {
        Assert.assertTrue(allStudentsPage.allStudentsHeader.isDisplayed());
        allStudentsPage.ricon.click();
        id=allStudentsPage.studentId.getText();
        Driver.getDriver().navigate().back();

    }

    @When("user click three dot")
    public void user_click_three_dot() throws InterruptedException {
        Thread.sleep(3000);
      allStudentsPage.threedot.click();
      Thread.sleep(3000);
    }

    @When("edit and delete button should be displayed")
    public void edit_and_delete_button_should_be_displayed() {
    Assert.assertTrue(allStudentsPage.dropdownStudent.isDisplayed());
    }

    @When("user click delete button")
    public void user_click_delete_button() {
       allStudentsPage.deleteButtonStudent.click();
    }

    @When("alert page should be displayed and user should be able to confirm")
    public void alert_page_should_be_displayed() {
        allStudentsPage.deleteConfirm.click();

    }



    @Then("verify student is deleted in the database")
    public void verify_student_is_deleted_in_the_database() throws InterruptedException {
        DBUtility.createConnection();
        data=DBUtility.executeQuery("select FIRST_NAME, LAST_NAME, STUDENT_ID from student");
        Thread.sleep(3000);
        for(Map<Object,Object> eachData:data){
         Assert.assertNotEquals("Student could'nt delete",eachData.get("STUDENT_ID").toString(),id);
        }
        }


    }


