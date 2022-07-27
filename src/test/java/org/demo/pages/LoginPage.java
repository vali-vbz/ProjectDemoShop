package org.demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class LoginPage extends PageObject {

    @FindBy(id = "loginusername")
    private WebElementFacade userField;
    @FindBy(id = "loginpassword")
    private WebElementFacade passwordField;
    @FindBy(css = "button[onclick^=logIn]")
    private WebElementFacade loginButton;

    @FindBy(id="nameofuser")
    private WebElementFacade nameOfUser;


    public void setUserField(String user){
        typeInto(userField, user);
    }
    public void setPasswordField(String password){
        typeInto(passwordField,password);
    }
    public void clickLoginButton(){
        clickOn(loginButton);
    }




}
