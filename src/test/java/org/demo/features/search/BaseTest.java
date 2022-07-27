package org.demo.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.demo.steps.serenity.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;

@RunWith(SerenityRunner.class)
public class BaseTest {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    protected LoginSteps loginSteps;

    @Steps
    protected CartSteps cartSteps;

    @Steps
    protected BaseSteps baseSteps;

    @Before
    public void windowSize(){
        webDriver.manage().window().setSize(new Dimension( 1150, 720));  // window().maximize();
    }





    //''''
    public static void waitMe(int ms){
        try {
            Thread.sleep(ms);
            //System.out.println("Run waited "+ (double)(ms/1000) +" sec!"); // help_observe
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
