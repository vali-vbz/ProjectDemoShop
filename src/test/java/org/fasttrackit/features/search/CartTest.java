package org.fasttrackit.features.search;

import org.fasttrackit.utils.*;
import org.junit.Test;

public class CartTest extends BaseTest{

    String textSearch="hoodie";
    String textProductName="Hoodie with Logo";

    @Test
    public void addProductToCart(){
        loginSteps.navigateToHomepage();
//        loginSteps.setCredentials(Constants.USER_EMAIL,Constants.USER_PASS);
//        loginSteps.clickLogin();
        searchSteps.doSearch(textSearch);
        productSteps.selectProductFromList(textProductName);
        cartSteps.clickAddToCart();
        productSteps.verifySuccessMessage(textProductName);
    }
}
