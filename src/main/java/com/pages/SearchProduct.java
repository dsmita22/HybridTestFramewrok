package com.pages;

import com.core.UserActions;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct extends UserActions {
    private Logger logger = LogManager.getLogger(com.pages.SearchProduct.class);
    @FindAll({@FindBy(how = How.ID, using = "search"),
            @FindBy(how = How.NAME, using = "q")})
    private WebElement searchItem;

    @FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[1]/button")
    private WebElement searchButton;






    public SearchProduct() {
        super();
        PageFactory.initElements(driverThread, this);
    }

    public void ProductSearch(String tcName){
        try{
            navigate("http://live.guru99.com/index.php/");
            enter(searchItem,"iphone");
            click(searchButton);

        }
        catch (Exception e) {
            logger.error(e);
        }


    }
}
