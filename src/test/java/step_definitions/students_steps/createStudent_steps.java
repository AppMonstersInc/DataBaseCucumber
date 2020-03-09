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
import utilities.*;

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
        Log.info("User on "+Config.getProperty("cybertekURL"));
    }


    @Given("I click to Students button")
    public void i_click_to_Students_button() {
        mainPage.studentsButton.click();
        Log.info("User is clicking on students button");
        SeleniumUtils.pause(1);
    }

    @Then("I should see two buttons All Students and Add Students")
    public void i_should_see_two_buttons_All_Students_and_Add_Students() {
        Log.warn("Add student buttons verification");
        Assert.assertTrue("The ADD student buttons is not displayed", addStudentPage.addStudentsButton.isDisplayed());
        Log.warn("All student buttons verifications");
        Assert.assertTrue("The buttons is not displayed", allStudentsPage.allStudentsButton.isDisplayed());
    }


    @When("I click add student from students functionality")
    public void i_click_add_student_from_students_functionality() {
        Log.info("Click Add student button");
        addStudentPage.addStudentsButton.click();
    }


    @When("I navigated to add student page")
    public void i_navigated_to_add_student_page() {
        Log.info("Wait for visibility of add student header");
        SeleniumUtils.waitForVisibility(addStudentPage.addStudentsHeader, 3);
        Log.warn("Add Header verification");
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
        Log.info("");

        Log.info("User is entering first name");
        addStudentPage.firstNameInputBox.sendKeys(firstName);
        SeleniumUtils.pause(1);
        Log.info("User is entering last name");
        addStudentPage.lastNameInputBox.click();
        addStudentPage.lastNameInputBox.sendKeys(lastName);
        SeleniumUtils.pause(1);

        Log.info("User is entering email number");
        addStudentPage.emailInputBox.sendKeys(email);
        SeleniumUtils.pause(1);
        Log.info("User is entering password");
        addStudentPage.passwordInputBox.sendKeys(password + "");
        SeleniumUtils.pause(1);
        Log.info("User is entering confirm password");
        addStudentPage.confirmPasswordInputBox.sendKeys(password + "");
        SeleniumUtils.pause(1);
        Log.info("User is entering join date");
        addStudentPage.joiningDateInputBox.click();
        addStudentPage.joiningDateInputBox.sendKeys(joinDate);
        SeleniumUtils.pause(1);
        Log.info("User is entering subject ");
        addStudentPage.subjectInputBox.sendKeys(subject);
        Log.info("User is entering mobile number");
        addStudentPage.mobileNumberInputBox.sendKeys(mobileNumber);
        Log.info("User select gender");
        Select select = new Select(addStudentPage.genderSelectBox);
        select.selectByIndex(faker.number().numberBetween(1, 2));
        Log.info("User is entering admission number ");
        addStudentPage.admissionNoInputBox.clear();
        addStudentPage.admissionNoInputBox.sendKeys("125");
        SeleniumUtils.pause(1);
        Log.info("User is entering birthday ");
        addStudentPage.birthDayInputBox.sendKeys("11/22/1991");
        SeleniumUtils.pause(1);
        Log.info("User is entering major ");
        addStudentPage.majorInputBox.sendKeys(faker.number().digit());
        Log.info("User select the Batch");
        Select select2 = new Select(addStudentPage.batchSelectBox);
        select2.selectByIndex(2);
        addStudentPage.sectionInputBox.clear();
        Log.info("User is entering section ");
        addStudentPage.sectionInputBox.sendKeys(faker.number().digit());
        Log.info("User is entering permanent Address ");
        addStudentPage.premanentAddressInputBox.sendKeys(faker.address().fullAddress());
        Log.info("User is entering company name ");
        addStudentPage.companyNameInputBox.sendKeys(faker.company().name());
        Log.info("User is entering start day ");
        addStudentPage.startDayInputBox.sendKeys("11/22/2020");
        Log.info("User is entering street ");
        addStudentPage.streetInputBox.sendKeys("123 N. California, Apt 1");
        Log.info("User is entering state ");
        addStudentPage.stateInputBox.sendKeys(faker.address().state());
        Log.info("User is entering title");
        addStudentPage.titleInputBox.sendKeys(faker.team().name());
        Log.info("User is entering city ");
        addStudentPage.cityInputBox.sendKeys(faker.address().city());
        Log.info("User is entering zipCode ");
        addStudentPage.zipCodeInputBox.sendKeys(faker.address().zipCode().replace("-", ""));
    }

    @When("I click submit button")
    public void i_click_submit_button() {
        Log.info("User click submit button");
        addStudentPage.submitButton.click();
    }

    @Then("It should see new student in the All students table")
    public void it_should_see_new_student_in_the_All_students_table() {
        Log.warn("All student header verification");
        Assert.assertTrue("You are not in all student page", allStudentsPage.allStudentsHeader.isDisplayed());
        List<WebElement> list = allStudentsPage.allStudentsNames;
        Log.warn("Creating student");
        Assert.assertTrue("The student was not created", list.get(list.size() - 1).getText().equalsIgnoreCase(data.get("FIRST_NAME")));

    }

    @And("Click on the student that was just created")
    public void click_on_the_student_that_was_just_created() {

        List<WebElement> list = allStudentsPage.allStudentsNames;
        WebElement lastStudent = list.get(list.size() - 1);
        Log.info("Click on student that was created");
        lastStudent.click();
    }


    @Then("Verify if full name of new student matching in data base")
    public void verify_if_full_name_of_new_student_matching_in_data_base() {
        DBUtility.createConnection();
        mydata = DBUtility.executeQuery("select FIRST_NAME,LAST_NAME from student where student_id=" + Driver.getDriver().findElement(By.xpath("(//div[@class='profile-info-left']//li)[1]//a")).getText());
        String fullName = mydata.get(0).get("FIRST_NAME").toString() + " " + mydata.get(0).get("LAST_NAME").toString();
        Log.warn("Full name verification in data base");
        Assert.assertTrue("Student full name did not find in data base", fullName.equalsIgnoreCase(myProfileStudentPage.fullNameValue.getText().trim()));

    }


    @Then("Verify student join date is matching in data base")
    public void verify_student_join_date_is_matching_in_data_base() throws ParseException {
        DBUtility.createConnection();
        mydata = DBUtility.executeQuery("select JOIN_DATE from student where student_id=" + myProfileStudentPage.studentIdValue.getText());
        String joinDate = mydata.get(0).get("JOIN_DATE").toString();
        Log.info("Data base join date convert to UI format");
        joinDate = SeleniumUtils.dateFormat(joinDate);
        Log.warn("Join date verification with data base");
        Assert.assertTrue("Join date is not matching in data base", joinDate.equalsIgnoreCase(myProfileStudentPage.joinDateValue.getText().trim()));

    }

    @Then("verify student admission number is matching in data base")
    public void verify_student_admission_number_is_matching_in_data_base() {
        DBUtility.createConnection();
        mydata = DBUtility.executeQuery("SELECT ADMISSION_NO FROM student where student_id=" + myProfileStudentPage.studentIdValue.getText());
        String admission_no = mydata.get(0).get("ADMISSION_NO").toString();
        Log.warn("Admission value verification with data base");
        System.out.println(myProfileStudentPage.admissionNoValue.getText());
        Assert.assertTrue("Admission value does not match", admission_no.equalsIgnoreCase(myProfileStudentPage.admissionNoValue.getText()));

    }



    @Then("Verify student birthday and start date matching in data base")
    public void verify_student_birthday_and_start_date_matching_in_data_base() {
        DBUtility.createConnection();
        mydata = DBUtility.executeQuery("SELECT BIRTH_DATE from student where student_id=" + myProfileStudentPage.studentIdValue.getText());
        String birthday = mydata.get(0).get("BIRTH_DATE").toString();
        birthday=SeleniumUtils.dateFormat(birthday);
        Log.warn("Birthday verification with data base");
        Assert.assertTrue(birthday.equalsIgnoreCase(myProfileStudentPage.birthdayValue.getText().trim()));
    }




    @Then("Verify student gender is matching in data base")
    public void verify_student_gender_is_matching_in_data_base() {
        DBUtility.createConnection();
        mydata = DBUtility.executeQuery("SELECT GENDER from student where student_id=" + myProfileStudentPage.studentIdValue.getText());
        String gender = mydata.get(0).get("GENDER").toString();
        Log.warn("Birthday verification with data base");
        Assert.assertTrue(gender.equalsIgnoreCase(myProfileStudentPage.genderValue.getText().trim()));
    }

    @Then("Verify student section is matching in data base")
    public void verify_student_section_is_matching_in_data_base() {
        DBUtility.createConnection();
        mydata = DBUtility.executeQuery("SELECT SECTION from student where student_id=" + myProfileStudentPage.studentIdValue.getText());
        String section = mydata.get(0).get("SECTION").toString();
        Log.warn("Section verification with data base");
        Assert.assertTrue(section.equalsIgnoreCase(myProfileStudentPage.sectionValue.getText().trim()));
    }

    @Then("Verify student subject is matching in data base")
    public void verify_student_subject_is_matching_in_data_base() {

        DBUtility.createConnection();
        mydata = DBUtility.executeQuery("SELECT SUBJECT from student where student_id=" + myProfileStudentPage.studentIdValue.getText());
        String subject = mydata.get(0).get("SUBJECT").toString();
        Log.warn("Subject verification with data base");
        Assert.assertTrue(subject.equalsIgnoreCase(myProfileStudentPage.subjectValue.getText().trim()));
    }


}
