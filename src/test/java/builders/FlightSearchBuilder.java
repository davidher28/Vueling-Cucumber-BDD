package builders;

import application.FlightSearchDTO;

public class FlightSearchBuilder {
    private String from;
    private String to;
    private String date;
    private Boolean round_trip;
    private String number_of_passengers;

    public FlightSearchBuilder setOrigin(String from) {
        this.from = from;
        return this;
    }

    public FlightSearchBuilder setDestination(String to) {
        this.to = to;
        return this;
    }

    public FlightSearchBuilder setDepartureDate(String date) {
        this.date = date;
        return this;
    }

    public FlightSearchBuilder setRoundTrip(Boolean round_trip) {
        this.round_trip = round_trip;
        return this;
    }

    public FlightSearchBuilder setNumberOfPassengers(String number_of_passengers) {
        this.number_of_passengers = number_of_passengers;
        return this;
    }

    public FlightSearchDTO build() {
        return new FlightSearchDTO(from, to, date, round_trip, number_of_passengers);
    }
}
