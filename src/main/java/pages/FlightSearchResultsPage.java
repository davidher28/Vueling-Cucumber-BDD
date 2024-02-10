package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class FlightSearchResultsPage extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private WebElementFacade flightCardsContainer;

    public List<WebElement> getFlightResults() {
        LOGGER.debug("getFlightResults starts");

        List<WebElement> flightResults = flightCardsContainer.findElements(
            By.className("trip-selector_item")
        );

        LOGGER.debug("getFlightResultsNumber ends, number of flights: [{}]", flightResults.size());
        return flightResults;
    }
}
