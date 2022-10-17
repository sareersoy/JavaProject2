public class StuntPerformer extends Performer{

    private String[] IDs;
    public StuntPerformer( String id, String name, String surname, String country, String height) {
        super(name, surname, id, country);
        super.setHeight(height);

    }

    public void setIDs(String[] IDs) {
        this.IDs = IDs;
    }

    @Override
    public String getClassName() {
        return "StuntPerformer";
    }
}
