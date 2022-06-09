package org.fasttrackit.features.search;

import org.fasttrackit.utils.*;
import org.junit.*;


public class LoginTests extends BaseTest{

    @Test
    public void openHomePageTest(){
        loginSteps.navigateToHomepage();
//        Assert.assertTrue();
    }

    @Test
    public void loginWithValidCredentialsTest(){
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setCredentials("cosmin@fasttrackit.org","123456");
        loginSteps.clickLogin();
        loginSteps.verifyUsernameMessage("Cosmin Fast");
    }

    @Test
    public void loginWithValidCredentialsTestConstant(){
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setCredentials(Constants.USER_EMAIL,Constants.USER_PASS);
        loginSteps.clickLogin();
        loginSteps.verifyUsernameMessage("Cosmin Fast");
    }
}
