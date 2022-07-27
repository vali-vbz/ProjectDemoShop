package org.demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.*;

import org.openqa.selenium.*;

public class CartPage extends PageObject {

    @FindBy(css = "button[data-target=\"#orderModal\"]")
    private WebElementFacade orderButton;
    @FindBy(css = "#cartur")
    private WebElementFacade cartButton;
    @FindBy(css = "a[onclick^=showcart]")
    private WebElementFacade cartButtonCheckout;
    @FindBy(css = "a[onclick^=addToCart]")
    private WebElementFacade addCartButton;
    @FindBy(css = ".table tr:nth-child(1) td:nth-child(4) a")
    private WebElementFacade deleteFirstButton;

    @FindBy(id = "totalp")
    private WebElementFacade priceTotal;

    @FindBy(css = ".success td:nth-child(3)")
    private List<WebElementFacade> priceList;

    @FindBy(css = ".success")
    private List<WebElementFacade> productsList;


    // 1 delete button
    //.table tr:nth-child(1) td:nth-child(4) a

    //--- order fields
    @FindBy(css = "input.form-control[id=\"name\"]")
    private WebElementFacade nameOrder;
    @FindBy(css = "input.form-control[id=\"card\"]")
    private WebElementFacade cardOrder;
//    country; city; ; month

    @FindBy(css="button[onclick=\"purchaseOrder()\"]")
    private WebElementFacade purchaseButton;
    //  -- Thank you for your purchase!
    @FindBy(css = ".sweet-alert h2")
    private WebElementFacade messageSuccesOrder;
    @FindBy(css = "button.confirm.btn-primary")
    private WebElementFacade confirmSuccesOrder;



    public void clickDeleteFirstButton(){
        clickOn(deleteFirstButton);
    }

    public void clickOrderButton(){
        clickOn(orderButton);

    }
    public void clickAddCartButton(){
        clickOn(addCartButton);

    }
    public void clickCartButton(){
        clickOn(cartButton);
    }
    public void clickPurchaseButton(){
        clickOn(purchaseButton);
    }


    public int sumPrices() {
       int sum=0;
        int aux=0;
        for(WebElementFacade element : priceList) {
            aux=Integer.parseInt((element.getText()).trim());
            sum=sum+aux;
        }
        return sum;
    }

    public boolean checkSumPrice(){
        int total=Integer.parseInt((priceTotal.getText()).trim());
        int sum=sumPrices();
        if (total==sum) {
            System.out.println("log: Prices ok: "+sum);
            return true;
        }
        else {
            System.out.println("log: Total: "+total+"<>"+sum);
            return false;
        }

    }

    public void insertOrderData(String name,String card) {

        clickOn(nameOrder);
        typeInto(nameOrder, name);
//        clickOn(cardOrder);
        typeInto(cardOrder, card);
    }

    public String getMessageSucces(){
        if (messageSuccesOrder.isDisplayed()) {
            return messageSuccesOrder.getText();
        }
        else
            return "";
    }
}
