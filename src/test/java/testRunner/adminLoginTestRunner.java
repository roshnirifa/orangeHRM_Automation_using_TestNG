package testRunner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.DashboardPage;
import page.adminLoginPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;


public class adminLoginTestRunner extends Setup {
    adminLoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 1, description = "User can not login with invalid username")
    public void doLoginWithInvalidUsername() throws IOException, org.json.simple.parser.ParseException {
        loginPage = new adminLoginPage(driver);
        JSONArray empArray = Utils.readJSONArray("./src/test/resources/employees.json");
        JSONObject empObj = (JSONObject) empArray.get(0);
        String errorMessageActual = loginPage.doLoginWithWrongCreds("wronguser", empObj.get("password").toString());
        String errorMessageExpected = "Invalid credentials";
        Assert.assertTrue(errorMessageActual.contains(errorMessageExpected));
    }
   @Test(priority = 2, description = "User can not login with invalid password")
    public void doLoginWithInvalidPassword() throws IOException, ParseException, org.json.simple.parser.ParseException {
        loginPage = new adminLoginPage(driver);
        JSONArray empArray = Utils.readJSONArray("./src/test/resources/employees.json");
        JSONObject empObj = (JSONObject) empArray.get(0);
        String errorMessageActual = loginPage.doLoginWithWrongCreds(empObj.get("username").toString(), "wrongpass");
        String errorMessageExpected = "Invalid credentials";
        Assert.assertTrue(errorMessageActual.contains(errorMessageExpected));
    }


//    @Test(priority = 2, description = "User can not login with wrong creds")
//    public void doLoginWithInvalidCreds() {
//        loginPage = new adminLoginPage(driver);
//        String errorMessageActual = loginPage.doLoginWithWrongCreds("wronguser", "wrongpass");
//        String errorMessageExpected = "Invalid credentials";
//        Assert.assertTrue(errorMessageActual.contains(errorMessageExpected));
//    }


    @Test(priority = 3, description = "User can login with valid creds",  groups = "smoke")
    public void doLogin() throws InterruptedException, IOException, org.json.simple.parser.ParseException {
        loginPage = new adminLoginPage(driver);
//        String username = "Admin";
//        String password = "admin123";
//        loginPage.doLogin(username, password);


        JSONArray empArray = Utils.readJSONArray("./src/test/resources/employees.json");
        JSONObject empObj = (JSONObject) empArray.get(0);
        loginPage.doLogin(empObj.get("username").toString(), empObj.get("password").toString());

        dashboardPage = new DashboardPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.imgProfile.isDisplayed());
        Thread.sleep(3000);

        String urlActual = driver.getCurrentUrl();
        String urlExpected = "/index.php/dashboard/index";
        softAssert.assertTrue(urlActual.contains(urlExpected));
        softAssert.assertAll();

//        Utils.saveInfo(username, password);


    }


}
