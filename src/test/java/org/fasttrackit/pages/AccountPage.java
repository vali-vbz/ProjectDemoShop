package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.*;

public class AccountPage extends PageObject {

    @FindBy(css = ".woocommerce-MyAccount-content")
    private WebElementFacade welcomeText;

    @FindBy(css=".woocommerce-MyAccount-navigation li:nth-child(2)")
    private WebElementFacade ordersButton;

    @FindBy(css="woocommerce-MyAccount-content div")
    private WebElementFacade optionMessage;

    @FindBy(css=".post-title")
    private WebElementFacade optionTitle;

    public void verifyWelcomeMessage(String userName){
        welcomeText.shouldContainText ("Hello "+userName);
//        welcomeText.getText().equalsIgnoreCase("Hello "+userName))
    }

    public void clickOrdersButton(){
        clickOn(ordersButton);
    }

    public void verifyOrdersEmpty(){
        optionMessage.shouldContainText ("No order has been made yet");

    }

    public String getOptionText(){
        return optionMessage.getText().toLowerCase();
    }

    public void verifyMenuSelected(String menuSelected){
        optionMessage.shouldContainText (menuSelected);
    }

}
