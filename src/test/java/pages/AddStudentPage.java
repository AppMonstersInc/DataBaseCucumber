package pages;

import com.github.javafaker.Company;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AddStudentPage {
    public AddStudentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@class='col-lg-7 col-md-12 col-sm-12 col-12']")
    public WebElement addStudentsHeader;

    @FindBy(xpath = "//*[contains(text(),'Add Student')]")
    public WebElement addStudentsButton;

    @FindBy(xpath = "//label[.='Firstname']//preceding-sibling::input")
    public WebElement firstNameInputBox;

    @FindBy(xpath = "//label[.='Email']/preceding-sibling::input")
    public WebElement emailInputBox;

    @FindBy(xpath = "//label[.='Password']/preceding-sibling::input")
    public WebElement passwordInputBox;

    @FindBy(xpath = " //label[.='Subject']/preceding-sibling::input")
    public WebElement subjectInputBox;

    @FindBy(xpath = "//label[.='Gender']/preceding-sibling::select")
    public WebElement genderSelectBox;

    @FindBy(xpath = "//label[.='Birth Date']/preceding-sibling::input")
    public WebElement birthDayInputBox;

    @FindBy(xpath = " //label[.='Batch']/preceding-sibling::select")
    public WebElement batchSelectBox;

    @FindBy(id = "message")
    public WebElement premanentAddressInputBox;

    @FindBy(xpath = "//label[.='Lastname']/preceding-sibling::input")
    public WebElement lastNameInputBox;

    @FindBy(xpath = "//label[.='Joining Date']/preceding-sibling::input")
    public WebElement joiningDateInputBox;

    @FindBy(xpath = " //label[.='Comfirm Password']/preceding-sibling::input")
    public WebElement confirmPasswordInputBox;

    @FindBy(xpath = "//label[.='Mobile number']/preceding-sibling::input")
    public WebElement mobileNumberInputBox;

    @FindBy(xpath = "//label[.='Admission No']/preceding-sibling::input")
    public WebElement admissionNoInputBox;

    @FindBy(xpath = "//label[.='Major']/preceding-sibling::input")
    public WebElement majorInputBox;

    @FindBy(xpath = "//label[.='Section']/preceding-sibling::input")
    public WebElement sectionInputBox;

   // Company Information

    @FindBy(xpath = "//label[.='Company Name']/preceding-sibling::input")
    public WebElement companyNameInputBox;

    @FindBy(xpath = "//label[.='Start Date']/preceding-sibling::input")
    public WebElement startDayInputBox;

    @FindBy(xpath = "//label[.='Street (123 N. California, Apt 1)']/preceding-sibling::input")
    public WebElement streetInputBox;

    @FindBy(xpath = "//label[.='State']/preceding-sibling::input")
    public WebElement stateInputBox;

    @FindBy(xpath = "//label[.='Title']/preceding-sibling::input")
    public WebElement titleInputBox;

    @FindBy(xpath = "//label[.='City']/preceding-sibling::input")
    public WebElement cityInputBox;

    @FindBy(xpath = "//label[.='ZipCode']/preceding-sibling::input")
    public WebElement zipCodeInputBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@type='reset']")
    public WebElement cancelButton;






}
