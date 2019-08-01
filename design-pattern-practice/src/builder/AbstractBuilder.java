package builder;

public interface AbstractBuilder {
    void buildDay();
    void addReservation();
    void addSpecialEvent();
    void addTickets();
    Vacation getVacationPlanner();
}
