package StepDefinitions;

import Pages_Packages.Home_Page;
import Pages_Packages.LoginPageClass;
import Pages_Packages.Time_Material_Class;
import Utilities_Package.CommonClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinition extends CommonClass {



    LoginPageClass loginPage_Obj = new LoginPageClass();
    Home_Page home_Obj = new Home_Page();
    Time_Material_Class timeMaterial_Obj = new Time_Material_Class();

    @Before
    public void Setup(){
        driver = new ChromeDriver();
    }

    @Given("I navigate to TurnUp portal with valid credentials")
    public void i_navigate_to_turn_up_portal_with_valid_credentials() {
        loginPage_Obj.Login_HomePage_Verification(driver);
    }

    @When("I navigate to Time and Material Page")
    public void i_navigate_to_time_and_material_page() {
        home_Obj.Click_TM_and_Create(driver);
    }

    @When("Record in Time and material {string} {string} {string} should be created")
    public void record_in_time_and_material_should_be_created(String Code, String Description, String Price) {
        timeMaterial_Obj.Create_Time_And_Material(driver, Code , Description, Price);
    }

    @Then("the record should be saved {string}")
    public void the_record_should_be_saved(String Code) {
        timeMaterial_Obj.assertion(driver , Code);

    }

    @When("I edit the record {string} {string} {string}")
    public void i_edit_the_record(String new_code, String new_description, String new_price) {
        timeMaterial_Obj.Edit_Time_And_Material(driver , new_code , new_description , new_price);
    }

    @Then("the record should be updated {string} {string} {string}")
    public void the_record_should_be_updated(String new_code, String new_description, String new_price) {
        timeMaterial_Obj.assertEdit(driver , new_code , new_description , new_price);
    }

    @When("I deleted the record and received alert message")
    public void i_deleted_the_record_and_received_alert_message() {
        timeMaterial_Obj.Delete_Time_And_Material(driver);

    }

    @Then("the TurnUp portal was logged out")
    public void the_turn_up_portal_was_logged_out() {
        timeMaterial_Obj.logOut(driver);
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
