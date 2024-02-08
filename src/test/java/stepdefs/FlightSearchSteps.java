package stepdefs;

import application.FlightSearchDTO;
import builders.FlightSearchDataBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.FlightSearchPage;

import java.lang.invoke.MethodHandles;
import java.util.Map;

public class FlightSearchSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private FlightSearchPage flightSearchPage;

    @Before
    public void beforeScenario() {
        LOGGER.debug("beforeScenario starts");
    }

    @After
    public void afterScenario() {
        LOGGER.debug("afterScenario starts");
    }

    @DataTableType
    public FlightSearchDTO flightSearchEntryTransformer(Map<String, String> row) {
        return new FlightSearchDTO();
    }

    @Given("I have navigated to the vueling website")
    public void iHaveNavigatedToTheVuelingWebsite() throws Throwable {
        LOGGER.debug("iHaveNavigatedToTheVuelingWebsite starts");

        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String vuelingUrl = variables.getProperty("WEB_URL");

        flightSearchPage.openAt(vuelingUrl);
    }

    @When("I search a flight with the following characteristics:")
    public void iSearchAFlightWithTheFollowingCharacteristics(
            FlightSearchDTO flightSearchDTO
    ) throws Throwable {
        LOGGER.debug("iSearchAFlightWithTheFollowingCharacteristics starts");

        flightSearchPage.performFlightSearch(flightSearchDTO);
    }

    @Then("I get the flight alternatives in the flights list")
    public void iGetTheAvailableFlightsInTheFlightsList() throws Throwable {
        LOGGER.debug("iGetTheAvailableFlightsInTheFlightsList starts");

        // TODO: Complete this step
    }
}
