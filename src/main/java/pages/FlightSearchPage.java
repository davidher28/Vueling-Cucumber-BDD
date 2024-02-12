package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import domain.FlightSearch;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@DefaultUrl("https://www.vueling.com/es")
public class FlightSearchPage extends PageObject {

    private static final String CALENDAR_DAY_ELEMENT_PREFIX = "calendarDaysTable";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id="onetrust-accept-btn-handler")
    private WebElementFacade cookiesHandler;
    private WebElementFacade originInput;
    private WebElementFacade destinationInput;
    private WebElementFacade prevButtonCalendar;
    private WebElementFacade nextButtonCalendar;
    private WebElementFacade oneWayLabel;
    private WebElementFacade passengersInputLabel;
    private WebElementFacade adultsIncrease;
    private WebElementFacade btnSubmitHomeSearcher;

    public void performFlightSearch(FlightSearch flightSearch) {
        LOGGER.debug("performFlightSearch starts, search entity: [{}]", flightSearch);

        cookiesHandler.click();

        originInput.typeAndEnter(flightSearch.getOrigin());

        destinationInput.typeAndEnter(flightSearch.getDestination());

        fillInFlightDates(
            flightSearch.getDepartureDate(),
            flightSearch.getReturnDate(),
            flightSearch.getIsRoundTrip()
        );

        increaseNumberOfPassengers(flightSearch.getNumberOfPassengers());

        btnSubmitHomeSearcher.click();

        switchToVuelingTab();
    }

    private void fillInFlightDates(String departureDate, String returnDate, Boolean isRoundTrip) {
        clickDesiredDate(departureDate);
        if (isRoundTrip) {
            clickDesiredDate(returnDate, departureDate);
            return;
        }
        oneWayLabel.click();
    }

    private void increaseNumberOfPassengers(Integer numberOfPassengers) {
        passengersInputLabel.click();
        for (int i = 0; i < numberOfPassengers - 1; i++) {
            adultsIncrease.click();
        }
    }

    private void clickDesiredDate(String date, String... currentCalendarDate) {
        LocalDate currentDate = currentCalendarDate.length > 0
                ? LocalDate.parse(currentCalendarDate[0], DATE_FORMATTER)
                : LocalDate.now();
        LocalDate desiredDate = LocalDate.parse(date, DATE_FORMATTER);

        // Navigate to the desired month interacting through the Vueling calendar
        Integer monthDiff = calculateMonthDiff(currentDate, desiredDate);
        navigateVuelingCalendar(monthDiff);

        WebElementFacade desiredDayElement = find(By.id(
            constructCalendarDayId(desiredDate)
        ));
        desiredDayElement.click();
    }

    private void navigateVuelingCalendar(Integer monthDiff) {
        WebElementFacade calendarButton = monthDiff < 0
            ? prevButtonCalendar
            : nextButtonCalendar;

        for (int i = 0; i < Math.abs(monthDiff); i++) {
            calendarButton.click();
        }
    }

    private void switchToVuelingTab() {
        List<String> currentTabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(currentTabs.get(1));
    }

    private Integer calculateMonthDiff(LocalDate currentDate, LocalDate desiredDate) {
        return (
            desiredDate.getMonthValue() - currentDate.getMonthValue() +
            12 * (desiredDate.getYear() - currentDate.getYear())
        );
    }

    private String constructCalendarDayId(LocalDate date) {
        return String.format(
            "%s%s%s%s",
            CALENDAR_DAY_ELEMENT_PREFIX,
            date.getYear(),
            date.getMonthValue() - 1,
            date.getDayOfMonth()
        );
    }
}
