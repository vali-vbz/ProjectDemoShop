package org.fasttrackit.features.search;

import org.fasttrackit.utils.*;
import org.junit.Test;

public class SearchTest extends BaseTest{



    String textSearch="necklace";
    String textProductName="SILVER DESERT NECKLACE";

    @Test
    public void searchProductTest(){
//        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        loginSteps.navigateToHomepage();
        searchSteps.doSearch("necklace");
        searchSteps.verifyProductInResults("SILVER DESERT NECKLACE");
    }

    @Test
    public void searchProductTestByText(){
//        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        loginSteps.navigateToHomepage();
        searchSteps.doSearch(textSearch);
        searchSteps.verifyProductInResults(textProductName);
    }

    @Test
    public void searchSortProducts(){
        loginSteps.navigateToHomepage();
        searchSteps.doSearch("shirt");
        searchSteps.sortProducts("Price");
        wait(1500);
        searchSteps.waitABit(2000);
        searchSteps.verifyPriceOrder();



    }

}
