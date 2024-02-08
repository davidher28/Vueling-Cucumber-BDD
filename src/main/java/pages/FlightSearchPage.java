package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import application.FlightSearch;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class FlightSearchPage extends PageObjectBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElementFacade cookiesHandler;
    private WebElementFacade originInput;
    private WebElementFacade destinationInput;
    private WebElementFacade outboundDate;
    private WebElementFacade oneWayLabel;
    private WebElementFacade btnSubmitHomeSearcher;

    public void performFlightSearch(FlightSearch flightSearch) {
        LOGGER.debug("performFlightSearch starts, characteristics: [{}]", flightSearch);

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
    }
}
