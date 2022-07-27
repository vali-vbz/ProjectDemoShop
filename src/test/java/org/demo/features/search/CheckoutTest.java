package org.demo.features.search;

import org.junit.*;
import org.openqa.selenium.*;

public class CheckoutTest extends BaseTest {

    String textProductName = "x";

    @Test
    public void testPageOpened() {
        baseSteps.navigateToHomepage();
        Assert.assertTrue(baseSteps.expectedPageTitle("STORE"));
    }

    public void addProductToCart(int prodNumber) {
        baseSteps.navigateToHomepage();
        baseSteps.openProduct(prodNumber);
        cartSteps.clickAddCart();
        try {
            Alert promptAlert = webDriver.switchTo().alert();
            waitMe(700);
            promptAlert.accept();
            waitMe(700);
        } catch (Exception e) {
            System.out.println("log: Alert popup problem");
            e.printStackTrace();
        }
    }

    @Test
    public void verifyAddProductToCart() {
        /*
        -open a product from list
        -click on add to cart button
        -click OK on alert (Product added)
        -go back Home      a[href="index.html"]


         */
        baseSteps.navigateToHomepage();
        baseSteps.openProduct(4);
        cartSteps.clickAddCart();
        try {
            Alert promptAlert = webDriver.switchTo().alert();
            String alertText = promptAlert.getText();
            Assert.assertTrue("Product not added??", alertText.contains("Product added"));
            waitMe(800);
            promptAlert.accept();

        } catch (Exception e) {
            System.out.println("log: Alert popup problem");
            e.printStackTrace();
        }
    }

    @Test
    public void verifyCheckout() {

        addProductToCart(4);
        cartSteps.clickCartButton();
        cartSteps.clickOrderButton();
    }

    @Test
    public void verifyTotal() {

        addProductToCart(4);
        addProductToCart(6);
        cartSteps.clickCartButton();
        Assert.assertTrue("Total price error", cartSteps.checkSumPrice());

    }

    @Test
    public void verifyDeleteProductCart() {
        addProductToCart(4);
        cartSteps.clickCartButton();
        cartSteps.clickDeleteFirstButton();

    }

    @Test
    public void verifyOrderEmptyCart() {
        baseSteps.navigateToHomepage();
        cartSteps.clickCartButton();
        cartSteps.clickOrderButton();
        cartSteps.purchaseOrder();


    Assert.assertFalse("Ordered with empty Cart",cartSteps.verifyOrderSucces());

    }


    @Test
    public void verifyOrderProduct() {
        addProductToCart(4);
        cartSteps.clickCartButton();
        cartSteps.clickOrderButton();
        cartSteps.purchaseOrder();

        Assert.assertTrue("Order Unsuccefull",cartSteps.verifyOrderSucces());
    }
}