package StepDefinition;

import java.io.File;
import org.openqa.selenium.interactions.Actions;
import PageObject.PageObjectForDeepFreezeSuite;
import Utilities.FileUtils;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.*;
import org.junit.Assert;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import Utilities.ExtentReportManager; // Import for ExtentReports integration
import com.aventstack.extentreports.Status; // Import Status for logging

public class StepDefinitionForDeepFreezeSuites extends BaseClass {
	 
    //////////////////////// step definition code from
    //////////////////////// till///////////////////////////////////
    /////////////////////////MY Site ////////////////////////////////////////////////////////////  
    
	@Then("Switch site to newly created site") 
	public void switch_site_to_newly_created_site() {
	    DeepFreezeSuitePg.SwitchToSelectNewlyCreatedSite();
	}
	
	@Then("Switch site to default site")
	public void switch_site_to_default_site() {
	    DeepFreezeSuitePg.SwitchToDefaultSite();
	}
	
	
	
	
    @Then("verified cloud should be switched to the new site.")
    public void verified_cloud_should_be_switched_to_the_new_site() {
        DeepFreezeSuitePg.VerifySiteSwitchedToNewlyCreatedSite();
        log.info("Verified site switched to newly created site.");
      //  ExtentReportManager.logStep(Status.INFO, "Verified site switched to newly created site.");
    }

    @Then("Search newly added site name under search field and click on delete site option")
    public void search_newly_added_site_name_under_search_field_and_click_on_delete_site_option() {
        DeepFreezeSuitePg.SearchNewlyCreatedSiteAndClickOnDelete();
        log.info("Searched and clicked delete on newly added site.");
      //  ExtentReportManager.logStep(Status.INFO, "Searched and clicked delete on newly added site.");
    }

    @Then("Verified site is deleted successfully")
    public void verified_site_is_deleted_successfully() {
        DeepFreezeSuitePg.VerifySiteisDeletedProperlyusingToastMsg();
        log.info("Verified site deleted successfully.");
    //    ExtentReportManager.logStep(Status.INFO, "Verified site deleted successfully.");
    }

    @Then("Search newly added site name under search field and click on Edit site option")
    public void search_newly_added_site_name_under_search_field_and_click_on_edit_site_option() {
        DeepFreezeSuitePg.SearchNewlyAddedSiteNameAndClickOnEdit();
        log.info("Searched and clicked edit on newly added site.");
    //    ExtentReportManager.logStep(Status.INFO, "Searched and clicked edit on newly added site.");
    }

    @Then("Update Site Name and verified toast message: {string}")
    public void update_site_name_and_verified_toast_message(String string) {
        DeepFreezeSuitePg.UpdateSiteNameAndVerifywithToastMsg();
        log.info("Updated site name and verified toast message: " + string);
    //    ExtentReportManager.logStep(Status.INFO, "Updated site name and verified toast message: " + string);
    }

    @Then("select My sites option from dropdown")
    public void select_my_sites_option_from_dropdown() {
        DeepFreezeSuitePg.ClickOnMySiteOption();
        log.info("Selected My Sites option from dropdown.");
     //   ExtentReportManager.logStep(Status.INFO, "Selected My Sites option from dropdown.");
    }

    @Then("click on Add site button")
    public void click_on_add_site_button() {
        DeepFreezeSuitePg.ClickOnAddSiteButton();
        log.info("Clicked on Add Site button.");
      //  ExtentReportManager.logStep(Status.INFO, "Clicked on Add Site button.");
    }

    @Then("Enter Site Name and save")
    public void enter_site_name_and_save() {
        DeepFreezeSuitePg.EnterSiteNameUnderTXTField();
        log.info("Entered site name and saved.");
      //  ExtentReportManager.logStep(Status.INFO, "Entered site name and saved.");
    }

    @Then("Verified New Site added successfully using toast message {string}")
    public void verified_new_site_added_successfully_using_toast_message(String string) {
        DeepFreezeSuitePg.NewSiteAddedSuccessfullyToastMsg();
        log.info("Verified new site added successfully with toast: " + string);
      //  ExtentReportManager.logStep(Status.INFO, "Verified new site added successfully with toast: " + string);
    }

    ////////////////// My
    ////////////////// Profile///////////////////////////////////////////////////////////
    @Then("a popup toast message should appear as a {string}")
    public void a_popup_toast_message_should_appear_as_a(String string) {
        DeepFreezeSuitePg.verifyToastMessage("Profile successfully updated.");
        log.info("Verified popup toast message: " + string);
     //   ExtentReportManager.logStep(Status.INFO, "Verified popup toast message: " + string);
    }

    @Then("Set Password{string}")
    public void set_password(String string) {
        DeepFreezeSuitePg.ClickOnChangePassword();
        log.info("Set password initiated.");
     //   ExtentReportManager.logStep(Status.INFO, "Set password initiated.");
    }

    @Then("Set Password old {string}")
    public void set_password_old(String string) {
        DeepFreezeSuitePg.ClickOnChangePassword2();
        log.info("Set password initiated.");
     //   ExtentReportManager.logStep(Status.INFO, "Set password initiated.");
    }
 
    
    @Then("Click on My Profile")
    public void click_on_my_profile() {
        DeepFreezeSuitePg.MyProfile();
        log.info("Clicked on My Profile.");
     //   ExtentReportManager.logStep(Status.INFO, "Clicked on My Profile.");
    }

    @Then("Enter First Name and Last Name")
    public void enter_first_name_and_last_name() {
        DeepFreezeSuitePg.FNameAndLNameOfMyProfile();
        log.info("Entered first name and last name.");
      //  ExtentReportManager.logStep(Status.INFO, "Entered first name and last name.");
    }

    @Then("Enter Job Title")
    public void enter_job_title() {
        DeepFreezeSuitePg.JobTitle();
        log.info("Entered job title.");
    //    ExtentReportManager.logStep(Status.INFO, "Entered job title.");
    }

    @Then("Enter Company Name and Phone Number")
    public void enter_company_name_and_phone_number() {
        DeepFreezeSuitePg.EnterCompanyName();
        log.info("Entered company name and phone number.");
    //    ExtentReportManager.logStep(Status.INFO, "Entered company name and phone number.");
    }

    @Then("Click on Save")
    public void click_on_save() {
        DeepFreezeSuitePg.SaveButtonOnMyProfile();
        log.info("Clicked on Save.");
      //  ExtentReportManager.logStep(Status.INFO, "Clicked on Save.");
    }

    /////////////////// User Management
    /////////////////// Page/////////////////////////////////////////////////
    @Then("I click on delete X button and delete user")
    public void i_click_on_delete_x_button_and_delete_user() {
        DeepFreezeSuitePg.DeleteUser();
        log.info("Clicked delete button and deleted user.");
      //  ExtentReportManager.logStep(Status.INFO, "Clicked delete button and deleted user.");
    }

    @When("verified following error message is appeared not able to login {string}")
    public void verified_following_error_message_is_appeared_not_able_to_login(String string) {
        DeepFreezeSuitePg.LoggedinFailed();
        log.info("Verified login error message: " + string);
      //  driver.quit();
      ///  ExtentReportManager.logStep(Status.INFO, "Verified login error message: " + string);
    }
 
    @When("verified following error message is appeared {string}")
    public void verified_following_error_message_is_appeared(String string) {
        DeepFreezeSuitePg.DisabledAccountErrorMsaage();
        log.info("Verified error message: " + string);
     //   ExtentReportManager.logStep(Status.INFO, "Verified error message: " + string);
    }

    @Then("I click on disabled checkbox")
    public void i_click_on_disabled_checkbox() {
        DeepFreezeSuitePg.DisableCheckBoxOnEditUserWindow();
        log.info("Clicked on disabled checkbox.");
       // ExtentReportManager.logStep(Status.INFO, "Clicked on disabled checkbox.");
    }

    @Then("I click on Search and look for the newly created user")
    public void i_click_on_search_and_look_for_the_newly_created_user() throws InterruptedException {
        DeepFreezeSuitePg.SearchNewlyCreatedUser();
        Thread.sleep(5000);
        log.info("Searched for newly created user.");
     //   ExtentReportManager.logStep(Status.INFO, "Searched for newly created user.");
    }

    @Then("I click on Edit button")
    public void i_click_on_edit_button() {
        DeepFreezeSuitePg.EditBtn();
        log.info("Clicked on Edit button.");
       // ExtentReportManager.logStep(Status.INFO, "Clicked on Edit button.");
    }

    @Then("I update the First Name and Last Name")
    public void i_update_the_first_name_and_last_name() throws InterruptedException {
        DeepFreezeSuitePg.EditUser();
        log.info("Updated first name and last name.");
     //   ExtentReportManager.logStep(Status.INFO, "Updated first name and last name.");
    }

    @Then("I change the Permission")
    public void i_change_the_permission() {
        DeepFreezeSuitePg.PermissionDropdown();
        log.info("Changed permission.");
       // ExtentReportManager.logStep(Status.INFO, "Changed permission.");
    }

    @Then("I click on the Update button")
    public void i_click_on_the_update_button() {
        DeepFreezeSuitePg.UpdateBtn();
        log.info("Clicked on Update button.");
     //   ExtentReportManager.logStep(Status.INFO, "Clicked on Update button.");
    }

    @Then("a popup toast message should appear as {string}")
    public void a_popup_toast_message_should_appear_as(String string) {
        DeepFreezeSuitePg.UserUpdatedSuccessfullyToastMsg();
        log.info("Verified popup toast message: " + string);
  //      ExtentReportManager.logStep(Status.INFO, "Verified popup toast message: " + string);
    }

    @Then("open email destination: {string}")
    public void open_email_destination(String url) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.open();");
        tabs = new ArrayList<>(driver.getWindowHandles());
        // Switch to GuerrillaMail tab (2nd tab)
        driver.switchTo().window(tabs.get(1));
        driver.get(url);
        log.info("Opened email site: " + url);
       // ExtentReportManager.logStep(Status.INFO, "Opened email site: " + url);
        Thread.sleep(5000); // Ideally use explicit wait
    }
 
    @Then("click forget me button on gurrilla page")
    public void click_forget_me_button_on_gurrilla_page() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        DeepFreezeSuitePg.clickonforgetmebtn();
        Thread.sleep(2000);
        log.info("Clicked Forget Me button on Guerrilla page.");
       // ExtentReportManager.logStep(Status.INFO, "Clicked Forget Me button on Guerrilla page.");
    }

    @Then("Enter name: {string}")
    public void enter_name(String Nikhil) throws InterruptedException {
        DeepFreezeSuitePg.clickondomaintxtbox();
        Thread.sleep(2000);
        log.info("Entered name: " + Nikhil);
   //     ExtentReportManager.logStep(Status.INFO, "Entered name: " + Nikhil);
    }

    @Then("click on set button")
    public void click_on_set_button() throws InterruptedException {
        DeepFreezeSuitePg.clickonsetbuttong();
        Thread.sleep(2000);
        log.info("Clicked on Set button.");
     //   ExtentReportManager.logStep(Status.INFO, "Clicked on Set button.");
    }

    @Then("uncheck Scramble Address option")
    public void uncheck_scramble_address_option() throws InterruptedException {
        DeepFreezeSuitePg.uncheckscambleaddress();
        Thread.sleep(2000);
        log.info("Unchecked Scramble Address option.");
     //   ExtentReportManager.logStep(Status.INFO, "Unchecked Scramble Address option.");
    }

    @Then("click on the invitation email from deepfreeze")
    public void click_on_the_invitation_email_from_deepfreeze() throws InterruptedException {
        DeepFreezeSuitePg.clickoninvitemail();
        Thread.sleep(2000);
        log.info("Clicked on invitation email from DeepFreeze.");
   //     ExtentReportManager.logStep(Status.INFO, "Clicked on invitation email from DeepFreeze.");
    }

    @Then("Click on invite link for password change")
    public void click_on_invite_link_for_password_change() throws InterruptedException {
        DeepFreezeSuitePg.clickoninvitelink();
        // After clicking, new tab opens → switch to it (3rd tab)
        Thread.sleep(3000); // wait for new tab
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2)); // Set Password window
        log.info("Switched to Set Password tab");
    //    ExtentReportManager.logStep(Status.INFO, "Switched to Set Password tab");
        Thread.sleep(2000);
    }

    @Then("On Set Password page enter New Password {string}")
    public void on_set_password_page_enter_new_password(String string) {
        DeepFreezeSuitePg.enternewpassword();
        log.info("Entered new password on Set Password page.");
    //    ExtentReportManager.logStep(Status.INFO, "Entered new password on Set Password page.");
    }

    @Then("Enter Confirm New Password {string}")
    public void enter_confirm_new_password(String string) {
        DeepFreezeSuitePg.enterconfirmpassword();
        log.info("Entered confirm new password.");
     //   ExtentReportManager.logStep(Status.INFO, "Entered confirm new password.");
    }

    @Then("Click on OK")
    public void click_on_ok() throws InterruptedException {
        DeepFreezeSuitePg.enterokbtn();
        Thread.sleep(1000);
        log.info("Switched back to original Deep Freeze tab");
  //      ExtentReportManager.logStep(Status.INFO, "Switched back to original Deep Freeze tab");
        Thread.sleep(1000);
    }

    @Then("Click on SignIN")
    public void click_on_sign_in() {
        DeepFreezeSuitePg.clickonLoginBtn();
        log.info("Clicked on SignIN.");
    //    ExtentReportManager.logStep(Status.INFO, "Clicked on SignIN.");
    }

    @Then("On My Profile page click on save button")
    public void on_my_profile_page_click_on_save_button() throws InterruptedException {
        DeepFreezeSuitePg.onmyprofilepageclickonsavebtn();
        Thread.sleep(4000);
        DeepFreezeSuitePg.onmainpageclickonadgotitbtn();
        log.info("Clicked save button on My Profile page.");
      //  ExtentReportManager.logStep(Status.INFO, "Clicked save button on My Profile page.");
    }

    @Then("Verified following user are logged in {string}")
    public void verified_following_user_are_logged_in(String string) {
        DeepFreezeSuitePg.verifyLoggedInUser();
        log.info("Verified user logged in: " + string);
    //    ExtentReportManager.logStep(Status.INFO, "Verified user logged in: " + string);
        // Close Guerrilla tab (2nd tab)
        // driver.switchTo().window(tabs.get(1));
        // driver.close();
    }

    @Then("click on current user")
    public void click_on_current_user() throws InterruptedException {
        DeepFreezeSuitePg.clickoncurrentuser();
        log.info("Clicked on current user.");
      //  ExtentReportManager.logStep(Status.INFO, "Clicked on current user.");
    }

    @Then("Click on USER MANAGEMENT")
    public void click_on_user_management() {
        DeepFreezeSuitePg.clickonusermanagementbtn();
        log.info("Clicked on User Management.");
    //    ExtentReportManager.logStep(Status.INFO, "Clicked on User Management.");
    }

    @Then("on USER MANAGEMENT page click on Add User dropdown and select Add New User")
    public void on_user_management_page_click_on_add_user_dropdown_and_select_add_new_user() throws InterruptedException {
        DeepFreezeSuitePg.clickonadduserdropdown();
        Thread.sleep(2000);
        DeepFreezeSuitePg.clickonaddnewuser();
        Thread.sleep(2000);
        log.info("Clicked Add User dropdown and selected Add New User.");
    //    ExtentReportManager.logStep(Status.INFO, "Clicked Add User dropdown and selected Add New User.");
    }

    @Then("On Add User popup window enter First Name:{string}")
    public void on_add_user_popup_window_enter_first_name(String string) {
        DeepFreezeSuitePg.enterfirstname();
        log.info("Entered first name: " + string);
    //    ExtentReportManager.logStep(Status.INFO, "Entered first name: " + string);
    }

    @Then("Enter Last Name:{string}")
    public void enter_last_name(String string) {
        DeepFreezeSuitePg.enterlastname();
        log.info("Entered last name: " + string);
    //    ExtentReportManager.logStep(Status.INFO, "Entered last name: " + string);
    }

    @Then("Enter Email: {string}")
    public void enter_email(String string) throws InterruptedException {
        DeepFreezeSuitePg.enteremail();
        Thread.sleep(2000);
        log.info("Entered email: " + string);
     //   ExtentReportManager.logStep(Status.INFO, "Entered email: " + string);
    }

    @Then("Click OK")
    public void click_ok() throws InterruptedException {
        DeepFreezeSuitePg.okbtn();
        Thread.sleep(5000);
        log.info("Clicked OK.");
    //    ExtentReportManager.logStep(Status.INFO, "Clicked OK.");
    }

    @Then("New user added successfully")
    public void new_user_added_successfully() throws InterruptedException {
        DeepFreezeSuitePg.verifyUserAddedInTable("nikhil@sharklasers.com");
        Thread.sleep(2000);
        log.info("New user added successfully.");
    //    ExtentReportManager.logStep(Status.INFO, "New user added successfully.");
    }

    /////////////////////////////// Tags Management
    /////////////////////////////// Page//////////////////////////////
    @Then("Click Tags Management tab")
    public void click_tags_management_tab() {
        DeepFreezeSuitePg.clicktagmanagementtab();
        log.info("Clicked Tags Management tab.");
   //     ExtentReportManager.logStep(Status.INFO, "Clicked Tags Management tab.");
    }

    @Then("On Tag Management page click on Add Tickets")
    public void on_tag_management_page_click_on_add_tickets() {
        DeepFreezeSuitePg.ontagmanagementpageclickonaddtickets();
        log.info("Clicked Add Tickets on Tag Management page.");
     //   ExtentReportManager.logStep(Status.INFO, "Clicked Add Tickets on Tag Management page.");
    }

    @Then("Enter Ticket Tag under Add Ticket Tag text failed and save- {string}")
    public void enter_ticket_tag_under_add_ticket_tag_text_failed_and_save(String Test1) throws InterruptedException {
        DeepFreezeSuitePg.entertickettagunderaddtickettagtextfailedandsave();
        log.info("Entered ticket tag: " + Test1 + " and saved.");
   //     ExtentReportManager.logStep(Status.INFO, "Entered ticket tag: " + Test1 + " and saved.");
    }

    @Then("check ticket tag is added successfully.")
    public void check_ticket_tag_is_added_successfully() throws InterruptedException {
        DeepFreezeSuitePg.checkTicketTagIsAddedSuccessfully();
        log.info("Verified ticket tag added successfully.");
     //   ExtentReportManager.logStep(Status.INFO, "Verified ticket tag added successfully.");
    }

    @Then("click on delete X tab")
    public void click_on_delete_x_tab() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement tagElement = driver.findElement(By.xpath("//span[@class='abstractText']"));
        actions.moveToElement(tagElement).perform();
        Thread.sleep(2000);
        // 2. Locate the delete icon which becomes visible after hover
        WebElement deleteIcon = driver.findElement(By.xpath("//img[@title='Delete' and contains(@id,'deleteImage')]"));
        // 3. Click using JavaScript (since Actions.click() fails if hidden earlier)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", deleteIcon);
        System.out.println("✅ Clicked delete icon successfully.");
        Thread.sleep(3000);
        log.info("Clicked delete X tab.");
     //   ExtentReportManager.logStep(Status.INFO, "Clicked delete X tab.");
    }

    @Then("Are you sure you wish to delete the tag, click on Delete")
    public void are_you_sure_you_wish_to_delete_the_tag_click_on_delete() {
        DeepFreezeSuitePg.deletetagfromtickettag();
        log.info("Confirmed and clicked Delete for tag.");
     //   ExtentReportManager.logStep(Status.INFO, "Confirmed and clicked Delete for tag.");
    }

    @Then("Check Entered Ticket Tag is deleted properly")
    public void check_entered_ticket_tag_is_deleted_properly() throws InterruptedException {
        DeepFreezeSuitePg.verifyTicketTagDeleted();
        log.info("Verified ticket tag deleted properly.");
     //   ExtentReportManager.logStep(Status.INFO, "Verified ticket tag deleted properly.");
    }

    @Then("Click on Add Tags")
    public void click_on_add_tags() {
        DeepFreezeSuitePg.addtagnormal();
        log.info("Clicked on Add Tags.");
     //   ExtentReportManager.logStep(Status.INFO, "Clicked on Add Tags.");
    }

    @Then("Enter Tag name under Add Tag text failed and save- {string}")
    public void enter_tag_name_under_add_tag_text_failed_and_save(String Test1) throws InterruptedException {
        DeepFreezeSuitePg.entertagnametextbox();
        log.info("Entered tag name: " + Test1 + " and saved.");
    //    ExtentReportManager.logStep(Status.INFO, "Entered tag name: " + Test1 + " and saved.");
    }

    @Then("check Tag is added successfully.")
    public void check_tag_is_added_successfully() throws InterruptedException {
        DeepFreezeSuitePg.verifyTagIsAddedSuccessfully();
        log.info("Verified tag added successfully.");
     //   ExtentReportManager.logStep(Status.INFO, "Verified tag added successfully.");
    }

    @Then("click on delete X tab on Normal Tag")
    public void click_on_delete_x_tab_on_normal_tag() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement tagElement = driver.findElement(By.xpath("//span[@class='abstractText']"));
        actions.moveToElement(tagElement).perform();
        Thread.sleep(1000); // allow UI to update
        // 2. Locate the delete icon which becomes visible after hover
        WebElement deleteIcon = driver.findElement(By.xpath("//img[@title='Delete' and contains(@id,'deleteImage')]"));
        // 3. Click using JavaScript (since Actions.click() fails if hidden earlier)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", deleteIcon);
        System.out.println("✅ Clicked delete icon successfully.");
        log.info("Clicked delete X tab on normal tag.");
      //  ExtentReportManager.logStep(Status.INFO, "Clicked delete X tab on normal tag.");
    }

    @Then("Are you sure you wish to delete the tag normal, click on Delete")
    public void are_you_sure_you_wish_to_delete_the_tag_normal_click_on_delete() {
        DeepFreezeSuitePg.deletetagfromtickettag();
        log.info("Confirmed and clicked Delete for normal tag.");
      //  ExtentReportManager.logStep(Status.INFO, "Confirmed and clicked Delete for normal tag.");
    }

    @Then("Check Entered Normal Tag is deleted properly")
    public void check_entered_normal_tag_is_deleted_properly() throws InterruptedException {
        DeepFreezeSuitePg.verifyNormalTagDeleted();
        log.info("Verified normal tag deleted properly.");
     //   ExtentReportManager.logStep(Status.INFO, "Verified normal tag deleted properly.");
    }

    @Then("Click on Add Location Tags")
    public void click_on_add_location_tags() {
        DeepFreezeSuitePg.addtaglocationtag();
        log.info("Clicked on Add Location Tags.");
       // ExtentReportManager.logStep(Status.INFO, "Clicked on Add Location Tags.");
    }

    @Then("Enter Location Tag name under Add Location Tag text failed and save- {string}")
    public void enter_location_tag_name_under_add_location_tag_text_failed_and_save(String string) throws InterruptedException {
        DeepFreezeSuitePg.enterlocationtagname();
        log.info("Entered location tag name: " + string + " and saved.");
     //   ExtentReportManager.logStep(Status.INFO, "Entered location tag name: " + string + " and saved.");
    }

    @Then("check Location Tag is added successfully.")
    public void check_location_tag_is_added_successfully() throws InterruptedException {
        DeepFreezeSuitePg.verifyTagIsAddedSuccessfullyinlocationtag();
        log.info("Verified location tag added successfully.");
       // ExtentReportManager.logStep(Status.INFO, "Verified location tag added successfully.");
    }

    @Then("click on delete X tab on Location Tag")
    public void click_on_delete_x_tab_on_location_tag() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement tagElement = driver.findElement(By.xpath("//span[@class='abstractText']"));
        actions.moveToElement(tagElement).perform();
        Thread.sleep(1000); // allow UI to update
        // 2. Locate the delete icon which becomes visible after hover
        WebElement deleteIcon = driver.findElement(By.xpath("//img[@title='Delete' and contains(@id,'deleteImage')]"));
        // 3. Click using JavaScript (since Actions.click() fails if hidden earlier)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", deleteIcon);
        System.out.println("✅ Clicked delete icon successfully.");
        log.info("Clicked delete X tab on location tag.");
      //  ExtentReportManager.logStep(Status.INFO, "Clicked delete X tab on location tag.");
    }

    @Then("Are you sure you wish to delete the tag Location, click on Delete")
    public void are_you_sure_you_wish_to_delete_the_tag_location_click_on_delete() {
        DeepFreezeSuitePg.clickondeletelocationtagbutton();
        log.info("Confirmed and clicked Delete for location tag.");
      //  ExtentReportManager.logStep(Status.INFO, "Confirmed and clicked Delete for location tag.");
    }

    @Then("Check Entered Location Tag is deleted properly")
    public void check_entered_location_tag_is_deleted_properly() throws InterruptedException {
        DeepFreezeSuitePg.verifyLocationTagDeleted();
        log.info("Verified location tag deleted properly.");
    //    ExtentReportManager.logStep(Status.INFO, "Verified location tag deleted properly.");
    }

    ////////////////////////////// launch
    ////////////////////////////// browser////////////////////////////////////
    @Given("Launch Chrome Browser")
    public void launch_chrome_browser() {
        DeepFreezeSuitePg = new PageObjectForDeepFreezeSuite(driver);
        log.info("user launch chrome browser");
     //   ExtentReportManager.logStep(Status.INFO, "user launch chrome browser");
    }

    @When("Opens URL {string}")
    public void opens_url(String url) {
        driver.get(url);
        log.info("Opened URL: " + url);
      //  ExtentReportManager.logStep(Status.INFO, "Opened URL: " + url);
    }

    @When("Enters Email as {string}")
    public void enters_email_as(String emailAddress) {
        DeepFreezeSuitePg.enterEmailID(emailAddress);
        log.info("Entered email address.");
      //  ExtentReportManager.logStep(Status.INFO, "Entered email address.");
    }

    @When("Click on NextButton")
    public void click_on_next_button() {
        DeepFreezeSuitePg.clickonNextBtn();
        log.info("Clicked on next.");
      //  ExtentReportManager.logStep(Status.INFO, "Clicked on next.");
    }

    @When("Enter Password as {string}")
    public void enter_password_as(String pwd) {
        DeepFreezeSuitePg.enterPass(pwd);
        log.info("Entered password.");
     //   ExtentReportManager.logStep(Status.INFO, "Entered password.");
    }

    @When("Click on Login")
    public void click_on_login() {
        DeepFreezeSuitePg.clickonLoginBtn();
        log.info("Clicked on login.");
      //  ExtentReportManager.logStep(Status.INFO, "Clicked on login.");
    }

    @Then("Page Title Should be {string}")
    public void page_title_should_be(String expectedTitle) {
        driver.navigate().refresh();
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            log.info("Page title matched.");
           // ExtentReportManager.logStep(Status.PASS, "Page title matched.");
            Assert.assertTrue(true);
        } else {
            log.warn("Page title did not match. Actual: " + actualTitle);
          //  ExtentReportManager.logStep(Status.FAIL, "Page title did not match. Actual: " + actualTitle);
            Assert.fail("Title mismatch");
        }
        driver.navigate().refresh();
    }

    @Then("click on logoutmenu")
    public void click_on_logoutmenu() {
        DeepFreezeSuitePg.clickonlogoutmenubtn();
        log.info("Clicked on logout menu.");
       // ExtentReportManager.logStep(Status.INFO, "Clicked on logout menu.");
    }

    @Then("click on Logout")
    public void click_on_logout() throws InterruptedException {
        DeepFreezeSuitePg.clicklogoutbtn();
        Thread.sleep(2000);
        log.info("Clicked on Logout.");
       // ExtentReportManager.logStep(Status.INFO, "Clicked on Logout.");
    }

    @Then("Close browser")
    public void close_browser() {
        driver.close();
        log.info("Close browser step executed but browser will close only after all scenarios.");
      //  ExtentReportManager.logStep(Status.INFO, "Close browser step executed but browser will close only after all scenarios.");
    }

    ///////////////// download policy///////////////////
    @Then("click on Policy tab")
    public void click_on_policy_tab() {
        DeepFreezeSuitePg.clickOnPolicyTabbtn();
        log.info("Clicked on Policy tab.");
       // ExtentReportManager.logStep(Status.INFO, "Clicked on Policy tab.");
    }

    @Then("click on Add Policy button")
    public void click_on_add_policy_button() {
        DeepFreezeSuitePg.clickonAddPolictbtn();
        log.info("Clicked on Add Policy button.");
     //   ExtentReportManager.logStep(Status.INFO, "Clicked on Add Policy button.");
    }

    @Then("Select policy type Deep Freeze Windows")
    public void select_policy_type_deep_freeze_windows() {
        DeepFreezeSuitePg.selectPolicyTypeDeepFreezeWindow();
        log.info("Selected policy type: Deep Freeze Windows.");
      //  ExtentReportManager.logStep(Status.INFO, "Selected policy type: Deep Freeze Windows.");
    }

    @Then("Enter Policy Name as {string}")
    public void enter_policy_name_as(String Test) {
        DeepFreezeSuitePg.PolicyName(Test);
        log.info("Entered policy name: " + Test);
       // ExtentReportManager.logStep(Status.INFO, "Entered policy name: " + Test);
    }

    @Then("Select DEEP FREEZE Product")
    public void select_deep_freeze_product() throws InterruptedException {
        DeepFreezeSuitePg.SelectDeepFreezeProduct();
        log.info("Selected DEEP FREEZE Product.");
      //  ExtentReportManager.logStep(Status.INFO, "Selected DEEP FREEZE Product.");
    }

    @Then("Click for Enable DeepFreeze Product")
    public void click_for_enable_deep_freeze_product() {
        DeepFreezeSuitePg.ClickTOEnable();
        log.info("Clicked to enable DeepFreeze Product.");
     //   ExtentReportManager.logStep(Status.INFO, "Clicked to enable DeepFreeze Product.");
    }

    @Then("Select Deep Freeze setting as {string}")
    public void select_deep_freeze_setting_as(String settingValue) throws InterruptedException {
        DeepFreezeSuitePg.selectDeepFreezeSetting(settingValue);
        log.info("Selected Deep Freeze setting: " + settingValue);
      //  ExtentReportManager.logStep(Status.INFO, "Selected Deep Freeze setting: " + settingValue);
    }

    @Then("Save the policy")
    public void save_the_policy() throws InterruptedException {
        DeepFreezeSuitePg.SavePolicybtn();
        log.info("Saved the policy.");
    //    ExtentReportManager.logStep(Status.INFO, "Saved the policy.");
    }

    @Then("Click on Download Agent")
    public void click_on_download_agent() {
        DeepFreezeSuitePg.DownloadAgentbtn();
        log.info("Clicked on Download Agent.");
       // ExtentReportManager.logStep(Status.INFO, "Clicked on Download Agent.");
    }

    @Then("Select newly created policy from Policy: dropdown")
    public void select_newly_created_policy_from_policy_dropdown() throws InterruptedException {
        DeepFreezeSuitePg.selectnNewlyCreatedPolicy();
        log.info("Selected newly created policy from dropdown.");
      //  ExtentReportManager.logStep(Status.INFO, "Selected newly created policy from dropdown.");
    }

    @Then("Select download type {string}")
    public void select_download_type(String string) {
        DeepFreezeSuitePg.SelectDownloadType();
        log.info("Selected download type: " + string);
      //  ExtentReportManager.logStep(Status.INFO, "Selected download type: " + string);
    }

    @Then("Click on Download button")
    public void click_on_download_button() throws InterruptedException {
        DeepFreezeSuitePg.Downloadbtn();
        log.info("Clicked on Download button.");
       // ExtentReportManager.logStep(Status.INFO, "Clicked on Download button.");
    }

    @Then("Windows installer downloaded successfully")
    public void verify_agent_download() {
        String downloadDir = System.getProperty("user.dir") + File.separator + "Download";
        String expectedFile = "FWAWebInstaller_Test.exe";
        boolean isDownloaded = FileUtils.isFileDownloaded(downloadDir, expectedFile, 100);
        Assert.assertTrue("❌ Download failed!", isDownloaded);
        log.info("Windows installer downloaded successfully.");
       // ExtentReportManager.logStep(Status.INFO, "Windows installer downloaded successfully.");
    }

    //////////////// Download MSI installer to deploy via Active
    //////////////// Directory.///////////////
    @Then("Select MSI download type {string}")
    public void select_msi_download_type(String string) {
        DeepFreezeSuitePg.SelectMSIDownloadType();
        log.info("Selected MSI download type: " + string);
     //   ExtentReportManager.logStep(Status.INFO, "Selected MSI download type: " + string);
    }

    @Then("MSI installer downloaded successfully")
    public void msi_installer_downloaded_successfully() {
        String downloadDir = System.getProperty("user.dir") + File.separator + "Download";
        String expectedFileName = "WebAgent_Test.msi";
        boolean isDownloaded = Utilities.FileUtils.isFileDownloaded(downloadDir, expectedFileName, 3600);
        Assert.assertTrue("❌ Agent download failed!", isDownloaded);
        log.info("MSI installer downloaded successfully.");
       // ExtentReportManager.logStep(Status.INFO, "MSI installer downloaded successfully.");
    }

    ///////////// Download the Deployment Utility to detect and install on any
    ///////////// computer.///////////////////////
    @Then("Select Deployment Utility type {string}")
    public void select_deployment_utility_type(String string) {
        DeepFreezeSuitePg.SelectDeploymentUtilityType();
        log.info("Selected Deployment Utility type: " + string);
       // ExtentReportManager.logStep(Status.INFO, "Selected Deployment Utility type: " + string);
    }

    @Then("Deployment Utility downloaded successfully")
    public void deployment_utility_downloaded_successfully() {
        String downloadDir = System.getProperty("user.dir") + File.separator + "Download";
        String expectedFileName = "DeploymentUtility_Test.exe";
        boolean isDownloaded = Utilities.FileUtils.isFileDownloaded(downloadDir, expectedFileName, 30);
        Assert.assertTrue("❌ Agent download failed!", isDownloaded);
        log.info("Deployment Utility downloaded successfully.");
       // ExtentReportManager.logStep(Status.INFO, "Deployment Utility downloaded successfully.");
    }

    @Then("Select Full Installer type {string}")
    public void select_full_installer_type(String string) {
        DeepFreezeSuitePg.SelectFullInstallerType();
        log.info("Selected Full Installer type: " + string);
      //  ExtentReportManager.logStep(Status.INFO, "Selected Full Installer type: " + string);
    }

    @Then("Full Installer downloaded successfully")
    public void full_installer_downloaded_successfully() throws InterruptedException {
        String downloadDir = System.getProperty("user.dir") + File.separator + "Download";
        String expectedFileName = "FullFWAWebInstaller_Test.exe";
        boolean isDownloaded = Utilities.FileUtils.isFileDownloaded(downloadDir, expectedFileName, 3600);
        Assert.assertTrue("❌ Agent download failed!", isDownloaded);
        log.info("Full Installer downloaded successfully.");
    //    ExtentReportManager.logStep(Status.INFO, "Full Installer downloaded successfully.");
    }

    @Then("Click on Download button for download Full Installer")
    public void click_on_download_button_for_download_full_installer() throws InterruptedException {
        DeepFreezeSuitePg.Downloadbtnn();
        log.info("Clicked Download button for Full Installer.");
      //  ExtentReportManager.logStep(Status.INFO, "Clicked Download button for Full Installer.");
    }

    @Then("Select downloader type- Windows Server")
    public void select_downloader_type_windows_server() {
        DeepFreezeSuitePg.SelectDownloaderTypeWindowsServer();
        log.info("Selected downloader type: Windows Server.");
      //  ExtentReportManager.logStep(Status.INFO, "Selected downloader type: Windows Server.");
    }

    @Then("Windows Server Installer downloaded successfully")
    public void windows_server_installer_downloaded_successfully() throws InterruptedException {
        String downloadDir = System.getProperty("user.dir") + File.separator + "Download";
        String expectedFileName = "FWAWebInstaller_Faronics Default Server.exe";
        boolean isDownloaded = Utilities.FileUtils.isFileDownloaded(downloadDir, expectedFileName, 30);
        Assert.assertTrue("❌ Agent download failed!", isDownloaded);
        log.info("Windows Server Installer downloaded successfully.");
      //  ExtentReportManager.logStep(Status.INFO, "Windows Server Installer downloaded successfully.");
    }

    @Then("Select downloader type- Mac")
    public void select_downloader_type_mac() {
        DeepFreezeSuitePg.SelectDownloaderTypeMac();
        log.info("Selected downloader type: Mac.");
    //    ExtentReportManager.logStep(Status.INFO, "Selected downloader type: Mac.");
    }

    @Then("Mac Installer downloaded successfully")
    public void mac_installer_downloaded_successfully() throws InterruptedException {
        String downloadDir = System.getProperty("user.dir") + File.separator + "Download";
        String expectedFileName = "Installer.zip";
        boolean isDownloaded = Utilities.FileUtils.isFileDownloaded(downloadDir, expectedFileName, 30);
        Assert.assertTrue("❌ Agent download failed!", isDownloaded);
        log.info("Mac Installer downloaded successfully.");
      //  ExtentReportManager.logStep(Status.INFO, "Mac Installer downloaded successfully.");
    }

    //////////////////////////////////////////Product install and  uninstall using policy////////////////////////////////////////
    @Then("Click on Computers Page")
    public void click_on_computers_page() {
        DeepFreezeSuitePg.clickonComputersPage();
        log.info("Clicked on Computers Page.");
       // ExtentReportManager.logStep(Status.INFO, "Clicked on Computers Page.");
    }

    

    @Then("Search Computer Name {string}")
    public void search_computer_name(String computerName) throws InterruptedException {
        DeepFreezeSuitePg.searchComputerByName(computerName);
        log.info("Searched for computer name: " + computerName);
      //  ExtentReportManager.logStep(Status.INFO, "Searched for computer name: " + computerName);
    }

    @Then("click on assigned policy name")
    public void click_on_assigned_policy_name() {
        DeepFreezeSuitePg.ClickOnPolicyName();
        log.info("Clicked on assigned policy name.");
      //  ExtentReportManager.logStep(Status.INFO, "Clicked on assigned policy name.");
    }

    
    @Then("Enable DeepFreeze Product- WINSELECT")
    public void enable_deep_freeze_product_winselect() {
        DeepFreezeSuitePg.ClickONWINSELECT();
        log.info("Enabled DeepFreeze Product - WINSELECT.");
       // ExtentReportManager.logStep(Status.INFO, "Enabled DeepFreeze Product - WINSELECT.");
    }

    @Then("Click on Save button")
    public void click_on_save_button() {
        DeepFreezeSuitePg.Savebtn();
        log.info("Clicked on Save button.");
      //  ExtentReportManager.logStep(Status.INFO, "Clicked on Save button.");
    }

    @Then("On Policy Update Preference window select- Notify the user immediately when the computer checks-in and restart after {int} minutes.")
    public void on_policy_update_preference_window_select_notify_the_user_immediately_when_the_computer_checks_in_and_restart_after_minutes(Integer int1) {
        DeepFreezeSuitePg.checkradiobtn();
        log.info("Selected policy update preference with restart after " + int1 + " minutes.");
      //  ExtentReportManager.logStep(Status.INFO, "Selected policy update preference with restart after " + int1 + " minutes.");
    }

    @Then("On Policy Update Preference window click OK")
    public void on_policy_update_preference_window_click_ok() {
        DeepFreezeSuitePg.clickok();
        log.info("Clicked OK on Policy Update Preference window.");
      //  ExtentReportManager.logStep(Status.INFO, "Clicked OK on Policy Update Preference window.");
    }

    @Then("check WINSELECT status indicator should be green")
    public void check_winselect_status_indicator_should_be_green() {
        log.info("⏳ Waiting for WINSELECT to be installed and status to appear (Enabled / Outdated)...");
        boolean statusIsGreen = DeepFreezeSuitePg.waitForWinSelectInstalledAndHover(3600); // 1 hour wait
        Assert.assertTrue("❌ WINSELECT not installed or mouse hover failed.", statusIsGreen);
        log.info("✅ WINSELECT status verified and mouse hover held for 30 seconds.");
    //    ExtentReportManager.logStep(Status.INFO, "WINSELECT status verified and mouse hover held for 30 seconds.");
    }

    @Then("Mouse hover on the WINSELECT status indicator")
    public void mouse_hover_on_the_winselect_status_indicator() {
        log.info("✅ Mouse hover already performed during status check.");
      //  ExtentReportManager.logStep(Status.INFO, "Mouse hover already performed during status check.");
    }

    @Then("Click on product dropdown")
    public void click_on_product_dropdown() {
        DeepFreezeSuitePg.ClickOnDisablePolicyDropdown();
        log.info("Click on product dropdown.");
      //  ExtentReportManager.logStep(Status.INFO, "Click on product dropdown.");
    }

    @Then("Disable DeepFreeze Product- WINSELECT")
    public void disable_deep_freeze_product_winselect() {
        DeepFreezeSuitePg.disabledproductfromdropdown();
        log.info("Disabled product from dropdown.");
     //   ExtentReportManager.logStep(Status.INFO, "Disabled product from dropdown.");
    }

    @Then("check WINSELECT status indicator should be grey")
    public void check_winselect_status_indicator_should_be_grey() {
        log.info("⏳ Waiting for WINSELECT to be uninstalled (status grey)...");
        boolean isUninstalled = DeepFreezeSuitePg.waitForWinSelectUninstalledAndHover(3600); // 1 hour
        Assert.assertTrue("❌ WINSELECT not uninstalled or hover failed.", isUninstalled);
        log.info("✅ WINSELECT status is grey and hover held for 30 seconds.");
       // ExtentReportManager.logStep(Status.INFO, "WINSELECT status is grey and hover held for 30 seconds.");
    }

    /////////////////////////////////////////////////////////////////////////////////////////
}