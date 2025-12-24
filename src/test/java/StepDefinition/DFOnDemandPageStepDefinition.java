package StepDefinition;

import io.cucumber.java.en.Then;

public class DFOnDemandPageStepDefinition extends BaseClass{
 
	
	@Then("Click On DF On Demand Page") 
	public void click_on_df_on_demand_page() {
		DFOnDemandPagePg.clickondeepfreezeondemandpage();
		log.info("Clicked on DFOD Page");   
	}
	@Then("Search Computer Name by there name and select it")
	public void search_computer_name_by_there_name_and_select_it() { 
		DFOnDemandPagePg.searchcomputerbytherenameandselectit();
		log.info("Searched computer name and selected workstation");
		
	} 
	@Then("Perform Restart action and check Task Status from Task Status Page")
	public void perform_restart_action_and_check_task_status_from_task_status_page() {
		DFOnDemandPagePg.clickonrestartbtnandgototaskstatuspage();
		log.info("Performed Restart Action");
	}
	@Then("Verified selected machine is restarted properly on Task Status Page")
	public void verified_selected_machine_is_restarted_properly_on_task_status_page_w() {
		DFOnDemandPagePg.verifyTaskExecutedOrFailed();
		log.info("Verified Machine is Restared.");
	}

@Then("Perform Reboot Thawed Action and check Task Status from Task Status Page")
public void perform_reboot_thawed_action_and_check_task_status_from_task_status_page() {
       
}
@Then("Check selected machine is Reboot Thawed properly on Task Status Page")
public void check_selected_machine_is_reboot_thawed_properly_on_task_status_page() {
    
}
@Then("Verified on DFOD Page DF status updated correctly Frozen to Thawed")
public void verified_on_dfod_page_df_status_updated_correctly_frozen_to_thawed() {
    
}
	
}
