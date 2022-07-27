package org.demo.features.search;

import org.demo.utils.*;
import org.junit.*;
import org.openqa.selenium.*;


public class LoginTest extends BaseTest{

    @Test
    public void openHomePageTest(){
        baseSteps.navigateToHomepage();
        Assert.assertTrue(baseSteps.expectedPageTitle("STORE"));
    }

    @Test
    public void loginWithInvalidUserTest(){
        baseSteps.navigateToHomepage();
        loginSteps.loginClick();

        loginSteps.setCredentials("invalid1111x","123");
        //loginSteps.setCredentials(Constants.USER_NAME,Constants.USER_PASS);
        loginSteps.loginButton();

        System.out.println("log: Test_User");
        try {
            Alert promptAlert = webDriver.switchTo().alert();
            String alertText = promptAlert.getText();
            System.out.println("log: Alert text is: " + alertText);
            Assert.assertTrue("Different alert",alertText.contains("User does not exist"));

            //Assert.assertTrue("User exists!!",alertText.equalsIgnoreCase("Wrong password."));
            waitMe(500);
            promptAlert.accept();
        } catch (Exception e) {
            System.out.println("log: try-Catch");
            e.printStackTrace();
        }

//        if (!alertText.isEmpty()){
//
//        }
        //        promptAlert.sendKeys("Test_User");
//        System.out.println("log: Test_User");

    }

    @Test
    public void loginWithValidCredentialsTest(){
        loginSteps.navigateToHomepage();
        loginSteps.loginClick();
        loginSteps.setCredentials(Constants.USER_NAME,Constants.USER_PASS);
        loginSteps.loginButton();
    }

}
