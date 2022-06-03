package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

public class SearchResultsPage extends PageObject {

    @FindBy(css = ".products-grid li.item")   /*elementul intreg din search*/
    private List<WebElementFacade> productsList;

    @FindBy(css = ".category-products > .toolbar select[title^=Sort]")
    private WebElementFacade sortButton;

    @FindBy(css = ".category-products > .toolbar select[title^=Sort] option")
    private List<WebElementFacade> sortByList;

    public boolean checkListForProduct(String productName){
        for(WebElementFacade element : productsList){
            if(element.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(productName)){
                System.out.println("log: Element gasit");
                return true;
            }
        }
        return false;
    }
    public void selectProductFromList(String product){
        for(WebElementFacade element : productsList){
            if(element.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(product)){
                element.findElement(By.cssSelector("a.product-image")).click();
                break;
            }
        }
    }

/*
    public void clickSort() {
        clickOn(sortButton);
    }
*/

    public void clickSortBy(String sortby) {
        clickOn(sortButton);
        for(WebElementFacade element : productsList) {
            if(element.getText().equalsIgnoreCase(sortby)){
                element.click();
                break;
            }
        }
    }
}
