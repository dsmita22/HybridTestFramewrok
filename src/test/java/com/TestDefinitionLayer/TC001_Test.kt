package com.TestDefinitionLayer

import com.core.UserActions
import com.pages.LoginPage
import com.reporting.ExtentReports.ExtentTestManager
import io.qameta.allure.Feature
import io.qameta.allure.Link
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import org.testng.annotations.Test

class TC001_Test : UserActions() {

    @Link("https://jira.cloud.com")
    @Feature("Api1")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "E2E test for App")
    fun TestLogin() {

        val tName = "TC001_Test"

        val loginPage = LoginPage()

        ExtentTestManager.startTest("Test1", "Test Description")

        try {
            loginPage.Login(tName)
            CreateImageDoc(tName)
        } catch (e: Exception) {
            catchBlock(e)
        } finally {
            ExtentTestManager.endTest()
        }

    }
}
