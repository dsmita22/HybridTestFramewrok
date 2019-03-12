package com.pages;

import com.core.UserActions;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageGuru extends UserActions {
    private Logger logger = LogManager.getLogger(com.pages.HomePageGuru.class);
    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "pass")
    private WebElement password;

    @FindBy(id = "send2")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div[1]/div/div[1]/a")
    private  WebElement editProfile;

    @FindBy(id="current_password")
    private  WebElement editpageCurrectPass;

    @FindBy(xpath = "//*[@id=\"form-validate\"]/div[3]/button")
    private  WebElement saveButton;

    @FindBy (xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/ul/li/ul/li")
    private WebElement errorMsg;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/div/a/span[2]")
    private WebElement accountClick;

    @FindBy(xpath = "//*[@id=\"header-account\"]/div/ul/li[5]/a")
    private WebElement logout;


    public HomePageGuru() {
        super();
        PageFactory.initElements(driverThread, this);
    }

    public void homePage(String tcName) {
        try {
            navigate("http://live.guru99.com/index.php/customer/account/login/");
            enter(email,"smita@gmail.com");
            enter(password,"123456");
            click(loginButton);
            click(editProfile);
            enter(editpageCurrectPass,"12345");
            click(saveButton);
            captureImage(tcName);
            String ExpectedErrorMsg = "Invalid current password";
            compareText(ExpectedErrorMsg,getText(errorMsg));
            clear(editpageCurrectPass);
            enter(editpageCurrectPass,"123456");
            click(saveButton);
            //mouseOver(accountClick);
            //click(logout);
        } catch (Exception e) {
            logger.error(e);
        }
    }

}
