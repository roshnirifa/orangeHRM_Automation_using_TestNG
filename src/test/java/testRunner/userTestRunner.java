package testRunner;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import page.DashboardPage;
import page.adminLoginPage;
import page.employeeInfoPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

import static org.openqa.selenium.Keys.*;

public class userTestRunner extends Setup {


    @Test(priority = 1, description = "employee can't login with invalid username")
    public void doLoginWithInvalidUsername() throws IOException, ParseException, org.json.simple.parser.ParseException {
        adminLoginPage loginPage = new adminLoginPage(driver);
        JSONArray empArray = Utils.readJSONArray("./src/test/resources/employees.json");
        JSONObject empObj = (JSONObject) empArray.get(empArray.size()-1);
        String errorMessageActual = loginPage.doLoginWithWrongCreds("1wronguser", empObj.get("password").toString());
        String errorMessageExpected = "Invalid credentials";
        Assert.assertTrue(errorMessageActual.contains(errorMessageExpected));

    }
    @Test(priority = 2, description = "employee can't login with invalid password")
    public void doLoginWithInvalidPassword() throws IOException, ParseException, org.json.simple.parser.ParseException {
        adminLoginPage loginPage = new adminLoginPage(driver);
        JSONArray empArray = Utils.readJSONArray("./src/test/resources/employees.json");
        JSONObject empObj = (JSONObject) empArray.get(empArray.size()-1);
        String errorMessageActual = loginPage.doLoginWithWrongCreds(empObj.get("username").toString(), "wrongpass");
        String errorMessageExpected = "Invalid credentials";
        Assert.assertTrue(errorMessageActual.contains(errorMessageExpected));
    }


    @Test(priority = 3, description = "login with newly created employee", groups = "smoke")
    public void doLogin() throws IOException, ParseException, org.json.simple.parser.ParseException {
        adminLoginPage loginPage = new adminLoginPage(driver);
        JSONArray empArray = Utils.readJSONArray("./src/test/resources/employees.json");
        JSONObject empObj = (JSONObject) empArray.get(empArray.size() - 1);
        String username = empObj.get("username").toString();
        String password = empObj.get("password").toString();
        loginPage.doLogin(username, password);

        String nameExpected = empObj.get("firstName").toString() + " " + empObj.get("lastName").toString();
        String nameActual = driver.findElement(By.className("oxd-userdropdown-name")).getText();
        Assert.assertEquals(nameActual, nameExpected);
    }


    @Test(priority = 4, description = "Employee can save gender ")
    public void saveGender() throws InterruptedException {
        employeeInfoPage myInfoPage = new employeeInfoPage(driver);
        myInfoPage.myInfoBtn.get(2).click();
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("orangehrm-main-title")));

        Utils.doScroll(driver);
        myInfoPage.genderBtn.get(0).click();
        myInfoPage.btnSave.get(0).click();

    }

    @Test(priority = 5, description = "Employee can save their blood type ")
    public void saveBloodType() throws InterruptedException {
        employeeInfoPage myInfoPage = new employeeInfoPage(driver);
        myInfoPage.myInfoBtn.get(2).click();
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("orangehrm-main-title")));

        Utils.doScroll(driver);
        Actions action = new Actions(driver);


        myInfoPage.chooseBloodType.get(2).click();
        action = action.sendKeys(Keys.ARROW_DOWN);
        action = action.sendKeys(Keys.ARROW_DOWN);
        action = action.sendKeys(Keys.ARROW_DOWN);
        action = action.sendKeys(Keys.ARROW_DOWN);
        action = action.sendKeys(Keys.ARROW_DOWN);

        action.perform();

        myInfoPage.btnSave.get(1).click();

        Thread.sleep(1000);
        String txtActual = myInfoPage.bloodtext.get(2).getText();
        String txtExpected = "O+";
        Assert.assertEquals(txtActual, txtExpected);
    }


    @Test(priority = 6, description = "Employee can update their blood type ", groups = "smoke")
    public void updateBloodType() throws InterruptedException {
        employeeInfoPage myInfoPage = new employeeInfoPage(driver);
        myInfoPage.myInfoBtn.get(2).click();
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("orangehrm-main-title")));

        Utils.doScroll(driver);

        Actions action = new Actions(driver);
        myInfoPage.chooseBloodType.get(2).click();
        action = action.sendKeys(Keys.ARROW_DOWN);
        action = action.sendKeys(Keys.ARROW_DOWN);
        action = action.sendKeys(Keys.ARROW_DOWN);
        action = action.sendKeys(Keys.ARROW_DOWN);
        action = action.sendKeys(Keys.ARROW_DOWN);
        action = action.sendKeys(Keys.ARROW_DOWN);
        action = action.sendKeys(Keys.ARROW_DOWN);
        action = action.sendKeys(Keys.ARROW_DOWN);
        action.perform();

        myInfoPage.btnSave.get(1).click();

        Thread.sleep(1000);
        String txtActual = myInfoPage.bloodtext.get(2).getText();
        String txtExpected = "AB-";
        Assert.assertEquals(txtActual, txtExpected);
    }

    @Test(priority = 7, description = "Employee blood type must be selected for update")
    public void bloodSelectUpdate() throws InterruptedException {
        employeeInfoPage myInfoPage = new employeeInfoPage(driver);
        myInfoPage.myInfoBtn.get(2).click();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("orangehrm-main-title")));

        Utils.doScroll(driver);
        String txtActual = myInfoPage.bloodtext.get(2).getText();
        String txtExpected = "-- Select --";
        Assert.assertEquals(txtActual, txtExpected);
    }
@AfterTest
    public void doLogout() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.doLogout();
    }


}
