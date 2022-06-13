package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa5.fasttrackit.org:8008/")
public class HomePage extends PageObject {

    @FindBy(id = "menu-item-70")
    private WebElementFacade accountLink;
    @FindBy(css = ".login-woocommerce")
    private WebElementFacade loginLink;
    @FindBy(css = "menu-item-72 ")  // #menu-a -toate butoanele
    private WebElementFacade cartLink;

    @FindBy(css = "div.search-form input.search-field")  // search bar up
    private WebElementFacade searchField1;
    @FindBy(css = "div.widget-area input.search-field")  // search side menu
    private WebElementFacade searchField2;
    @FindBy(css = "div.search-form .searchsubmit .fa-search")   // ex: [title='Search']
    private WebElementFacade searchIcon1;
    @FindBy(css="div.widget-area .searchsubmit .fa-search")
    private WebElementFacade searchIcon2;

    public void clickAccountLink(){
        clickOn(accountLink);
    }
    public void clickLoginLink(){
        clickOn(loginLink);
    }
    public void setSearchField(String keyword){
        typeInto(searchField1, keyword);
    }
    public void setSearchField2(String keyword){
        typeInto(searchField2, keyword);
    }
    public void clickSearchIcon(){
        clickOn(searchIcon1);
    }
    public void clickSearchIcon2(){
        clickOn(searchIcon2);
    }


}
