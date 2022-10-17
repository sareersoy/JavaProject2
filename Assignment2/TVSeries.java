public class TVSeries extends Films{

    public TVSeries(String filmid, String filmtitle, String language, String runtime, String country, String startdate, String enddate, String numberofseasons, String numberofepisodes) {
        super(filmid, filmtitle, language, runtime, country);
        super.setStartdate(startdate);
        super.setEnddate(enddate);
        super.setNumberofseasons(numberofseasons);
        super.setNumberofepisodes(numberofepisodes);
    }

    public void setGenreofseries(String[] genreofseries) {
        super.setGenre(genreofseries);
    }

    @Override
    public String getClassName() {
        return "TVSeries";
    }

    public void setWriters(String[] writers) {
        super.setWriters(writers);
    }
}
