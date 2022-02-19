package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.pages.ContactusPage;
import com.qa.factory.driversFactory;
import com.qa.utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactusSteps {
	
	private ContactusPage ContactusPage = new ContactusPage(driversFactory.getDriver());
	
	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		driversFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");

	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List <Map<String, String>> testdata =  reader.getData("/Users/samit/Desktop/Autimationexcl.xlsx", sheetName);
		String heading = testdata.get(rowNumber).get("Subject Heading");
		String email = testdata.get(rowNumber).get("Email");
		String orderref = testdata.get(rowNumber).get("OrderRef");
		String message = testdata.get(rowNumber).get("Message");
		
		ContactusPage.fillContactUsForm(heading, email, orderref, message);

	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		ContactusPage.clickSend();
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expSuccessMsg) {
		String actualMsg = ContactusPage.getSuccessMessg();
		Assert.assertEquals(expSuccessMsg, actualMsg);
	}

}
