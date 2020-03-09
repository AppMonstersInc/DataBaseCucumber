package pages.Main_menu_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MainMenuPage {

    public MainMenuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[.=' Teachers']")
    public WebElement teachersButtonMain;

    @FindBy(xpath = "//span[.=' Students']")
    public WebElement studentsButtonMain;

    @FindBy(xpath = "//a[.='All Teacher']")   //  //ul/li/a[.='All Teacher']
    public WebElement allTeacherButton;

    @FindBy(xpath = "//a[.='Add Teacher']")  //  //UL/li'/a[.='Add Teacher']
    public WebElement addTeacherButton;

    @FindBy(xpath = "//a[.='All Students']")
    public WebElement allStudentsButton;

    @FindBy(xpath = "//a[.='Add Student']")
    public WebElement addStudentButton;
}
