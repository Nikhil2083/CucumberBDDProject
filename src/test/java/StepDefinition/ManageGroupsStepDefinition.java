package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ManageGroupsStepDefinition extends BaseClass {

	@Then("Click on Groups Page")
	public void click_on_groups_page() {
	ManageGroupspg.clickonGroupsPage();
		log.info("Clicked on Groups Page"); 
	}
	@Then("Verify Add Groups button is displayed on manage groups page.")
	public void verify_add_groups_button_is_displayed_on_manage_groups_page() {
		log.info("Verified Add Groups button is displayed on groups Page"); 
	}
	
	
	@Given("Click on Add Groups button")
	public void click_on_add_groups_button() {
	    ManageGroupspg.clickonaddgroupsbutton();
	    log.info("Clicked on Add Groups Button");
	}
	@Then("Verify that Add Groups dialog is launched")
	public void verify_that_add_groups_dialog_is_launched() {
		ManageGroupspg.AddGroupsDialogAppeared();
		log.info("Add Groups dialog is launched"); 
	}
	    
	@Then("click on ADD button")
	public void click_on_add_button() {
		ManageGroupspg.ClickonADDBtn();
		log.info("on Add Groups dialog clicked on  ADD button");
	}
	@Then("verify that group with empty name can not be created")
	public void verify_that_group_with_empty_name_can_not_be_created() {
		ManageGroupspg.errorappears();
		log.info("verified that group with empty name can not be created");
	}
	
	    
	
	
	
	
	
	
	
}
