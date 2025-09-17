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
		DFOnDemandPagePg.verifiedTaskExecutedProperly();
		log.info("Verified Machine is Restared.");
	}

@Then("Switch site to related site")
public void switch_site_to_related_site() {
	DFOnDemandPagePg.switchtorelatedsite();
	log.info("Switched to related site");
}
	
}
