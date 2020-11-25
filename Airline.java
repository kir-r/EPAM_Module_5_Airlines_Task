import java.util.Calendar;
import java.util.GregorianCalendar;

public class Airline {

    /*Пункт назначения, Номер рейса, Тип самолета, Время вылета, Дни недели.*/

    private String destination;
    private int flightNumber;
    private String aircraftType;
    private String departureTime;
    private Days days;

    public Airline(String destination, int flightNumber, String aircraftType, String departureTime, Days days) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.departureTime = departureTime;
        this.days = days;
    }

    public String getDestination() {
        return destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public Days getDays() {
        return days;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setDays(Days days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Airline to " + destination + ":\n" +
                "destination: " + destination + "\n" +
                "flightNumber: " + flightNumber + "\n" +
                "aircraftType: " + aircraftType + "\n" +
                "departureTime: " + departureTime + "\n" +
                "days: " + days + "\n";
    }
}
