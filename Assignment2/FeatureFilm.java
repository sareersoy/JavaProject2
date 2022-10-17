public class FeatureFilm extends Films{

    private String budget;


    public FeatureFilm(String filmid, String filmtitle, String language,String runtime, String country, String releasedate, String budget) {
        super(filmid, filmtitle, language, runtime, country);

        this.budget = budget;
        super.setReleaseDate(releasedate);
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    @Override
    public void setWriters(String[] writers) {
        super.setWriters(writers);
    }


    @Override
    public String getClassName() {
        return "FeatureFilm";
    }

    public void setFilmgenre(String[] genre) {
        super.setGenre(genre);
    }
}
