public class Documentary extends Films{


    public Documentary(String filmid, String filmtitle, String language, String runtime, String country, String releasedate) {
        super( filmid, filmtitle, language, runtime, country);
        super.setReleaseDate(releasedate);
    }

    @Override
    public String getClassName() {
        return "Documentary";
    }
}
