public class ShortFilm extends Films {

    public ShortFilm(String filmid, String filmtitle, String language, String runtime, String country, String releasedate) {
        super(filmid, filmtitle, language, runtime, country);
        super.setReleaseDate(releasedate);}

    @Override
    public String getClassName() {
        return "ShortFilm";
    }


    public void setWriters(String[] writers) {
       super.setWriters(writers);
    }

    public void setGenre(String[] genre) {
        super.setGenre(genre);
    }
}

