package builder;

public class Client {
    public static void run() {
        System.out.println("\n---------------------");
        System.out.println("Builder pattern\n---------------------");
        BuilderClient();
    }

    private static void BuilderClient() {
        // Create the builder
        AbstractBuilder builder = new VacationBuilder();

        // Customize the vacatoin builder to your liking
        builder.addReservation();
        builder.addSpecialEvent();
        builder.addTickets();
        builder.buildDay();

        // Create a vacation that stores the built vacation
        Vacation vacation = builder.getVacationPlanner();

        // Printer result
        System.out.println(vacation);
    }
}
