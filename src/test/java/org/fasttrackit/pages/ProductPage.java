package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ProductPage extends PageObject {

    @FindBy(css = ".single_add_to_cart_button")
    private WebElementFacade addToCartButton;

    @FindBy(css = ".sku_wrapper")
    private WebElementFacade skuCode;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade successMessage;

    public void clickAddToCartButton(){
        clickOn(addToCartButton);
    }

    public void verifySuccessMessage(String productName){
        successMessage.shouldContainText(""+productName + "");
        successMessage.shouldContainText("has been added to your cart");
    }
}
