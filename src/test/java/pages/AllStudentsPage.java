package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AllStudentsPage {
    public AllStudentsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//*[contains(text(),'All Students')]")
    public WebElement allStudentsButton;

    @FindBy(xpath = "//*[@class='profile-widget']")
    public List<WebElement> allStudents;

    @FindBy(xpath = "//*[@class='col-lg-7 col-md-12 col-sm-12 col-12']")
    public WebElement allStudentsHeader;

    @FindBy(xpath = "//div[@class='profile-widget']//h4/a")
    public List<WebElement> allStudentsNames;


    @FindBy(xpath = "//a[@class='action-icon dropdown-toggle']")
    public List<WebElement> allStudentsThreeDots;

    @FindBy(xpath = "//a[.=' Edit']")
    public List<WebElement> allStudentsEdit;

    @FindBy(xpath = "//*[@class='content-page']")
    public List<WebElement> allStudentList;

    @FindBy(xpath = "(//a[@data-toggle='dropdown'])[4]")
    public WebElement threedot;

    @FindBy (xpath = "//div[@class='dropdown profile-action show']//div")
    public WebElement dropdownStudent;

    @FindBy(xpath = "//div[@class='dropdown profile-action show']//div//a[2]")
    public WebElement deleteButtonStudent;

    @FindBy(xpath = "//button[.='Delete']")
    public WebElement deleteConfirm;

    @FindBy(xpath = "(//span[@class='text']//a)[1]")
    public WebElement studentId;

    @FindBy(linkText = "R")
    public WebElement ricon;












}
