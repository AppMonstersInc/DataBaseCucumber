package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AddTeacherPage {

    public AddTeacherPage(){PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[contains(text(),'Add Teacher')])[1]")
    public WebElement addTeacherButton;


}
