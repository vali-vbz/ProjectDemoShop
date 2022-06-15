package org.fasttrackit.features.search;

import org.fasttrackit.utils.*;
import org.junit.*;


public class LoginTest extends BaseTest{

    @Test
    public void openHomePageTest(){
        loginSteps.navigateToHomepage();
//        Assert.assertTrue();
    }

    @Test
    public void loginWithInvalidUserTest(){
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setCredentials("v999",Constants.USER_PASS);
        loginSteps.clickLogin();
    }

    @Test
    public void loginWithValidCredentialsTest(){
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setCredentials(Constants.USER_EMAIL,Constants.USER_PASS);
        loginSteps.clickLogin();
        loginSteps.verifyUsernameMessage(Constants.USER_NAME);
    }

    @Test
    public void loginWithInvalidPassTest(){
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setCredentials(Constants.USER_EMAIL,"wrongpass");
        loginSteps.clickLogin();

    }

    @Test
    public void openOrders(){
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setCredentials(Constants.USER_EMAIL,Constants.USER_PASS);
        loginSteps.clickLogin();

        loginSteps.clickOrdersButton();
        wait(1500);
        loginSteps.verifyOptionMenuSelected("orders");
    }
}
