package com.pages

import com.core.UserActions
import org.apache.log4j.LogManager
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.*

class LoginPage : UserActions() {

    private val logger = LogManager.getLogger(LoginPage::class.java)

    //Element that wont get changed
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private val signInLink: WebElement? = null

    @FindBy(xpath = "//*[@id=\"email\"]")
    private val username: WebElement? = null

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private val password: WebElement? = null

    @FindBy(xpath = "//*[@id=\"login_form\"]/div/p[1]/a")
    private val forgotPasswordLink: WebElement? = null

    //Multiple element match
    @FindAll(FindBy(how = How.XPATH, using = "//*[@id=\"SubmitLogin\"]"), FindBy(how = How.ID_OR_NAME, using = "SubmitLogin"))
    private val loginButton: WebElement? = null

    //List of elements
    @FindBys(FindBy(xpath = "//*[@id=\"down\"]"))
    private val testDropDown: List<WebElement>? = null

    init {
        PageFactory.initElements(driverThread, this)
    }

    fun Login(tcName: String) {
        try {
            navigate("http://automationpractice.com/index.php")
            click(signInLink)
            enter(username, "")
            enter(password, "")
            click(loginButton)

            captureImage(tcName)
        } catch (e: Exception) {
            logger.error(e)
        }

    }
}