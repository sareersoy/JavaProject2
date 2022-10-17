public class Rate {
    private String userid;
    private String filmid;
    private String ratingPoint;

    public Rate(String userid, String filmid, String ratingPoint) {
        this.userid = userid;
        this.filmid = filmid;
        Exception RatingPointisntValidException = new Exception();
        if(Integer.parseInt(ratingPoint)<=10 && Integer.parseInt(ratingPoint)>=1){
        this.ratingPoint = ratingPoint;}
        else{
            try {
                throw RatingPointisntValidException;
            } catch (Exception e) {
                System.out.print("RATİNG POİNT İS NOT VALİD!");
               setRatingPoint("*");
            }
        }
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFilmid() {
        return filmid;
    }

    public void setFilmid(String filmid) {
        this.filmid = filmid;
    }

    public String getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(String ratingPoint) {
        this.ratingPoint = ratingPoint;
    }
}