package com.pages;

import com.core.UserActions;
import com.sun.jmx.snmp.agent.SnmpMibTable;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Beta;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCustomer extends UserActions {
    private Logger logger = LogManager.getLogger(com.pages.BankLogin.class);

    @FindBy(name = "uid")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "btnLogin")
    private WebElement loginButton;


    @FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
    private WebElement newCustomer;

    @FindBy(name = "name")
    private WebElement customerName;

    @FindBy(name = "rad1")
    private WebElement gender;

    @FindBy(id = "dob")
    private WebElement dob;

    @FindBy(name="addr")
    private WebElement address;

    @FindBy(name="city")
    private WebElement city;

    @FindBy(id = "message4")
    private WebElement errorMsg;

    @FindBy(name="state")
    private WebElement state;

    @FindBy(name="pinno")
    private WebElement pin;

    @FindBy(id = "message6")
    private WebElement errorMsg1;

    @FindBy(name="telephoneno")
    private WebElement phone ;

    @FindBy(name="emailid")
    private WebElement email;

    @FindBy(name="password")
    private WebElement password1;

    @FindBy(name = "sub")
    private WebElement submit;

    //@FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[4]/td[1]")
    //private String customerId;




    public CreateNewCustomer() {
        super();
        PageFactory.initElements(driverThread, this);
    }

    /**public void login(){
        try{
            navigate("http://www.demo.guru99.com/v4/");
            enter(username,"mngr187789");
            enter(password,"bUpApEs");
            click(loginButton);
        }
        catch (Exception e){
            logger.error(e);
        }

    }**/
    public void createNewcustomer(String tcName){
        try{

            mouseOver(newCustomer);
            enter(customerName,"Smita");
            selectByValue(gender,"female\n" +
                    "\t");
            enter(dob,"22/10/1992");
            enter(address,"docklands");
            captureImage(tcName);
            enter(city,"");
            captureImage(tcName);
            click(state);
            String ExpectedErrorMsg = "City Field must not be blank";
            compareText(ExpectedErrorMsg,getText(errorMsg));
            clear(city);
            captureImage(tcName);
            enter(city,"melbourne");
            enter(state,"victoria");
            enter(pin,"300");
            captureImage(tcName);
            String ExpectedErrorMsg1 = "PIN Code must have 6 Digits";
            compareText(ExpectedErrorMsg1,getText(errorMsg1));
            clear(pin);
            captureImage(tcName);
            enter(pin,"300008");
            captureImage(tcName);
            enter(phone,"123456");
            enter(email,generateRandomEmail());
            enter(password1,"12345");
            captureImage(tcName);
            click(submit);


        }
        catch (Exception e){
            logger.error(e);
        }

    }
}
