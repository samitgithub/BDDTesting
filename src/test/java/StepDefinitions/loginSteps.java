package StepDefinitions;

import org.junit.Assert;

import com.pages.loginPage;
import com.qa.factory.driversFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {

	private static String pageTitle;
	private loginPage loginpage = new loginPage(driversFactory.getDriver());
	
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		driversFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");


	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		pageTitle = loginpage.getLoginPageTitle();
		System.out.println("Title of the page is "+pageTitle);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String pagetitle) {		
		Assert.assertTrue(pageTitle.contains(pagetitle));

	}

	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginpage.isForgotPwdLinkExist());

	}

	@When("User enters username {string}")
	public void user_enters_username(String username) {
		loginpage.enterUserName(username);

	}

	@When("User enters password {string}")
	public void user_enters_password(String password) {
		loginpage.enterPassWord(password);

	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		loginpage.clickOnLogin();

	}

	@Then("User gets the title of the accounts page")
	public void user_gets_the_title_of_the_accounts_page() {

	}

}
