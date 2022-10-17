public class ChildActor extends Artist{


    public ChildActor( String id,String name, String surname, String country, String age) {
        super(name, surname, id, country);
       super.setAge(age);
    }
    @Override
    public String getClassName() {
        return "ChildActor";
    }
}
