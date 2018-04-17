package SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page{

    @FindBy(className = "left-menu__user-box-name")
    public WebElement userName;


    private void init() {
        PageFactory.initElements(driver, this);
    }

    public HomePage(WebDriver driver) {
        super(driver);
        init();
    }

    public void open() {
        //driver.get("https://admin:admin123@diploma-courses.7bits.it/login");
        driver.get("https://diploma-courses.7bits.it/app/incoming-documents");
    }

    public boolean isLoginIn(){
        return isElementPresent(userName);
    }

}
