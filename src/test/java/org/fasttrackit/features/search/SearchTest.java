package org.fasttrackit.features.search;

import org.fasttrackit.utils.*;
import org.junit.Test;

public class SearchTest extends BaseTest{



    String textSearch="hoodie";
    String textProductName="hoodie with logo";

    @Test
    public void searchProductTest(){
//        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        loginSteps.navigateToHomepage();
        searchSteps.doSearch("shirt");
        searchSteps.verifyProductInResults("T-Shirt with Logo");
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
        //waitMe(1500);
        searchSteps.waitABit(2000);
        System.out.println("Test Sort done");
        //searchSteps.verifyPriceOrder();



    }

}
