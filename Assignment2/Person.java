import java.util.ArrayList;

public class Person {
    private String name;
    private String surname;
    private String id;
    private String country;
    private String agent;
    private String WritingType;
    private String height;
    private String age;
    ArrayList<Rate> RateList = new ArrayList<>();
    public Person(String name, String surname, String id, String country) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.country = country;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWritingType() {
        return WritingType;
    }

    public void setWritingType(String writingType) {
        WritingType = writingType;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public void addRateList(Rate rate) {
        this.RateList.add(rate);
    }

    public void setRateList(ArrayList<Rate> rateList) {
        RateList = rateList;
    }

    public ArrayList<Rate> getRateList() {
        return RateList;
    }

    public boolean isExist(Rate rate){
        boolean a =false;
        for(Rate rateinstance: RateList){
            if(rateinstance.getFilmid().equals(rate.getFilmid())){
                a = true;
            }
        }
        return a;
    }
    public String getClassName(){
        return "Person";
    }
    public String getClassName(String name){
        return name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
