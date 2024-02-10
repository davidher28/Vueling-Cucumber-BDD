package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class FlightSearchListPage extends PageObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private WebElementFacade flightCardsContainer;

    public void waitForFlightCards() {
        LOGGER.debug("waitForFlightCards starts");

        // Wait for the flight cards to be visible
        flightCardsContainer.shouldBePresent();
    }
}
