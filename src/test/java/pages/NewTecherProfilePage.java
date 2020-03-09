package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class NewTecherProfilePage {
    public NewTecherProfilePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//ul//li//span//a)[1]")
    public WebElement id;

    @FindBy(xpath = "(//ul//li//span//a)[2]")
    public WebElement phoneNumber;

    @FindBy(xpath = "(//ul//li//span//a)[3]")
    public WebElement email;


    @FindBy(xpath = "(//ul//li//span//a)[4]")
    public WebElement batchNumber;

    @FindBy(xpath = "//div[@class='profile-info-left']//h3")
    public WebElement firstAndLastName;

    @FindBy (xpath = "((//ul[@class='personal-info'])[2]//li//span/following-sibling::span)[1]")
    public WebElement birthDate;

    @FindBy (xpath = "((//ul[@class='personal-info'])[2]//li//span/following-sibling::span)[2]")
    public WebElement joinDate;

    @FindBy (xpath = "((//ul[@class='personal-info'])[2]//li//span/following-sibling::span)[3]")
    public WebElement permanentAddress;

    @FindBy (xpath = "((//ul[@class='personal-info'])[2]//li//span/following-sibling::span)[4]")
    public WebElement gender;

    @FindBy (xpath = "((//ul[@class='personal-info'])[2]//li//span/following-sibling::span)[5]")
    public WebElement salary;

    @FindBy (xpath = "((//ul[@class='personal-info'])[2]//li//span/following-sibling::span)[6]")
    public WebElement section;

    @FindBy (xpath = "((//ul[@class='personal-info'])[2]//li//span/following-sibling::span)[7]")
    public WebElement subject;














}
