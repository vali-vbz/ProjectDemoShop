package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.*;
import net.thucydides.core.steps.*;
import org.fasttrackit.pages.*;

public class BaseSteps extends ScenarioSteps {

    private HomePage homePage;
    private CurrentPage currentPage;

    @Step
    public void navigateToHomepage(){
        homePage.open();
    }

    @Step
    public boolean expectedPageTitle(String title){
        if (currentPage.getTitle().equalsIgnoreCase(title))
        {
            return true;
        }
        else{
            return false;
        }
    }

}
