package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import application.FlightSearch;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FlightSearchPage extends PageObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String CALENDAR_DAY_ELEMENT_PREFIX = "calendarDaysTable";

    @FindBy(id="onetrust-accept-btn-handler")
    private WebElementFacade cookiesHandler;
    private WebElementFacade originInput;
    private WebElementFacade destinationInput;
    private WebElementFacade prevButtonCalendar;
    private WebElementFacade nextButtonCalendar;
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

        // Choose one way flights if needed
        if (!flightSearch.getIsRoundTrip()) {
            oneWayLabel.click();
        }

        // Fill in the outbound date
        clickDesiredDate(flightSearch.getDepartureDate());

        // Submit the search
        btnSubmitHomeSearcher.click();

        // Ignore Booking.com Promotional Tab
        String flightResultsTab = new ArrayList<>(getDriver().getWindowHandles()).get(1);
        getDriver().switchTo().window(flightResultsTab);
    }

    private void clickDesiredDate(String date) {
        LocalDate currentDate = LocalDate.now();
        LocalDate desiredDate = LocalDate.parse(date, DATE_FORMATTER);

        // Navigate to the desired month interacting with the Vueling calendar
        adjustVuelingCalendar(
            calculateMonthDifference(currentDate, desiredDate)
        );

        String desiredDayElementId = constructElementId(desiredDate);
        WebElementFacade desiredDayElement = find(By.id(desiredDayElementId));
        desiredDayElement.click();
    }

    private Integer calculateMonthDifference(LocalDate currentDate, LocalDate desiredDate) {
        return desiredDate.getMonthValue() - currentDate.getMonthValue() +
                12 * (desiredDate.getYear() - currentDate.getYear());
    }

    private void adjustVuelingCalendar(Integer monthDiff) {
        WebElementFacade buttonToClick = monthDiff < 0
                ? prevButtonCalendar
                : nextButtonCalendar;

        for (int i = 0; i < Math.abs(monthDiff); i++) {
            buttonToClick.click();
        }
    }

    private String constructElementId(LocalDate date) {
        return String.format(
                "%s%s%s%s",
                CALENDAR_DAY_ELEMENT_PREFIX,
                date.getYear(),
                date.getMonthValue() - 1,
                date.getDayOfMonth()
        );
    }
}
