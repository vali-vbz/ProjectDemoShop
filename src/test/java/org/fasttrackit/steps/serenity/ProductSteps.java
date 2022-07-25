package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.*;

public class ProductSteps extends ScenarioSteps {

    private SearchResultsPage searchResultsPage;
    private ProductPage productPage;

    @Step
    public void selectProductFromList(String product){
        searchResultsPage.selectProductFromList(product);
    }

    @Step
    public void verifySuccessMessage(String productName){
        productPage.verifySuccessMessage(productName);
    }
}
