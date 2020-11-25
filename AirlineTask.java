/*Airline: Пункт назначения, Номер рейса, Тип самолета, Время вылета, Дни недели.
Создать массив объектов. Вывести:
     a) список рейсов для заданного пункта назначения;
     b) список рейсов для заданного дня недели;
     c) список рейсов для заданного дня недели, время вылета для которых больше заданного.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AirlineTask {
    public static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        ArrayList<Airline> list = new ArrayList();

        list.add(new Airline("Prague", 6780, "Boeing-737",
                "15:00", Days.Monday));
        list.add(new Airline("Barcelona", 7741, "Boeing-747",
                "21:00", Days.Saturday));
        list.add(new Airline("Paris", 9753, "Boeing-737",
                "10:30", Days.Wednesday));
        list.add(new Airline("Genova", 1753, "Boeing-737",
                "13:20", Days.Thursday));
        list.add(new Airline("Venice", 8753, "Boeing-757",
                "18:42", Days.Tuesday));
        list.add(new Airline("Berlin", 9873, "Boeing-747",
                "05:25", Days.Friday));
        list.add(new Airline("Costa-Ricka", 1392, "Boeing-747",
                "21:25", Days.Sunday));

        listByDestination(list); //список рейсов для заданного пункта назначения;
        listByDay(list); //список рейсов для заданного дня недели;
        dayAndTime(list); //список рейсов для заданного дня недели, время вылета для которых больше заданного.
        cleanUp();
    }

    public static void listByDestination(ArrayList<Airline> list) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Searching airlines by destination. Please type destination below: ");
            String destination = reader.readLine();
            int count = 0;
            for (Airline airline : list) {
                if (airline.getDestination().equalsIgnoreCase(destination)) {
                    System.out.println(airline);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Sorry, we don't have required airlines");
            }
        } catch (Exception e) {
            System.out.println("Oops, something gone wrong!");
        }
    }
    public static void listByDay(ArrayList<Airline> list) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Searching airlines by day. Please type day below: ");
            Days day = Days.valueOf(reader.readLine());
            int count = 0;
            for (Airline airline : list) {
                if (airline.getDays().equals(day)) {
                    System.out.println(airline);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Sorry, we don't have required airlines");
            }
        } catch (Exception e) {
            System.out.println("Oops, something gone wrong!");
        }
    }
    public static void dayAndTime(ArrayList<Airline> list) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Searching airlines by day and time. Please type day below: ");
            Days day = Days.valueOf(reader.readLine());
            System.out.println("Please type time in format '00:00' below: ");
            String time = reader.readLine();
            int count = 0;
            DateFormat dateFormat;
            for (Airline airline : list) {
                dateFormat = new SimpleDateFormat("hh:mm");
                Date date = dateFormat.parse(airline.getDepartureTime());
                Date requiredDate = dateFormat.parse(time);
                if (airline.getDays().equals(day) && date.after(requiredDate)) {
                    System.out.println(airline);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Sorry, we don't have required airlines");
            }
        } catch (Exception e) {
            System.out.println("Oops, something gone wrong!");
        }
    }
    public static void cleanUp() throws IOException {
        reader.close();
    }
}
