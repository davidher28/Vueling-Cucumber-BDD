package builders;

import application.FlightSearchDTO;

public class FlightSearchBuilder {
    private String from;
    private String to;
    private String date;
    private Boolean round_trip;
    private String number_of_passengers;

    public static FlightSearchBuilder aFlightSearch() {
        return new FlightSearchBuilder();
    }

    public FlightSearchBuilder withOrigin(String from) {
        this.from = from;
        return this;
    }

    public FlightSearchBuilder withDestination(String to) {
        this.to = to;
        return this;
    }

    public FlightSearchBuilder withDepartureDate(String date) {
        this.date = date;
        return this;
    }

    public FlightSearchBuilder withRoundTrip(Boolean round_trip) {
        this.round_trip = round_trip;
        return this;
    }

    public FlightSearchBuilder withNumberOfPassengers(String number_of_passengers) {
        this.number_of_passengers = number_of_passengers;
        return this;
    }

    public FlightSearchDTO build() {
        return new FlightSearchDTO();
    }
}
