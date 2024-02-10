package application;

public class FlightSearch {
    private final String from;
    private final String to;
    private final String date;
    private final Boolean isRoundTrip;
    private final Integer numberOfPassengers;

    public FlightSearch(
            String from,
            String to,
            String date,
            Boolean isRoundTrip,
            Integer numberOfPassengers
    ) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.isRoundTrip = isRoundTrip;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getOrigin() {
        return from;
    }

    public String getDestination() {
        return to;
    }

    public String getDepartureDate() {
        return date;
    }

    public Boolean getIsRoundTrip() {
        return isRoundTrip;
    }

    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }

    @Override
    public String toString() {
        return (
            "FlightSearch{" +
            "from='" + from + '\'' +
            ", to='" + to + '\'' +
            ", date='" + date + '\'' +
            ", isRoundTrip=" + isRoundTrip +
            ", numberOfPassengers='" + numberOfPassengers + '\'' +
            '}'
        );
    }
}
