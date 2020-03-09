package step_definitions.teacher_create_step_defs;

import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.AddTeacherPage;
import pages.NewTecherProfilePage;
import utilities.DBUtility;
import utilities.Driver;
import utilities.SeleniumUtils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Teacher_Create_Step_Defs {
    AddTeacherPage addTeacherPage = new AddTeacherPage();
    NewTecherProfilePage newTecherProfilePage = new NewTecherProfilePage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    LocalDate today = LocalDate.now();
    String formattedDate = today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
    String subject = faker.educator().course();
    String phoneNumber = faker.phoneNumber().cellPhone().replace("-","").replace(".","");
    String salary = faker.number().digits(6);
    String address = faker.address().fullAddress();
    List<Map<Object,Object>> mydata;
    String departmentCheck;
    String inputEmail = faker.pokemon().name();




    @Given("I verify if Teachers button is displayed on the left side of the main page")
    public void i_verify_if_Teachers_button_is_displayed_on_the_left_side_of_the_main_page() {
        Assert.assertTrue("Teachers button is not displayed!!! FAILED!!!", addTeacherPage.teachersButton.isDisplayed());
    }

    @When("I click on teachers button")
    public void i_click_on_teachers_button() {
        addTeacherPage.teachersButton.click();
        SeleniumUtils.pause(1);
    }

    @When("I verify if Add Teacher button is displayed")
    public void i_verify_if_Add_Teacher_button_is_displayed() {
        Assert.assertTrue("Add Teacher button is NOT displayed!!! FAILED!!!", addTeacherPage.addTeacherButton.isDisplayed());
    }

    @When("I click on Add Teacher button")
    public void i_click_on_Add_Teacher_button() {
        addTeacherPage.addTeacherButton.click();
    }

    @When("I should be navigated to Add Teacher page")
    public void i_should_be_navigated_to_Add_Teacher_page() {
        Assert.assertTrue("Add teacher header is not displayed!!! FAILED",addTeacherPage.addTeacherHeader.isDisplayed());

    }

    @When("I fill out all information about new Teacher")
    public void i_fill_out_all_information_about_new_Teacher() {
        addTeacherPage.firstNameInput.click();
        SeleniumUtils.pause(2);
        addTeacherPage.firstNameInput.sendKeys(firstName);
        SeleniumUtils.pause(2);
        addTeacherPage.lastNameInput.click();
        addTeacherPage.lastNameInput.sendKeys(lastName);
        addTeacherPage.emailInput.sendKeys(inputEmail);
        addTeacherPage.joinDateInputBox.sendKeys(formattedDate+"20");
        addTeacherPage.passwordInput.sendKeys("Test1");
        addTeacherPage.confirmPasswordInput.sendKeys("Test1");
        addTeacherPage.subjectInputBox.sendKeys(subject);
        addTeacherPage.mobileNumberInput.sendKeys(phoneNumber);
        addTeacherPage.genderButton.click();
        Select select = new Select(addTeacherPage.genderButton);
        Random random = new Random(1);
        int gen = random.nextInt(2);
        select.selectByIndex(gen);
        Select depSelect = new Select(addTeacherPage.departmentInputBox);
        int dep = random.nextInt(5);
        depSelect.selectByIndex(dep);
        dep+=1;
        WebElement tempDep = Driver.getDriver().findElement(By.xpath("(//label[.='Department']/..//select//option)["+ dep +"]"));
        departmentCheck = tempDep.getText();
        addTeacherPage.birthDateInputBox.sendKeys("04/15/1984");
        addTeacherPage.salaryInputBox.click();
        addTeacherPage.salaryInputBox.clear();
        addTeacherPage.salaryInputBox.sendKeys(salary);
        addTeacherPage.batchButton.click();
        addTeacherPage.batch12Button.click();
        addTeacherPage.sectionInputBox.sendKeys(faker.job().field());
        addTeacherPage.permanentAddressInputBox.sendKeys(address);
    }

    @When("I click on submit button")
    public void i_click_on_submit_button() {
     addTeacherPage.submitButton.click();

    }

    @Then("I verify if new teacher information is matching to database")
    public void i_verify_if_new_teacher_information_is_matching_to_database() {
        DBUtility.createConnection();
        List <WebElement> teachersList = addTeacherPage.listOfTeachers;
        List <WebElement> departmentsList = addTeacherPage.listOfTeachersDepartment;
        int indexOfTeacherList = 0;
        boolean nameAndDepartmentVerification = false;
        for(int i = teachersList.size()-1; i >= 0; i--){
            WebElement firstNameCheck = teachersList.get(i);
            WebElement webElementDepartment = departmentsList.get(i);
            if(firstNameCheck.getText().equals(firstName) && webElementDepartment.getText().equals(departmentCheck)){
                indexOfTeacherList = i;
                nameAndDepartmentVerification = true;
                break;
            }
        }
        Assert.assertTrue("New created teacher was NOT found in the list. FAILED!!!",nameAndDepartmentVerification);
        WebElement webElementNewTeacher = teachersList.get(indexOfTeacherList);
        webElementNewTeacher.click();
        SeleniumUtils.pause(2);
        String uiId = newTecherProfilePage.id.getText();
        mydata = DBUtility.executeQuery("select * from teacher where teacher_id = " + uiId);
        Assert.assertTrue("Database data is not matching to UI data! FAIL!",uiId.equals(mydata.get(0).get("TEACHER_ID").toString()));
        String uiFirstAndLastName = newTecherProfilePage.firstAndLastName.getText();
        String dbFirstAndLastName = mydata.get(0).get("FIRST_NAME").toString()+" " + mydata.get(0).get("LAST_NAME").toString();
        Assert.assertTrue("First and Last names are not matching in UI and DB",uiFirstAndLastName.equals(dbFirstAndLastName));
        String uiPhoneNum = newTecherProfilePage.phoneNumber.getText();
        String dbPhoneNum = mydata.get(0).get("PHONE").toString();
        Assert.assertTrue("Phone number is not matching in UI and DB",uiPhoneNum.equals(dbPhoneNum));
        String uiJoinDate = newTecherProfilePage.joinDate.getText();
        String dbJoinDate = SeleniumUtils.dateFormat(mydata.get(0).get("JOIN_DATE").toString());
        Assert.assertTrue("Join date is not matching in UI and DB",uiJoinDate.equals(dbJoinDate));
        String uiEmail = newTecherProfilePage.email.getText();
        String dbEmail = mydata.get(0).get("EMAIL_ADDRESS").toString();
        Assert.assertTrue("Email is not matching in UI and DB",uiEmail.equals(dbEmail) && uiEmail.equals(inputEmail) && dbEmail.equals(inputEmail));
        String uiAddress = newTecherProfilePage.permanentAddress.getText();
        String dbAddress = mydata.get(0).get("PREMANENT_ADDRESS").toString();
        Assert.assertTrue("Permanent address is not matching in UI and DB",uiAddress.equals(dbAddress));
        String uiBirthDate = newTecherProfilePage.birthDate.getText();
        String dbBirthDate = SeleniumUtils.dateFormat(mydata.get(0).get("BIRTH_DATE").toString());
        Assert.assertTrue("Birth date is not matching in UI and DB",uiBirthDate.equals(dbBirthDate));
        String uiSalary = newTecherProfilePage.salary.getText();
        String dbSalary = mydata.get(0).get("SALARY").toString();
        Assert.assertTrue("Salary is not matching in UI and DB",uiSalary.equals(dbSalary));
        String uiGender = newTecherProfilePage.gender.getText();
        String dbGender = mydata.get(0).get("GENDER").toString();
        Assert.assertTrue("Gender is not matching in UI and DB",uiGender.equals(dbGender));
        String uiBatchNum = newTecherProfilePage.batchNumber.getText();
        String dbBatchNum = mydata.get(0).get("BATCH").toString();
        Assert.assertTrue("Batch is not matching in UI and DB",uiBatchNum.equals(dbBatchNum));
        String uiSection = newTecherProfilePage.section.getText();
        String dbSection = mydata.get(0).get("SECTION").toString();
        Assert.assertTrue("Section is not matching in UI and DB",uiSection.equals(dbSection));
        String uiSubject = newTecherProfilePage.subject.getText();
        String dbSubject = mydata.get(0).get("SUBJECT").toString();
        Assert.assertTrue("Subject is not matching in UI and DB",uiSubject.equals(dbSubject));
    }





}
