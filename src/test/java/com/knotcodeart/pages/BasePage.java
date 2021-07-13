package com.knotcodeart.pages;

import com.knotcodeart.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    WebDriverWait wait= new WebDriverWait(Driver.get(),5);

    @FindBy(xpath = "//div[@class='ui huge inverted pointing secondary menu']//a")
    public List<WebElement> MenuList;

    @FindBy(xpath = "//a[.='Home']")
    public WebElement Home;

    @FindBy(xpath = "//a[.='Services']")
    public WebElement Services;

    @FindBy(xpath = "(//a[.='Team'])[1]")
    public WebElement Team;

    @FindBy(xpath = "//a[.='Contact']")
    public WebElement Contact;

    @FindBy(xpath = "//a[.='Login']")
    public WebElement Login;

    @FindBy(xpath = "(//h1[@class='ui header'])[1]")
    public WebElement PageSubTitle;


    public String getPageSubTitle(){

        wait.until(ExpectedConditions.visibilityOf(PageSubTitle));
        return PageSubTitle.getText();

    }

    public void navigateToMenu(String Menu){
        String menu="//a[.='"+Menu+"']";
        WebElement menuElement= Driver.get().findElement(By.xpath(menu));
        wait.until(ExpectedConditions.elementToBeClickable(menuElement));
        new Actions(Driver.get()).moveToElement(menuElement).click().build().perform();

    }

}
