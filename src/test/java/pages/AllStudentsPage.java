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

    @FindBy(xpath = "//*[contains(text(),'All Students')]")
    public List<WebElement> allStudents;

    @FindBy(xpath = "//*[@class='col-lg-7 col-md-12 col-sm-12 col-12']")
    public WebElement allStudentsHeader;




}
