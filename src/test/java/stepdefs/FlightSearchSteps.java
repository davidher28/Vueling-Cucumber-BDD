package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.FlightSearchPage;

import java.lang.invoke.MethodHandles;

public class FlightSearchSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final String HOME = "reservationList.html";

    private FlightSearchPage flightSearchPage;

    @Before
    public void beforeScenario() {
        LOGGER.debug("beforeScenario starts");
    }

    @After
    public void afterScenario() {
        LOGGER.debug("afterScenario starts");
    }

    @Given("I have navigated to the vueling website")
    public void i_have_navigated_to_the_vueling_website() throws Throwable {
        LOGGER.debug("i_have_navigated_to_vueling starts");

        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String vuelingUrl = variables.getProperty("VUELING_SITE");

        flightSearchPage.openAt(vuelingUrl);
    }

    @When("I search a flight with the following characteristics:")
    public void i_search_a_flight_with_the_following_characteristics() throws Throwable {
        LOGGER.debug("i_search_the_following_flight starts");

        // TODO: Complete this step
    }

    @Then("I get the flight alternatives in the flights list")
    public void i_get_the_flight_alternatives_in_the_flights_list() throws Throwable {
        LOGGER.debug("i_get_flights_in_the_flights_list starts");

        // TODO: Complete this step
    }
}
