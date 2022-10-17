public class Artist extends Person{
    public Artist(String name, String surname, String id, String country) {
        super(name, surname, id, country);
    }

    @Override
    public String getClassName() {
        return "Artist";
    }
}
