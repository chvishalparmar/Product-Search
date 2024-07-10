package com.nagarro.training.steps;

import org.junit.Assert;

import com.training.Main;
import com.training.enums.Gender;
import com.training.enums.OutputPreference;
import com.training.enums.Size;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SearchTest {
	
	private Main mainService;
	

@Given("T-shirt data is loaded")
public void t_shirt_data_is_loaded() {
   mainService = new Main();
   String  csvFilePath = "src/main/java/resources/Adidas.csv";
   mainService.csvtolist(csvFilePath);
}


@When("the user searches for T-shirt with color {string}, size {string}, gender {string}, and output preference {string}")
public void the_user_searches_for_t_shirt_with_color_size_gender_and_output_preference(String string, String string2, String string3, String string4) {
    mainService.setColour(string);
    mainService.setSize(Size.valueOf(string2.toUpperCase()));
    mainService.setGender(Gender.valueOf(string3.toUpperCase()));
    mainService.setOutputpref(OutputPreference.valueOf(string4.toUpperCase()));
    mainService.search();
}


@Then("the user should see a list of matching products sorted by Price")
public void the_user_should_see_a_list_of_matching_products_sorted_by() {

   Assert.assertFalse(mainService.getResult().isEmpty());
    // Optionally print or verify the results
     mainService.printlist(mainService.getResult());
  
}
@Then("the user should see a list of matching T-shirts sorted by Price")
public void the_user_should_see_a_list_of_matching_T_shirts_sorted_by_Price() {
   Assert.assertFalse(mainService.getResult().isEmpty());
   // Optionally print or verify the results
    mainService.printlist(mainService.getResult());
}

@When("the user search for T-shirt with color {string}, size {string}, gender {string}, and output preference {string}")
public void the_user_search_for_T_shirt_with_color_size_gender_and_output_preference(String s, String s2, String s3, String s4) {
   mainService.setColour(s);
   mainService.setSize(Size.valueOf(s2.toUpperCase()));
   mainService.setGender(Gender.valueOf(s3.toUpperCase()));
   mainService.setOutputpref(OutputPreference.valueOf(s4.toUpperCase()));
   mainService.search();
}

@Then("the user should see a list of matching T-shirts sorted by {string}")
public void the_user_should_see_a_list_of_matching_T_shirts_sorted_by(String s) {
      Assert.assertFalse(mainService.getResult().isEmpty());
      // Optionally print or verify the results
       mainService.printlist(mainService.getResult());
}

@When("User search for T-shirts with color {string}, size {string}, gender {string}, and output preference {string}")
public void User_search_for_T_shirts_with_color_size_gender_and_output_preference(String s, String s2, String s3, String s4) {
      mainService.setColour(s);
      mainService.setSize(Size.valueOf(s2.toUpperCase()));
      mainService.setGender(Gender.valueOf(s3.toUpperCase()));
      mainService.setOutputpref(OutputPreference.valueOf(s4.toUpperCase()));
      mainService.search();
}

@Then("User should get a list of matching T-shirts sorted by both {string} and {string}")
public void User_should_get_a_list_of_matching_T_shirts_sorted_by_both_and(String s, String s2) {
      Assert.assertFalse(mainService.getResult().isEmpty());
      // Optionally print or verify the results
       mainService.printlist(mainService.getResult());
}


}
