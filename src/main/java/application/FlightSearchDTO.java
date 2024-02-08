package application;

public class FlightSearchDTO {
    private final String from;
    private final String to;
    private final String date;
    private final Boolean round_trip;
    private final String number_of_passengers;

    public FlightSearchDTO() {
        this.from = "Madrid";
        this.to = "Barcelona";
        this.date = "01/06/2024";
        this.round_trip = false;
        this.number_of_passengers = "1";
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
