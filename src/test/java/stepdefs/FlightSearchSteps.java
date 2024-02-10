package stepdefs;

import application.FlightSearch;
import builders.FlightSearchBuilder;
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
import pages.FlightSearchListPage;
import pages.FlightSearchPage;

import java.lang.invoke.MethodHandles;
import java.util.Map;

public class FlightSearchSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private FlightSearchPage flightSearchPage;
    private FlightSearchListPage flightSearchListPage;

    @Before
    public void beforeScenario() {
        LOGGER.debug("beforeScenario starts");
    }

    @After
    public void afterScenario() {
        LOGGER.debug("afterScenario starts");
    }

    @DataTableType
    public FlightSearch __(Map<String, String> row) {
        return new FlightSearchBuilder()
                .setOrigin(row.get("from"))
                .setDestination(row.get("to"))
                .setDepartureDate(row.get("date"))
                .setIsRoundTrip(row.get("isRoundTrip").equals("true"))
                .setNumberOfPassengers(row.get("numberOfPassengers"))
                .build();
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
            FlightSearch flightSearch
    ) throws Throwable {
        LOGGER.debug("iSearchAFlightWithTheFollowingCharacteristics starts");

        flightSearchPage.performFlightSearch(flightSearch);
    }

    @Then("I get the available flights in the flights list")
    public void iGetTheAvailableFlightsInTheFlightsList() throws Throwable {
        LOGGER.debug("iGetTheAvailableFlightsInTheFlightsList starts");

        flightSearchListPage.waitForFlightCards();
    }
}
