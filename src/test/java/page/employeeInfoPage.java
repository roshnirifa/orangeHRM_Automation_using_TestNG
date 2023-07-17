package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class employeeInfoPage {

    @FindBy(className = "oxd-main-menu-item")//2
    public List<WebElement> myInfoBtn; //myInfobtn
    @FindBy(className = "oxd-radio-input")//1
    public List<WebElement> genderBtn;
    @FindBy(className = "oxd-button--medium")//0//1
    public List<WebElement> btnSave;
    @FindBy(className = "oxd-select-text--arrow")//2
    public List<WebElement> chooseBloodType;
    @FindBy(className = "oxd-select-text-input")//2
    public List<WebElement> bloodtext;
    public employeeInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
