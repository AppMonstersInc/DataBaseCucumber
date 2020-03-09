package step_definitions.Edit_Student;

import com.github.javafaker.Faker;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AllStudentsPage;
import pages.Edit_Student_Pages.EditStudent;
import pages.Main_menu_page.MainMenuPage;
import pages.MyProfileStudentPage;
import utilities.DBUtility;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.Map;

public class EditStudent_Steps {
    AllStudentsPage allStudentsPage = new AllStudentsPage();
    MainMenuPage mainMenuPage = new MainMenuPage();
    EditStudent editStudent = new EditStudent();
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String password = faker.code().asin();
    MyProfileStudentPage myProfileStudentPage = new MyProfileStudentPage();

    @Given("user can see students button on the left side")
    public void user_can_see_students_button_on_the_left_side() {
        Assert.assertTrue("Students button is NOT displayed!",
                mainMenuPage.studentsButtonMain.isDisplayed());
    }

    @Given("user can click students button")
    public void user_can_click_students_button() {
        mainMenuPage.studentsButtonMain.click();
    }

    @Given("user can see All student button in students section")
    public void user_can_see_All_student_button_in_students_section() {
        Assert.assertTrue("All students button is NOT displayed!",
                mainMenuPage.allStudentsButton.isDisplayed());

    }

    @Given("user can click All students button")
    public void user_can_click_All_students_button() {
        mainMenuPage.allStudentsButton.click();
    }

    @Given("user should go student main page")
    public void user_should_go_student_main_page() {
        Assert.assertTrue("All students Header Text is NOT displayed!",
                editStudent.allStudentsHeaderText.isDisplayed());
    }

    @Given("user Is in the students main menu page")
    public void user_Is_in_the_students_main_menu_page() {
        Assert.assertTrue("All students header Text is NOT displayed!",
                editStudent.allStudentsHeaderText.isDisplayed());
    }

    @When("user can click  top corner three dots of the any student from the table")
    public void user_can_click_top_corner_three_dots_of_the_any_student_from_the_table() {
        editStudent.threeDotsOfStudent.click();

    }

    @When("user can see edit and delete buttons")
    public void user_can_see_edit_and_delete_buttons() {
        Assert.assertTrue("Edit button is NOT displayed!",
                editStudent.editButton.isEnabled());
        Assert.assertTrue("Delete button is NOT displayed!",
                editStudent.deleteButton.isEnabled());
    }

    @When("user can click edit button")
    public void user_can_click_edit_button() {
        editStudent.editButton.click();
    }

    @When("user can be navigated to Edit student landing page")
    public void user_can_be_navigated_to_Edit_student_landing_page() {
        Assert.assertTrue("Edit Teacher header text is NOT displayed!",
                editStudent.editStudentHeaderText.isDisplayed());
    }

    @When("user can click cancel button on the bottom of the page")
    public void user_can_click_cancel_button_on_the_bottom_of_the_page() throws Exception{
        SeleniumUtils.pause(3);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(editStudent.cancelButton).build().perform();
        SeleniumUtils.explicitWaitClickable(editStudent.cancelButton);
        editStudent.cancelButton.click();
    }

    @Then("then user should be navigated to students main menu page")
    public void then_user_should_be_navigated_to_students_main_menu_page() {
        Assert.assertTrue("All students header text is NOT displayed!",
                editStudent.allStudentsHeaderText.isDisplayed());
    }
    @When("user can update firstname in the Firstname box")
    public void user_can_update_firstname_in_the_Firstname_box() {

        editStudent.firstNameInput.clear();
        editStudent.firstNameInput.sendKeys(firstName);
    }

    @When("user can update lastname in the Lastname box")
    public void user_can_update_lastname_in_the_Lastname_box() {

        editStudent.lastnameInput.clear();
        editStudent.lastnameInput.sendKeys(lastName);
    }

    @When("user can update Email in the Email box")
    public void user_can_update_Email_in_the_Email_box() {
        String email = firstName+lastName+"@gmail.com";
        editStudent.emailInput.clear();
        editStudent.emailInput.sendKeys(email);
    }

    @When("user can update joining date in the JoiningDate box")
    public void user_can_update_joining_date_in_the_JoiningDate_box() {
        String joiningDate = "05/20/2017";
        editStudent.joiningDateInput.clear();
        editStudent.joiningDateInput.sendKeys(joiningDate);
    }

    @When("user can update password in the password box")
    public void user_can_update_password_in_the_password_box() {

        editStudent.passwordInput.clear();
        editStudent.passwordInput.sendKeys(password);
    }

    @When("user can update ConfirmPassword in the ConfirmPassword box")
    public void user_can_update_ConfirmPassword_in_the_ConfirmPassword_box() {
        String confirmPassword = password;
        editStudent.confirmPasswordInput.clear();
        editStudent.confirmPasswordInput.sendKeys(confirmPassword);
    }

    @When("user can update subject in the subject box")
    public void user_can_update_subject_in_the_subject_box() {
        String subject = "Mathematics";
        editStudent.subjectInput.clear();
        editStudent.subjectInput.sendKeys(subject);
    }

    @When("user can update mobileNumber in the MobileNumber box")
    public void user_can_update_mobileNumber_in_the_MobileNumber_box() {
        //    String mobileNumber = faker.phoneNumber().phoneNumber();
        String mobileNumber = "123456789";
        editStudent.mobileNUmberInput.clear();
        editStudent.mobileNUmberInput.sendKeys(mobileNumber);
    }

    @When("user can update gender in the Gender box")
    public void user_can_update_gender_in_the_Gender_box() {
        Select select = new Select(editStudent.genderSelectInput);
        select.selectByVisibleText("Male");
    }

    @When("user can update Admission No in the Admission No box")
    public void user_can_update_Admission_No_in_the_Admission_No_box() {
        String admissionNo = faker.number().digits(8);
        editStudent.admissionNoInput.clear();
        editStudent.admissionNoInput.sendKeys(admissionNo);
    }

    @When("user can update bithdate in the BirthDate box")
    public void user_can_update_bithdate_in_the_BirthDate_box() {
        String birthDate = "05/05/1995";
        editStudent.birthDateInput.clear();
        editStudent.birthDateInput.sendKeys(birthDate);
    }

    @When("user can update major in the Major box")
    public void user_can_update_major_in_the_Major_box() {
        String major = faker.university().name();
        editStudent.majorInput.clear();
        editStudent.majorInput.sendKeys(major);
    }

    @When("user can update batch in the Batch box")
    public void user_can_update_batch_in_the_Batch_box() {
        Select select = new Select(editStudent.batchInput);
        select.selectByIndex(5);
    }

    @When("user can update section in the Section box")
    public void user_can_update_section_in_the_Section_box() {
        String section = faker.numerify("5668686asfawef");
        editStudent.sectionInput.clear();
        editStudent.sectionInput.sendKeys(section);
    }

    @When("user can Permanent address name in the Permanent Address box")
    public void user_can_Permanent_address_name_in_the_Permanent_Address_box() {
        String permanentAdress = faker.address().fullAddress();
        editStudent.permanentAdressInputBox.clear();
        editStudent.permanentAdressInputBox.sendKeys(permanentAdress);
    }

    @When("user can Company Information header text")
    public void user_can_Company_Information_header_text() {
        Assert.assertTrue("Company Information text is NOT displayed!",
                editStudent.companyInformationHeaderText.isDisplayed());
    }

    @When("User can update company Name input box")
    public void user_can_update_company_Name_input_box() {
        String companyName = faker.company().name();
        editStudent.companyNameInput.clear();
        editStudent.companyNameInput.sendKeys(companyName);
    }

    @When("user can update title input box")
    public void user_can_update_title_input_box() {
        String title = faker.company().profession();
        editStudent.titleInput.clear();
        editStudent.titleInput.sendKeys(title);
    }

    @When("user can update start date input box")
    public void user_can_update_start_date_input_box() {
        String startDate = "06/05/2020";
        editStudent.startDateInput.clear();
        editStudent.startDateInput.sendKeys(startDate);
    }

    @When("user can update city input box")
    public void user_can_update_city_input_box() {
        String city = faker.address().city();
        editStudent.cityInput.clear();
        editStudent.cityInput.sendKeys(city);
    }

    @When("user can update street input box")
    public void user_can_update_street_input_box() {
        String street = faker.address().streetAddress();
        editStudent.streetInput.clear();
        editStudent.streetInput.sendKeys(street);
    }

    @When("user can update zipcode input box")
    public void user_can_update_zipcode_input_box()throws Exception {
        SeleniumUtils.pause(2);
        //  String zipcode = faker.address().zipCode();
        String zipcode = "60630";
        SeleniumUtils.explicitWaitVisibility(editStudent.zipCodeInput);
        editStudent.zipCodeInput.clear();
        editStudent.zipCodeInput.sendKeys(zipcode);
    }

    @When("use can update update state input box")
    public void use_can_update_update_state_input_box() {
        String state = faker.address().state();
        editStudent.stateInput.clear();
        editStudent.stateInput.sendKeys(state);
    }
    @When("user should  click submit button on the bottom of the page")
    public void user_should_click_submit_button_on_the_bottom_of_the_page() throws Exception{
        SeleniumUtils.pause(3);
        SeleniumUtils.explicitWaitClickable(editStudent.submitButton);
        editStudent.submitButton.click();
    }

    @Then("user can be navigated to All Students page back")
    public void user_can_be_navigated_to_All_Students_page_back() {
        SeleniumUtils.explicitWaitVisibility(editStudent.allStudentsHeaderText);
        Assert.assertTrue("All students header page is NOT displayed!",
                allStudentsPage.allStudentsHeader.isDisplayed());
    }

    @Then("user can see new created student in bottom of the All Students page")
    public void user_can_see_new_created_student_in_bottom_of_the_All_Students_page() {
        DBUtility.createConnection();
        List<Map<Object, Object>> studentData= DBUtility.executeQuery("SELECT * FROM student where student_id=" +
                myProfileStudentPage.studentIdValue.getText());
        String fullname =   studentData.get(0).get("FIRST_NAME").toString() +
                " " + studentData.get(0).get("LAST_NAME").toString();
        Assert.assertEquals(fullname.trim(), myProfileStudentPage.fullNameValue.getText().trim());

        String admissionNo = studentData.get(0).get("ADMISSION_NO").toString();
        Assert.assertEquals(admissionNo.trim(), myProfileStudentPage.admissionNoValue.getText().trim());


        String birthDate = SeleniumUtils.dateFormat(studentData.get(0).get("BIRTH_DATE").toString());
        Assert.assertEquals(birthDate, myProfileStudentPage.birthdayValue.getText().trim());

        String gender = studentData.get(0).get("GENDER").toString();
        Assert.assertEquals(gender.trim(), myProfileStudentPage.genderValue.getText().trim());


        String joinDate = SeleniumUtils.dateFormat(studentData.get(0).get("JOIN_DATE").toString());
        Assert.assertEquals(joinDate.trim(), myProfileStudentPage.joinDateValue.getText().trim());


        String major = studentData.get(0).get("SECTION").toString();
        Assert.assertEquals(major.trim(), myProfileStudentPage.sectionValue.getText().trim());

        String subject = studentData.get(0).get("SUBJECT").toString();
        Assert.assertEquals(subject.trim(), myProfileStudentPage.subjectValue.getText().trim());

    }



}
