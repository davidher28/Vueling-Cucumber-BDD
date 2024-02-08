package builders;


import application.FlightSearchDTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightSearchDataBuilder {
    public static FlightSearchDTO defaultSearch() {
        return FlightSearchBuilder
                .aFlightSearch()
                .withOrigin("Madrid")
                .withDestination("Barcelona")
                .withDepartureDate("2024/06/01")
                .withRoundTrip(false)
                .withNumberOfPassengers("1")
                .build();
    }
}
