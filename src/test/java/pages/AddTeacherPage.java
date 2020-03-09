package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AddTeacherPage {

    public AddTeacherPage(){PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[contains(text(),'Add Teacher')])[1]")
    public WebElement addTeacherButton;

    @FindBy(xpath = "//span[.=' Teachers']")
    public WebElement teachersButton;

    @FindBy(xpath = "//label[.='Firstname']//preceding-sibling::input")
    public WebElement firstNameInput;

    @FindBy(xpath = "//label[.='Lastname']/..//input")
    public WebElement lastNameInput;

    @FindBy(xpath = "//label[.='Email']//preceding-sibling::input")
    public WebElement emailInput;

    @FindBy(xpath = "//label[.='Joining Date']/..//input")
    public WebElement joinDateInputBox;

    @FindBy(xpath = "//label[.='Password']/..//input")
    public WebElement passwordInput;

    @FindBy(xpath = "//label[.='Confirm Password']/..//input")
    public WebElement confirmPasswordInput;

    @FindBy(xpath = "//label[.='Subject']/..//input")
    public WebElement subjectInputBox;

    @FindBy(xpath = "//label[.='Mobile number']//preceding-sibling::input")
    public WebElement mobileNumberInput;

    @FindBy(xpath = "//label[.='Birth Date']//preceding-sibling::input")
    public WebElement birthDateInputBox;

    @FindBy(xpath = "//select//option[.='Male']/..")
    public WebElement genderButton;

    @FindBy(xpath = "//select//option[.='Male'] ")
    public WebElement maleButton;

    @FindBy(xpath = "//select//option[.='Female'] ")
    public WebElement femaleButton;

    @FindBy(xpath = "//label[.='Salary']/..//input ")
    public WebElement salaryInputBox;

    @FindBy(xpath = "//select//option[.='1']/..")
    public WebElement batchButton;

    @FindBy(xpath = "//label[.='Section']//preceding-sibling::input")
    public WebElement sectionInputBox;

    @FindBy(xpath = "//textarea[@id='message']")
    public WebElement permanentAddressInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//h5[.='add teacher']")
    public WebElement addTeacherHeader;

    @FindBy(xpath = "//label[.='Department']/..//select")
    public WebElement departmentInputBox;

    @FindBy(xpath = "//select//option[.='Science']")
    public WebElement scienceButton;

    @FindBy(xpath = "//select//option[.='12'] ")
    public WebElement batch12Button;

    @FindBy(xpath = "//div[@class='profile-widget']/h4//a")
    public List<WebElement> listOfTeachers;

}
