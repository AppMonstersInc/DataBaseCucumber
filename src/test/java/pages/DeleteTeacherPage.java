package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DeleteTeacherPage {

    public DeleteTeacherPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(xpath = "(//span[contains(text(),' Teachers')])")
    public WebElement teachersButton;


@FindBy(xpath = "//a[contains(text(),'All Teacher')] ")
    public WebElement allTeacherButton;

@FindBy(xpath = "//a[@class='action-icon dropdown-toggle']")
    public WebElement threeDotButton;

@FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement teacherID_Input;


@FindBy(xpath = "//a[contains(text(),' Search ')]")
    public WebElement searchButton;

@FindBy(xpath = "//a[contains(text(),'Delete')]")
    public WebElement deleteButton;

@FindBy(xpath = "//div[@class='modal-content modal-md']")
    public WebElement confirmationDeleteWindow;

@FindBy(xpath = "//button[@class='btn btn-danger']")
    public WebElement deleteBtnInsideConfirmationWindow;


}
