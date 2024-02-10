package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import application.FlightSearch;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

public class FlightSearchPage extends PageObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id="onetrust-accept-btn-handler")
    private WebElementFacade cookiesHandler;
    private WebElementFacade originInput;
    private WebElementFacade destinationInput;
    private WebElementFacade outboundDate;
    private WebElementFacade oneWayLabel;
    private WebElementFacade btnSubmitHomeSearcher;

    public void performFlightSearch(FlightSearch flightSearch) {
        LOGGER.debug("performFlightSearch starts, search entity: [{}]", flightSearch);

        // Accept cookies modal
        cookiesHandler.click();

        // Fill in the origin
        originInput.typeAndEnter(flightSearch.getOrigin());

        // Fill in the destination
        destinationInput.typeAndEnter(flightSearch.getDestination());

        // Choose one way flights
        oneWayLabel.click();

        // Fill in the outbound date
        outboundDate.sendKeys(flightSearch.getDepartureDate());

        // Submit the search
        btnSubmitHomeSearcher.click();

        // Ignore Booking.com Promotional Tab
        String flightResultsTab = new ArrayList<>(getDriver().getWindowHandles()).get(1);
        getDriver().switchTo().window(flightResultsTab);
    }
}
