package step_definitions.students_steps;

import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import pages.AddStudentPage;
import pages.AllStudentsPage;
import pages.MainPage;
import pages.MyProfileStudentPage;
import utilities.Config;
import utilities.DBUtility;
import utilities.Driver;
import utilities.SeleniumUtils;
import java.text.ParseException;
import java.util.*;

public class createStudent_steps {

    MainPage mainPage = new MainPage();
    AddStudentPage addStudentPage = new AddStudentPage();
    AllStudentsPage allStudentsPage = new AllStudentsPage();
    MyProfileStudentPage myProfileStudentPage = new MyProfileStudentPage();
    Faker faker = new Faker();
    String subject = faker.educator().course();
    Map<String, String> data = new HashMap<>();
    List<Map<Object, Object>> mydata;


    @Given("As a User I am in the main menu page")
    public void as_a_User_I_am_in_the_main_menu_page() {
        Driver.getDriver().get(Config.getProperty("cybertekURL"));
    }

    @Given("I click to Students button")
    public void i_click_to_Students_button() {
        mainPage.studentsButton.click();
        SeleniumUtils.pause(1);
    }

    @Then("I should see two buttons All Students and Add Students")
    public void i_should_see_two_buttons_All_Students_and_Add_Students() {
        Assert.assertTrue("The ADD student buttons is not displayed", addStudentPage.addStudentsButton.isDisplayed());
        Assert.assertTrue("The buttons is not displayed", allStudentsPage.allStudentsButton.isDisplayed());
    }


    @When("I click add student from students functionality")
    public void i_click_add_student_from_students_functionality() {
        addStudentPage.addStudentsButton.click();
    }


    @When("I navigated to add student page")
    public void i_navigated_to_add_student_page() {
        SeleniumUtils.waitForVisibility(addStudentPage.addStudentsHeader, 3);
        Assert.assertTrue("The add student header is not found", addStudentPage.addStudentsHeader.getText().equalsIgnoreCase("ADD STUDENT"));
    }

    @When("I fill out all information about new student")
    public void i_fill_out_all_information_about_new_student() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        data.put("FIRST_NAME", firstName);
        data.put("LAST_NAME", lastName);
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com";
        int password = faker.number().numberBetween(123, 300);
        String joinDate = "11/22/2013";
        String mobileNumber = faker.phoneNumber().cellPhone().replace("-", "").replace(".", "");
        SeleniumUtils.pause(1);
        addStudentPage.firstNameInputBox.sendKeys(firstName);
        SeleniumUtils.pause(1);
        addStudentPage.lastNameInputBox.click();
        addStudentPage.lastNameInputBox.sendKeys(lastName);
        SeleniumUtils.pause(1);
        addStudentPage.emailInputBox.sendKeys(email);
        SeleniumUtils.pause(1);
        addStudentPage.passwordInputBox.sendKeys(password + "");
        SeleniumUtils.pause(1);
        addStudentPage.confirmPasswordInputBox.sendKeys(password + "");
        SeleniumUtils.pause(1);
        addStudentPage.joiningDateInputBox.click();
        addStudentPage.joiningDateInputBox.sendKeys(joinDate);
        SeleniumUtils.pause(1);
        addStudentPage.subjectInputBox.sendKeys(subject);
        addStudentPage.mobileNumberInputBox.sendKeys(mobileNumber);
        Select select = new Select(addStudentPage.genderSelectBox);
        select.selectByIndex(faker.number().numberBetween(1, 2));
        addStudentPage.admissionNoInputBox.clear();
        addStudentPage.admissionNoInputBox.sendKeys("125");
        SeleniumUtils.pause(1);
        addStudentPage.birthDayInputBox.sendKeys("11/22/1991");
        SeleniumUtils.pause(1);
        addStudentPage.majorInputBox.sendKeys(faker.number().digit());
        Select select2 = new Select(addStudentPage.batchSelectBox);
        select2.selectByIndex(2);
        addStudentPage.sectionInputBox.clear();
        addStudentPage.sectionInputBox.sendKeys(faker.number().digit());
        addStudentPage.premanentAddressInputBox.sendKeys(faker.address().fullAddress());
        addStudentPage.companyNameInputBox.sendKeys(faker.company().name());
        addStudentPage.startDayInputBox.sendKeys("11/22/2020");
        addStudentPage.streetInputBox.sendKeys("123 N. California, Apt 1");
        addStudentPage.stateInputBox.sendKeys(faker.address().state());
        addStudentPage.titleInputBox.sendKeys(faker.team().name());
        addStudentPage.cityInputBox.sendKeys(faker.address().city());
        addStudentPage.zipCodeInputBox.sendKeys(faker.address().zipCode().replace("-", ""));
    }

    @When("I click submit button")
    public void i_click_submit_button() {
        addStudentPage.submitButton.click();
    }

    @Then("It should see new student in the All students table")
    public void it_should_see_new_student_in_the_All_students_table() {
        Assert.assertTrue("You are not in all student page", allStudentsPage.allStudentsHeader.isDisplayed());
        List<WebElement> list = allStudentsPage.allStudentsNames;
        Assert.assertTrue("The student was not created", list.get(list.size() - 1).getText().equalsIgnoreCase(data.get("FIRST_NAME")));

    }

    @And("Click on the student that was just created")
    public void click_on_the_student_that_was_just_created() {
        List<WebElement> list = allStudentsPage.allStudentsNames;
        WebElement lastStudent = list.get(list.size() - 1);
        lastStudent.click();
    }


    @Then("Verify if full name of new student matching in data base")
    public void verify_if_full_name_of_new_student_matching_in_data_base() {
        DBUtility.createConnection();
        mydata = DBUtility.executeQuery("select FIRST_NAME,LAST_NAME from student where student_id=" + Driver.getDriver().findElement(By.xpath("(//div[@class='profile-info-left']//li)[1]//a")).getText());
        String fullName = mydata.get(0).get("FIRST_NAME").toString() + " " + mydata.get(0).get("LAST_NAME").toString();
        Assert.assertTrue("Student full name did not find in data base", fullName.equalsIgnoreCase(myProfileStudentPage.fullNameValue.getText().trim()));

    }


    @Then("Verify student join date is matching in data base")
    public void verify_student_join_date_is_matching_in_data_base() throws ParseException {
        DBUtility.createConnection();
        mydata = DBUtility.executeQuery("select JOIN_DATE from student where student_id=" + myProfileStudentPage.studentIdValue.getText());
        String joinDate = mydata.get(0).get("JOIN_DATE").toString();
        joinDate = SeleniumUtils.dateFormat(joinDate);
        Assert.assertTrue("Join date is not matching in data base", joinDate.equalsIgnoreCase(myProfileStudentPage.joinDateValue.getText().trim()));

    }

    @Then("verify student admission number is matching in data base")
    public void verify_student_admission_number_is_matching_in_data_base() {
        DBUtility.createConnection();
        mydata = DBUtility.executeQuery("SELECT ADMISSION_NO FROM student where student_id=" + myProfileStudentPage.studentIdValue.getText());
        String admission_no = mydata.get(0).get("ADMISSION_NO").toString();
        System.out.println(admission_no);
        System.out.println(myProfileStudentPage.admissionNoValue.getText());
        Assert.assertTrue("Admission value does not match", admission_no.equalsIgnoreCase(myProfileStudentPage.admissionNoValue.getText()));

    }



    @Then("Verify student birthday and start date matching in data base")
    public void verify_student_birthday_and_start_date_matching_in_data_base() {
        DBUtility.createConnection();
        mydata = DBUtility.executeQuery("SELECT BIRTH_DATE from student where student_id=" + myProfileStudentPage.studentIdValue.getText());
        String birthday = mydata.get(0).get("BIRTH_DATE").toString();
        birthday=SeleniumUtils.dateFormat(birthday);
        Assert.assertTrue(birthday.equalsIgnoreCase(myProfileStudentPage.birthdayValue.getText().trim()));
    }




    @Then("Verify student gender is matching in data base")
    public void verify_student_gender_is_matching_in_data_base() {
        DBUtility.createConnection();
        mydata = DBUtility.executeQuery("SELECT GENDER from student where student_id=" + myProfileStudentPage.studentIdValue.getText());
        String gender = mydata.get(0).get("GENDER").toString();
        Assert.assertTrue(gender.equalsIgnoreCase(myProfileStudentPage.genderValue.getText().trim()));
    }

    @Then("Verify student section is matching in data base")
    public void verify_student_section_is_matching_in_data_base() {
        DBUtility.createConnection();
        mydata = DBUtility.executeQuery("SELECT SECTION from student where student_id=" + myProfileStudentPage.studentIdValue.getText());
        String section = mydata.get(0).get("SECTION").toString();
        Assert.assertTrue(section.equalsIgnoreCase(myProfileStudentPage.sectionValue.getText().trim()));
    }

    @Then("Verify student subject is matching in data base")
    public void verify_student_subject_is_matching_in_data_base() {

        DBUtility.createConnection();
        mydata = DBUtility.executeQuery("SELECT SUBJECT from student where student_id=" + myProfileStudentPage.studentIdValue.getText());
        String subject = mydata.get(0).get("SUBJECT").toString();
        Assert.assertTrue(subject.equalsIgnoreCase(myProfileStudentPage.subjectValue.getText().trim()));
    }


}
