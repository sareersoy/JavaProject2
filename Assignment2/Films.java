public class Films {
    private String RatingScore= " ";
    private String filmid= " ";
    private String filmtitle= " ";
    private String language= " ";
    private String runtime= " ";
    private String country= " ";
    private String[] directors;
    private String[] cast;
    private String[] writers;
    private String releaseDate= " ";
    private String[] genre;
    private String startdate= " ";
    private String enddate= " ";
    private String numberofseasons= " ";
    private String numberofepisodes= " ";
    private int rateCount = 0;
    private double SumRate = 0;
    private double AverageRate = 0.0;
    Exception ShortFilmrunTimeTooLongEception = new Exception();
    public String getAverage(){
        if(SumRate==0){
            return String.valueOf(0);
        }else {

            String avr = String.valueOf(Math.round((SumRate / rateCount)*10.0)/10.0);
            avr = avr.replace(".", ",");
            if (avr.endsWith("0")) {
                return avr.substring(0, avr.length() - 2);
            } else {
                return avr;
            }
        }
    }
    public double getdoubleAverage(){
        this.AverageRate= (SumRate/rateCount);

        return AverageRate;
    }
    public int getRateCount(){
        return rateCount;
    }

    public void increaseRateCount(String Strate){
        this.rateCount ++;
        this.SumRate += Integer.parseInt(Strate);
        getdoubleAverage();
    }

    public void decreaseRateCount(String Strate){
        this.SumRate -= Integer.parseInt(Strate);
        this.rateCount --;
        getdoubleAverage();
    }

    public Films( String filmid, String filmtitle, String language, String runtime, String country) {

        this.filmid = filmid;
        this.filmtitle = filmtitle;
        this.language = language;
        this.runtime = runtime;
        if(getClassName().equals("ShortFilm")){
            if (Integer.parseInt(runtime)<=40){
                this.runtime = runtime;}
            else{

                try {
                    throw ShortFilmrunTimeTooLongEception;
                } catch (Exception e) {
                    System.out.print("SHORT FİLM'S RUNTİME TOO LONG");
                    this.runtime= "*";
                }
            }
        }
        else{
            this.runtime = runtime;
        }
        this.country = country;
    }

    public String getNumberofseasons() {
        return numberofseasons;
    }

    public void setNumberofseasons(String numberofseasons) {
        this.numberofseasons = numberofseasons;
    }

    public String getNumberofepisodes() {
        return numberofepisodes;
    }

    public void setNumberofepisodes(String numberofepisodes) {
        this.numberofepisodes = numberofepisodes;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public void setGenre(String[] genre){
        this.genre=genre;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Films(String[] writers) {
        this.writers=writers;
    }

    public String getClassName(){
        return "Films";
    }

    public String[] getWriters() {
        return writers;
    }

    public void setWriters(String[] writers) {
        this.writers = writers;
    }

    public void setFilmid(String filmid) {
        this.filmid = filmid;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public void setRatingScore(String ratingScore) {
        RatingScore = ratingScore;
    }

    public String getRatingScore() {
        return RatingScore;
    }

    public String getFilmid() {
        return filmid;
    }

    public String getFilmtitle() {
        return filmtitle;
    }

    public String getLanguage() {
        return language;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getCountry() {
        return country;
    }

    public String[] getDirectors() {
        return directors;
    }

    public String[] getCast() {
        return cast;
    }
}
