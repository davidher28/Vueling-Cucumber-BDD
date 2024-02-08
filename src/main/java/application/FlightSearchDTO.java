package application;

public class FlightSearchDTO {
    private final String from;
    private final String to;
    private final String date;
    private final Boolean round_trip;
    private final String number_of_passengers;

    public FlightSearchDTO(
            String from,
            String to,
            String date,
            Boolean round_trip,
            String number_of_passengers
    ) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.round_trip = round_trip;
        this.number_of_passengers = number_of_passengers;
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

    @Override
    public String toString() {
        return "FlightSearchDTO{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date='" + date + '\'' +
                ", round_trip=" + round_trip +
                ", number_of_passengers='" + number_of_passengers + '\'' +
                '}';
    }
}
