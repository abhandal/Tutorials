package builder;

import java.util.ArrayList;

public class Vacation {
    private ArrayList<String> vacation;

    public Vacation() {
        vacation = new ArrayList<>();
    }

    public void addDay(String day) {
        vacation.add(day);
    }

    public void addReservation(String reservation) {
        vacation.add(reservation);
    }

    public void addSpecialEvent(String se) {
        vacation.add(se);
    }

    public void addTicket(String ticket) {
        vacation.add(ticket);
    }

    public String toString() {
        String response = "";

        for(int i = 0; i < vacation.size(); i++) {
            response+= "\n" + vacation.get(i);
        }
        response += "\nEnjoy your custom vacation!";
        return response;
    }
}
