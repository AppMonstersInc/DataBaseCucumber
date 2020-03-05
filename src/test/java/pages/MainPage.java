package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[contains(text(),'Teachers')])[1]")
    public WebElement teachersButton;

    @FindBy(xpath = "(//*[contains(text(),'Students')])[1]")
    public WebElement studentsButton;


}
