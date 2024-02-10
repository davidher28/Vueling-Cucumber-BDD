package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class FlightSearchResultsPage extends PageObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private WebElementFacade flightCardsContainer;

    public int getFlightResultsNumber() {
        LOGGER.debug("getFlightResultsNumber starts");

        int flightsNumber = flightCardsContainer.findElements(
                By.className("trip-selector_item")
        ).size();
        LOGGER.debug("getFlightResultsNumber ends, number of flights: [{}]", flightsNumber);

        return flightsNumber;
    }
}
