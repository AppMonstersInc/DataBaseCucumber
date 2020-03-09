package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.Random;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[contains(text(),'Teachers')])[1]")
    public WebElement teachersButton;

    @FindBy(xpath = "(//*[contains(text(),'Students')])[1]")
    public WebElement studentsButton;

    public static void main(String[] args) {
        Random random = new Random(1);
        int b = 0;
        do{
            int a = random.nextInt(2);
            System.out.println(a);
            b = a;

        }while (b !=2);

    }


}
