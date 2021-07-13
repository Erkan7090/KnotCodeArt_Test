package com.knotcodeart.step_definitions;

import com.knotcodeart.pages.HomePage;
import io.cucumber.java.en.Given;

public class loginTest {

    @Given("Click Friends Button")
    public void click_Friends_Button() {
        HomePage homePage=new HomePage();
        homePage.Friends.click();
       }
}
