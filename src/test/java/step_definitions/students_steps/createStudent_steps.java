package step_definitions.students_steps;

import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import pages.AddStudentPage;
import pages.AllStudentsPage;
import pages.MainPage;
import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.LocalDateTime;
import java.util.List;

public class createStudent_steps {

    MainPage mainPage = new MainPage();
    AddStudentPage addStudentPage = new AddStudentPage();
    AllStudentsPage allStudentsPage = new AllStudentsPage();
    Faker faker = new Faker();
    String subject = faker.educator().course();

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
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com";
        int password = faker.number().numberBetween(123, 300);
        String joinDate = "11/22/2013";
        String mobileNumber = faker.phoneNumber().cellPhone().replace("-","").replace(".","");
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
        addStudentPage.confirmPasswordInputBox.sendKeys(password+"");
        SeleniumUtils.pause(1);
        addStudentPage.joiningDateInputBox.click();
        addStudentPage.joiningDateInputBox.sendKeys(joinDate);
        SeleniumUtils.pause(1);
        addStudentPage.subjectInputBox.sendKeys(subject);
        addStudentPage.mobileNumberInputBox.sendKeys(mobileNumber);
        Select select = new Select( addStudentPage.genderSelectBox);
        select.selectByIndex(faker.number().numberBetween(1,2));
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
        addStudentPage.zipCodeInputBox.sendKeys(faker.address().zipCode().replace("-",""));
    }

    @When("I click submit button")
    public void i_click_submit_button() {
        addStudentPage.submitButton.click();
    }

    @Then("It should see new student in the All students table")
    public void it_should_see_new_student_in_the_All_students_table() {
       Assert.assertTrue("You are not in all student page",allStudentsPage.allStudentsHeader.isDisplayed());
       List<WebElement> list = Driver.getDriver().findElements(By.xpath("//*[contains(text(),'All Students')]"));


    }


}
