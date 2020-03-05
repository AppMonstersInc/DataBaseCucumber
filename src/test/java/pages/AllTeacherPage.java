package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AllTeacherPage {
    public AllTeacherPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='active' and contains(text(),'All Teachers')]")
    public WebElement allTeacherButton;

    @FindBy(xpath = " //a[@class='btn btn-primary btn-rounded float-right']")
    public WebElement AddTeacherButton;


}
