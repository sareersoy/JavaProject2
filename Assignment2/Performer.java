public class Performer extends Artist{
    public Performer(String name, String surname, String id, String country) {
        super(name, surname, id, country);
    }

    @Override
    public String getClassName() {
        return "Performer";
    }
}
