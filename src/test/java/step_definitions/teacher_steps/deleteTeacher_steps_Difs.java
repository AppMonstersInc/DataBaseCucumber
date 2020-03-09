package step_definitions.teacher_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DeleteTeacherPage;
import utilities.DBUtility;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.Map;

public class deleteTeacher_steps_Difs {



    List<Map<Object,Object>> myData;



    DeleteTeacherPage deleteTeacherPage = new DeleteTeacherPage();

    String  teacherId;


    @Given("User should go to {string}")
    public void user_should_go_to(String URL) {
        Driver.getDriver().get(URL);


    }

    @Given("User should navigate in {string} page")
    public void user_should_navigate_in_page(String homePage) {

        Assert.assertEquals("The home page title is Wrong!!",homePage,Driver.getDriver().getTitle());
    }

    @Given("User should be able to Verify {string} button in the left side of the page")
    public void user_should_be_able_to_see_button_in_the_left_side_of_the_page(String Teachers) {

        Assert.assertEquals("Wrong Teacher Text Btn!!",Teachers,deleteTeacherPage.teachersButton.getText());

    }

    @Given("User should be able to click on Teacher button")
    public void user_should_be_able_to_click_on_Teacher_button() {
        SeleniumUtils.pause(3);
        deleteTeacherPage.teachersButton.click();

    }

    @Given("User should be able to Verify {string} button")
    public void user_should_be_able_to_see_button(String AllTeacherBtn) {
        Assert.assertEquals("Wrong All Teacher text Btn!!",AllTeacherBtn,deleteTeacherPage.allTeacherButton.getText());

    }

    @Given("User should be able to click on All Teacher button")
    public void user_should_be_able_to_click_on_All_Teacher_button() {
        deleteTeacherPage.allTeacherButton.click();

    }

    @Then("User should be navigate in {string} page")
    public void user_should_be_navigate_in_page(String teacherPage) {

        Assert.assertEquals("Teacher Title page Wrong!!!",teacherPage,Driver.getDriver().getTitle());

    }

    @Given("User should be able to click on teacher profile icon")
    public void user_should_be_able_to_click_on_teacher_profile_icon() {
       deleteTeacherPage.teacherProfile.click();
       SeleniumUtils.pause(2);

    }

    @Given("User should be able to get Teacher ID from the teacher info")
    public void user_should_be_able_to_get_Teacher_ID_from_the_teacher_info() {
       teacherId = deleteTeacherPage.theTeacherId.getText();

    }

    @Given("User should be return to navigate backward")
    public void user_should_be_return_to_navigate_backward() {
        Driver.getDriver().navigate().back();

    }

    @Given("User should insert the teacher_ID in Teacher ID filed")
    public void user_should_insert_the_teacher_ID_in_Teacher_ID_filed() {

        deleteTeacherPage.teacherID_Input.sendKeys(teacherId);

    }


    @Then("User should be able to click on Search button")
    public void user_should_be_able_to_click_on_Search_button() {
        deleteTeacherPage.searchButton.click();

    }


    @Then("User should be able to click on Three dot in top right corner of Teacher")
    public void user_should_be_able_to_click_on_Three_dot_in_top_right_corner_of_Teacher() {

        deleteTeacherPage.threeDotButton.click();
    }



    @Then("User should be able to click Delete button on teacher profile icon")
    public void user_should_be_able_to_click_Delete_button_on_teacher_profile_icon() {
        deleteTeacherPage.deleteButton.click();

    }

    @Then("User should be see confirmation window")
    public void user_should_be_see_confirmation_window() {
        Assert.assertTrue("Confirmation Delete Window is Not Displayed!!",deleteTeacherPage.confirmationDeleteWindow.isDisplayed());

    }

    @Then("User should be able to click on Delete button")
    public void user_should_be_able_to_click_on_Delete_button() {
        deleteTeacherPage.deleteBtnInsideConfirmationWindow.click();

    }

    @When("User input the teacher_ID in Teacher ID filed")
    public void user_input_the_teacher_ID_in_Teacher_ID_filed() {
        deleteTeacherPage.teacherID_Input.sendKeys(teacherId);

    }

    @Then("User should click on Search button")
    public void user_should_click_on_Search_button() {
        deleteTeacherPage.searchButton.click();

    }

    @Then("Verify that No teacher profile icon is Displayed")
    public void verify_that_No_teacher_profile_icon_is_Displayed() {

        List<WebElement> list = deleteTeacherPage.teachersProfiles;
        Assert.assertEquals("TEACHER IS NOT DELETED IN UI!!",list.size(),0);



    }

    @Then("Verify the teacher is not on Data base")
    public void verify_the_teacher_is_not_on_Data_base() {


        DBUtility.createConnection();
        myData = DBUtility.executeQuery("SELECT teacher_id from teacher");

        int counter = 0 ;
        for (Map<Object,Object> ids: myData){
            if (ids.get("TEACHER_ID")== Integer.valueOf(teacherId)){
                counter++;
            }

        }
        Assert.assertEquals("TEACHER ITS NOT DELETED IN THE DATA BASE!",counter,0);

        Driver.closeDriver();

    }








}
