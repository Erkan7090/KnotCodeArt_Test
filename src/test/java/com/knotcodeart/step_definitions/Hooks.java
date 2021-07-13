package com.knotcodeart.step_definitions;

import com.knotcodeart.utilities.ConfigurationReader;
import com.knotcodeart.utilities.Driver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.Ignore;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

//    @Before("@db")
//    public void setUpDatabase(){
//        System.out.println("\tCONNECTION DATABASE");
//    }

    @Before
    public void setUp(){
        System.out.println("\tthis is coming from BEFORE");
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().get(ConfigurationReader.get("url"));
    }

//    @After("@db")
//    public void tearDownDatabase(){
//        System.out.println("\tCLOSING DATABASE CONNECTION");
//    }

    @After@Ignore
    public void tearDown(Scenario scenario){
        //if the scenario fails take the screenshot
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }

        Driver.closeDriver();
    }
}
