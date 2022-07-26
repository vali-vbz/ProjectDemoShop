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
        loginSteps.setCredentials("999"+Constants.USER_EMAIL,Constants.USER_PASS);
        loginSteps.clickLogin();
        loginSteps.verifyUsernameMessage(Constants.USER_NAME);
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
        loginSteps.setCredentials(Constants.USER_EMAIL,Constants.USER_PASS+"wrongpass");
        loginSteps.clickLogin();
        loginSteps.verifyUsernameMessage(Constants.USER_NAME);
    }

    @Test
    public void openOrders(){
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setCredentials(Constants.USER_EMAIL,Constants.USER_PASS);
        loginSteps.clickLogin();

        loginSteps.clickOrders();

        System.out.println("Log: click pe orders..");
        waitMe(1300);

        Assert.assertEquals("text Optiune Orders",("Orders").toUpperCase(),loginSteps.getOptionMenuSelected().toUpperCase() );
        loginSteps.verifyOrdersEmpty();
    }
}
