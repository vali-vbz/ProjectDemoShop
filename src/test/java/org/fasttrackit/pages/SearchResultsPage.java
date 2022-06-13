package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.*;
import java.util.concurrent.*;

public class SearchResultsPage extends PageObject {
/*
* .products-grid li.item
* .category-products > .toolbar select[title^=Sort]
* .category-products > .toolbar select[title^=Sort] option
* .price-box .regular-price .price, .price-box .special-price .price
* */
    @FindBy(css = "x")   /*elementul intreg din search*/
    private List<WebElementFacade> productsList;

    @FindBy(css = "x")
    private WebElementFacade sortButton;

    @FindBy(css = "x")
    private List<WebElementFacade> sortByList;

    @FindBy(css="x")
    private List<WebElementFacade> priceList;

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

    public List<Float> getPrices(){
        List<Float> xText=new ArrayList<Float>();
        for(WebElementFacade element : priceList) {
            xText.add(Float.valueOf(element.getText().replace(" RON","")));
        }

//        xText.get(0);
//        xText.get(xText.size()-1);

        return xText;
    }

    public boolean checkPricesAscending(float p1, float p2) {
        if (p1<=p2){
            return  true;
        }
        else{
            return false;
        }
    }



    }
