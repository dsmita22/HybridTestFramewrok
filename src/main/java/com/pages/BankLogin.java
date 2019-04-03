package com.pages;

import com.core.UserActions;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankLogin extends UserActions {
    private Logger logger = LogManager.getLogger(com.pages.BankLogin.class);

    @FindBy(name = "uid")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "btnLogin")
    private WebElement loginButton;

    public BankLogin() {
        super();
        PageFactory.initElements(driverThread, this);
    }
    public void loginPage(){
        try{
            navigate("http://www.demo.guru99.com/v4/");
            enter(username,"mngr187789");
            enter(password,"bUpApEs");
            click(loginButton);

        }
        catch (Exception e){
            logger.error(e);
        }

    }
}
