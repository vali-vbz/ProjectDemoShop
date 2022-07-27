package org.demo.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.demo.pages.HomePage;
import org.demo.pages.LoginPage;

public class LoginSteps extends ScenarioSteps {

    private HomePage homePage;
    private LoginPage loginPage;


    @Step
    public void navigateToHomepage(){
        homePage.open();
    }

    @Step
    public void loginClick(){
    homePage.clickLoginLink();
    }

    @Step
    public void setCredentials(String user, String pass){
        loginPage.setUserField(user);
        loginPage.setPasswordField(pass);
    }

    @Step
    public void loginButton() {
        loginPage.clickLoginButton();
    }



}
