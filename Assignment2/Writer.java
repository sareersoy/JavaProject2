public class Writer extends Artist{


    public Writer(String id, String name, String surname, String country, String writingType) {
        super(name, surname, id, country);
        super.setWritingType(writingType);
    }

    @Override
    public String getClassName() {
        return "Writer";
    }
}
