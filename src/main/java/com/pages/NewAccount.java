package com.pages;

import com.core.UserActions;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccount extends UserActions {
    private Logger logger = LogManager.getLogger(com.pages.BankLogin.class);

    @FindBy(name = "cusid")
    private WebElement customerId;

    @FindBy(name = "selaccount")
    private WebElement accountType;

    @FindBy(name = "inideposit")
    private WebElement deposit;

    @FindBy(name = "button2")
    private  WebElement submit;


    public NewAccount() {
        super();
        PageFactory.initElements(driverThread, this);
    }

    public void CreateNewAcc(String tcName){
        try{
            enter(customerId,"9011");
            selectByValue(accountType,"Current");
            enter(deposit,"1000");
            click(submit);
            captureImage(tcName);
        }
        catch(Exception e){
            logger.error(e);
        }
    }
}
