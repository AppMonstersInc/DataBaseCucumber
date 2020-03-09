package pages;

import cucumber.api.java.mk_latn.No;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyProfileStudentPage {

    public MyProfileStudentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//h5[.='Cybertek School']/preceding-sibling::h3")
    public WebElement fullNameValue;

    @FindBy(xpath = "(//div[@class='profile-info-left']//li)[1]//a")
    public WebElement studentIdValue;

    @FindBy(xpath = "(//div[@class='profile-info-left']//li)[2]//a")
    public WebElement phoneValue;

    @FindBy(xpath = "(//div[@class='profile-info-left']//li)[3]//a")
    public WebElement emailValue;

    @FindBy(xpath = "(//ul[@class='personal-info']/li)[4]//span[2]")
    public WebElement addressValue;

    @FindBy(xpath = "(//ul[@class='personal-info']/li)[5]//span[2]")
    public WebElement joinDateValue;

    @FindBy(xpath = "(//ul[@class='personal-info']/li)[6]//span[2]")
    public WebElement admissionNoValue;

    @FindBy(xpath = "(//ul[@class='personal-info']/li)[7]//span[2]")
    public WebElement CompanyNameValue;

    @FindBy(xpath = "(//ul[@class='personal-info']/li)[8]//span[2]")
    public WebElement titleValue;

    @FindBy(xpath = "(//ul[@class='personal-info']/li)[9]//span[2]")
    public WebElement birthdayValue;

    @FindBy(xpath = "(//ul[@class='personal-info']/li)[10]//span[2]")
    public WebElement startDateValue;

    @FindBy(xpath = "(//ul[@class='personal-info']/li)[11]//span[2]")
    public WebElement companyAddressValue;

    @FindBy(xpath = "(//ul[@class='personal-info']/li)[12]//span[2]")
    public WebElement stateZipCodeValue;

    @FindBy(xpath = "(//ul[@class='personal-info']/li)[13]//span[2]")
    public WebElement genderValue;

    @FindBy(xpath = "(//ul[@class='personal-info']/li)[14]//span[2]")
    public WebElement sectionValue;

    @FindBy(xpath = "(//ul[@class='personal-info']/li)[15]//span[2]")
    public WebElement subjectValue;




}
