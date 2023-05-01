package testPage;

import TestDataPath.DataParams;
import Base.TestBase;
import Utilities.Utils;
import io.qameta.allure.*;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends TestBase
{

    public LoginPage login;
    DataParams dataParams = new DataParams();
    public Utils utils;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setup()
    {
        initialization();
        login = new LoginPage();
        utils = new Utils();
    }

/*    @Test(priority = 1, description = "Successful login")
    @Epic("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Successful login")
    @Story("Login-0001 : To check login should work")
    public void login() {
        String username = ut.readDataFromJsonFile(dataParams.loginJson, "username");
        String password = ut.readDataFromJsonFile(dataParams.loginJson, "password");
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickOnLoginButton();
    }*/

/*    @Test(priority = 2, description = "Forgot password")
    @Epic("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Forgot and reset password")
    @Story("Login-0002 : Forgot and reset password should work")
    public void forgotAndResetPassword()
    {
       String username = ut.readDataFromJsonFile(dataParams.loginJson, "username");
       String emailVerificationURL = ut.readDataFromJsonFile(dataParams.loginJson, "emailVerificationURL");
       String emailPrefix = StringUtils.substringBefore(username, "@");
       String forgotPasswordSuccessfulMessage= ut.readDataFromJsonFile(dataParams.loginJson,"successfulMessageForForgotPassword");
       String fromEmail = ut.readDataFromJsonFile(dataParams.loginJson,"fromEmail");
       String newPassword = ut.readDataFromJsonFile(dataParams.loginJson, "newPasswordForReset");
       String successfulMessageForPasswordReset = ut.readDataFromJsonFile(dataParams.loginJson,"successfulMessageForPasswordReset");

       login.clickOnForgotYourPassword();
       login.enterEmailForForgotPassword(username);
       login.clickOnResetPassword();
       String successfulMessageForForgotPassword = login.verifyForgotPasswordSuccessfulMessage();
       Assert.assertEquals(successfulMessageForForgotPassword, forgotPasswordSuccessfulMessage);
       System.out.println("Email after join: "+emailVerificationURL+emailPrefix);
       driver.get(emailVerificationURL+emailPrefix);
       login.OpenInboxMail(fromEmail);
       utils.handleIframe("html_msg_body");
       login.openResetPasswordURL();
       utils.windowHandle("child");
       login.enterNewPassword(newPassword);
       login.enterConfirmPassword(newPassword);
       login.clickOnResetPasswordToSetPassword();
       String successfulMessageForPasswordRest =  login.getSuccessfulPasswordResetMsg();
       Assert.assertEquals(successfulMessageForPasswordRest, successfulMessageForPasswordReset);

    }*/


    @Test(priority = 3, description = "Signup account")
    @Epic("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Signup account")
    @Story("Login-0001 : Creating a new account ")
    public void signupAccount()
    {
        String signupEmail = ut.readDataFromJsonFile(dataParams.loginJson, "signupEmail");

        login.clickOnSignUpButton();
        login.enterEmailForSignup(signupEmail);
        login.checkTermsOfUseCheckbox();
        login.checkedCaptcha();
    }


/*    @AfterMethod
    public void tearDown()
    {
        TestBase.cleanup();
    }*/
}
