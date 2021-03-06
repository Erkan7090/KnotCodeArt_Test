package com.knotcodeart.pages;

import com.knotcodeart.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

   @FindBy(xpath = "//a[contains(@class,'raised')]")
    public List<WebElement> WhatWeDo;


}
