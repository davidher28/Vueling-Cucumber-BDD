package stepdefs;

import domain.FlightSearch;
import builders.FlightSearchBuilder;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.FlightSearchResultsPage;
import pages.FlightSearchPage;

import java.lang.invoke.MethodHandles;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class FlightSearchSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private FlightSearchPage flightSearchPage;
    private FlightSearchResultsPage flightSearchResultsPage;

    @DataTableType
    public FlightSearch __(Map<String, String> row) {
        return new FlightSearchBuilder()
            .setOrigin(row.get("from"))
            .setDestination(row.get("to"))
            .setDepartureDate(row.get("date"))
            .setReturnDate(row.get("returnDate"))
            .setNumberOfPassengers(Integer.valueOf(row.get("numberOfPassengers")))
            .build();
    }

    @Given("I have navigated to the vueling website")
    public void iHaveNavigatedToTheVuelingWebsite() throws Throwable {
        LOGGER.debug("iHaveNavigatedToTheVuelingWebsite starts");

        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String vuelingUrl = variables.getProperty("WEB_URL");

        // Open the Vueling website
        flightSearchPage.openAt(vuelingUrl);
    }

    @When("I search a flight with the following characteristics:")
    public void iSearchAFlightWithTheFollowingCharacteristics(
            FlightSearch flightSearch
    ) throws Throwable {
        LOGGER.debug("iSearchAFlightWithTheFollowingCharacteristics starts");

        // Perform the flights search
        flightSearchPage.performFlightSearch(flightSearch);
    }

    @Then("I get the available flights in the flight results list")
    public void iGetTheAvailableFlightsInTheFlightResultsList() throws Throwable {
        LOGGER.debug("iGetTheAvailableFlightsInTheFlightResultsList starts");

        // Verify there are available flights in the results page for the performed search
        assertTrue(flightSearchResultsPage.getFlightResultsNumber() > 0);
    }
}
