package builders;

import domain.FlightSearch;

public class FlightSearchBuilder {

    private String from;
    private String to;
    private String date;
    private String returnDate;
    private Integer numberOfPassengers;

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

    public FlightSearchBuilder setReturnDate(String returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public FlightSearchBuilder setNumberOfPassengers(Integer numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
        return this;
    }

    public FlightSearch build() {
        return new FlightSearch(from, to, date, returnDate, numberOfPassengers);
    }
}
