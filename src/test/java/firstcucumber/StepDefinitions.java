package firstcucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class StepDefinitions {
    WebDriver driver;
    public StepDefinitions()
    {
        this.driver= Hooks.driver;
    }

    @Given("The login screen is displayed on browser")
    public void the_login_screen_is_displayed_on_browser() {
        //Open login
        this.driver.get("http://testmaster.vn/Account/Login?ReturnUrl=%2fadmin");
    }

    @When("^The User attempt to login with his credentials is (.*) and (.*)$")
    public void the_User_attempt_to_login_with_his_credentials(String username, String password) {
        WebElement txtUserName = this.driver.findElement(By.cssSelector("input[type=\"Email\"]"));
        WebElement txtPassword = this.driver.findElement(By.cssSelector("input[type=\"password\"]"));
        WebElement btnLogin = this.driver.findElement(By.cssSelector("button.btn-login"));

        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

    @Then("The homepage will be showed")
    public void the_homepage_will_be_showed() {
        String title = this.driver.getTitle();
        Assert.assertEquals("Home Page - Testmaster.vn", title);
    }

    @When("^The user attempt to login with (.+) and invalid (.+)$")
    public void theUserAttemptToLoginWithUsernameAndInvalidPassword(String username, String password)
    {
        WebElement txtUserName = this.driver.findElement(By.cssSelector("input[type=\"Email\"]"));
        WebElement txtPassword = this.driver.findElement(By.cssSelector("input[type=\"password\"]"));
        WebElement btnLogin = this.driver.findElement(By.cssSelector("button.btn-login"));

        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();

        txtPassword.sendKeys(Keys.ENTER);

        this.driver.navigate().refresh();
        this.driver.navigate().back();
        this.driver.navigate().forward();

        //
        this.driver.manage().window().maximize();
    }

    @Then("^The error (.+) is showed$")
    public void the_error_is_showed(String message) throws Throwable {

    }


}
