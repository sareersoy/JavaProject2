public class Actor extends Performer{


    public Actor(String id, String name, String surname,  String country, String height) {
        super(name, surname, id, country);
        super.setHeight(height);
    }

    @Override
    public String getClassName() {
        return "Actor";
    }

}
