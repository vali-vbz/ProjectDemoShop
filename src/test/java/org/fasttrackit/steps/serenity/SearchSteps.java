package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.SearchResultsPage;
import org.junit.Assert;

public class SearchSteps extends ScenarioSteps {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @Step
    public void doSearch(String keyword){
        homePage.setSearchField(keyword);
        homePage.clickSearchIcon();
    }
    @Step
    public void verifyProductInResults(String productName){
        Assert.assertTrue(searchResultsPage.checkListForProduct(productName));
    }

    @Step
    public void sortProducts(String sortType){
        searchResultsPage.clickSortBy(sortType);
    }

    @Step
    public void getPrices(){
        System.out.println( searchResultsPage.getPrices() );
        searchResultsPage.getPrices();
    }

    @Step
    public float getFirstPrice(){
        return searchResultsPage.getPrices().get(0).intValue();
    }

    @Step
    public float getLastPrice(){
        return searchResultsPage.getPrices().get(searchResultsPage.getPrices().size()-1).intValue();
    }
    @Step
    public void verifyPriceOrder(){
        Assert.assertTrue(searchResultsPage.checkPricesAscending(getFirstPrice(),getLastPrice()) );
    }


//end
}
