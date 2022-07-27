package org.demo.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.demo.pages.CartPage;

public class CartSteps extends ScenarioSteps {

    private CartPage cartPage;

    @Step
    public void clickOrderButton() {
        cartPage.clickOrderButton();
    }

    @Step
    public void clickCartButton() {
        cartPage.clickCartButton();
    }
    @Step
    public void clickAddCart() {
        cartPage.clickAddCartButton();
    }
    @Step
    public void clickDeleteFirstButton() {
        cartPage.clickDeleteFirstButton();
    }


    @Step
    public boolean checkSumPrice(){
        return cartPage.checkSumPrice();
    }

    @Step
    public void purchaseOrder() {
        cartPage.insertOrderData("x","x");
        cartPage.clickPurchaseButton();
    }

    @Step
    public boolean verifyOrderSucces(){
        if (cartPage.getMessageSucces().equalsIgnoreCase("Thank you for your purchase!")) {
            return true;
        }
        return false;
    }

}
