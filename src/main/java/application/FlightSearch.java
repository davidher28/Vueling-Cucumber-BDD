package application;

public class FlightSearch {

    private final String from;
    private final String to;
    private final String date;
    private final String returnDate;
    private final Boolean isRoundTrip;
    private final Integer numberOfPassengers;

    public FlightSearch(
        String from,
        String to,
        String date,
        String returnDate,
        Integer numberOfPassengers
    ) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.returnDate = returnDate;
        this.isRoundTrip = date != null && returnDate != null;
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

    public String getReturnDate() {
        return returnDate;
    }

    public Boolean getIsRoundTrip() {
        return isRoundTrip;
    }

    @Override
    public String toString() {
        return (
            "FlightSearch{" +
            "from='" + from + '\'' +
            ", to='" + to + '\'' +
            ", date='" + date + '\'' +
            ", returnDate='" + returnDate + '\'' +
            ", isRoundTrip=" + isRoundTrip + '\'' +
            ", numberOfPassengers='" + numberOfPassengers + '\'' +
            '}'
        );
    }
}
