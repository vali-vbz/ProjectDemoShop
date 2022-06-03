package org.fasttrackit.features.search;

import org.fasttrackit.utils.*;
import org.junit.Test;

public class SearchTest extends BaseTest{

    String textSearch="necklace";
    String textProductName="SILVER DESERT NECKLACE";

    @Test
    public void searchProductTest(){
//        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        searchSteps.doSearch("necklace");
        searchSteps.verifyProductInResults("Silver Desert Ne");
    }

    @Test
    public void searchProductTest(String textSearch, String textProductName){
//        loginSteps.doLogin(Constants.USER_EMAIL,Constants.USER_PASS);
        searchSteps.doSearch(textSearch);
        searchSteps.verifyProductInResults(textProductName);
    }
}
