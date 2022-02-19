package StepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountPage;
import com.pages.loginPage;
import com.qa.factory.driversFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class accountsPageSteps {
	
	private loginPage loginpage = new loginPage(driversFactory.getDriver());
	private AccountPage accountpage;
	

	@Given("User has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		List<Map<String, String>> credlist = dataTable.asMaps();
		String userName = credlist.get(0).get("username");
		String passWord = credlist.get(0).get("password");
		driversFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		loginpage.enterUserName(userName);
		loginpage.enterPassWord(passWord);
		accountpage = loginpage.clickOnLogin();
//		accountpage = loginpage.dologin(userName, passWord);

	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String Accpagetitle = accountpage.getAccountPageTitle();
		System.out.println("Account Page Title is :"+Accpagetitle);
		

	}

	@Then("user gets the Accounts section")
	public void user_gets_the_accounts_section(DataTable sectionTable) {
		List <String> expAccountsectionlist = sectionTable.asList();
		System.out.println("Expected Account Section List :" +expAccountsectionlist);
		
		List <String> actualAccountSectionlist = accountpage.accountSectionList();
		System.out.println("Actual Account Section List: " +actualAccountSectionlist);
		
		Assert.assertTrue(expAccountsectionlist.containsAll(actualAccountSectionlist));
		
	}

	@Then("Accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountpage.getAccountSectionCount() == expectedSectionCount);

	}
	
}
