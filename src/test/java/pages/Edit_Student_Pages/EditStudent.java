package pages.Edit_Student_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EditStudent {
    public EditStudent(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//h5")
    public WebElement allStudentsHeaderText;



    @FindBy(xpath = "(//div[@class='dropdown profile-action']/a)[1]")
    public WebElement threeDotsOfStudent;

    @FindBy(xpath = "(//a[.= ' Edit'])[1]")
    public WebElement editButton;

    @FindBy(xpath = "(//a[.= ' Delete'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//h5")
    public WebElement editStudentHeaderText;


    @FindBy(xpath = "//label[.='Firstname']/../input[@type='text']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//label[.='Lastname']/../input[@type='text']")
    public WebElement lastnameInput;

    @FindBy(xpath = "//label[.='Email']/../input[@type='text']")
    public WebElement emailInput;

    @FindBy(xpath = "//label[.='Joining Date']/../input[@type='text']")
    public WebElement joiningDateInput;

    @FindBy(xpath = "//label[.='Password']/../input[@type='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//label[.='Comfirm Password']/../input[@type='password']")
    public WebElement confirmPasswordInput;

    @FindBy(xpath = "//label[.='Subject']/../input[@type='text']")
    public WebElement subjectInput;

    @FindBy(xpath = "//label[.='Mobile number']/../input[@type='number']")
    public WebElement mobileNUmberInput;

    @FindBy(xpath = "//label[.='Gender']/..//select")
    public WebElement genderSelectInput;

    @FindBy(xpath = "//label[.='Admission No']/../input")
    public WebElement admissionNoInput;

    @FindBy(xpath = "//label[.='Birth Date']/..//input[@type='text']")
    public WebElement birthDateInput;

    @FindBy(xpath = "//label[.='Major']/..//input[@type='text']")
    public WebElement majorInput;


    @FindBy(xpath = "//label[.='Batch']/../select")
    public WebElement batchInput;

    @FindBy(xpath = "//label[.='Section']/..//input[@type='text']")
    public WebElement sectionInput;

    @FindBy(id = "message")
    public WebElement permanentAdressInputBox;

    @FindBy(xpath = "(//div[.='Company information'])[4]")
    public WebElement companyInformationHeaderText;

    @FindBy(xpath = "//label[.='Company Name']/..//input[@type='text']")
    public WebElement companyNameInput;

    @FindBy(xpath = "//label[.='Title']/..//input[@type='text']")
    public WebElement titleInput;

    @FindBy(xpath = "//label[.='Start Date']/..//input[@type='text']")
    public WebElement startDateInput;

    @FindBy(xpath = "//label[.='City']/..//input[@type='text']")
    public WebElement cityInput;

    @FindBy(xpath = "//label[.='Street (123 N. California, Apt 1)']/..//input[@type='text']")
    public WebElement streetInput;

    @FindBy(xpath = "//label[.='ZipCode']/..//input[@type='number']")
    public WebElement zipCodeInput;

    @FindBy(xpath = "//label[.='State']/..//input[@type='text']")
    public WebElement stateInput;



    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//button[@type='reset']")
    public WebElement cancelButton;

}
