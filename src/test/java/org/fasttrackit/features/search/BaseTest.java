package org.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.serenity.CartSteps;
import org.fasttrackit.steps.serenity.LoginSteps;
import org.fasttrackit.steps.serenity.ProductSteps;
import org.fasttrackit.steps.serenity.SearchSteps;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class BaseTest {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    protected LoginSteps loginSteps;
    @Steps
    protected SearchSteps searchSteps;
    @Steps
    protected ProductSteps productSteps;
    @Steps
    protected CartSteps cartSteps;

//    @Before
//    public void maximize(){
//        webDriver.manage().window().maximize();
//    }

    public static void wait(int ms){
        try {
            Thread.sleep(ms);
            System.out.println(""+ (float)(ms/1000) +"? I waited long enough !"); // help_observe
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
