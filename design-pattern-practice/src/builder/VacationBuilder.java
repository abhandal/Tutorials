package builder;

public class VacationBuilder implements AbstractBuilder {
    private Vacation vacation;

    public VacationBuilder() {
        vacation = new Vacation();
    }

    @Override
    public void buildDay() {
        vacation.addDay("Day Added");
    }

    @Override
    public void addReservation() {
        vacation.addReservation("Reservation Added");

    }

    @Override
    public void addSpecialEvent() {
        vacation.addSpecialEvent("Special Event Added");

    }

    @Override
    public void addTickets() {
        vacation.addTicket("Ticket Added");

    }

    @Override
    public Vacation getVacationPlanner() {
        return vacation;
    }
}
