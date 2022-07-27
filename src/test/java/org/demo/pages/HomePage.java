package org.demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.demoblaze.com/index.html")
public class HomePage extends PageObject {

    @FindBy(id = "menu_item")
    private WebElementFacade accountLink;
    @FindBy(css = "#login2")
    private WebElementFacade loginLink;
    @FindBy(css = "a[href=\"prod.html?idp_=8\"].hrefch")
    private WebElementFacade product8;

    @FindBy(css = "a[href=\"prod.html?idp_=6\"].hrefch")
    private WebElementFacade product6;
    @FindBy(css = "a[href=\"prod.html?idp_=4\"].hrefch")
    private WebElementFacade product4;


    public void clickAccountLink(){
        clickOn(accountLink);
    }

    public void clickLoginLink(){
        clickOn(loginLink);
    }


    public void clickProduct(int prodNumber)
    {
        if(prodNumber==4) {
            clickOn(product4);
        }
        if(prodNumber==6) {
            clickOn(product6);
        }
        if(prodNumber==8) {
            clickOn(product8);
        }
    }

//    public void setSearchField(String keyword){
//        typeInto(, keyword);
//    }



}
