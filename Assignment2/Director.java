public class Director extends Artist{
    ;

    public Director(String id, String name, String surname, String country, String agent) {
        super(name, surname, id, country);
        super.setAgent(agent);
    }


    @Override
    public String getClassName() {
        return "Director";
    }
}
