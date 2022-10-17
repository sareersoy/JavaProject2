
import java.io.FileWriter;
import java.util.ArrayList;
public class Main {
    public static ArrayList<Person> personArrayList = new ArrayList<>();
    public static ArrayList<Films> filmsArrayList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        FileWriter fileWriter = new FileWriter(args[3]);
        String[] lines = ReadFromFile.readFile(args[0]);
        assert lines != null;
        for (String line : lines) {
            String[] array = line.split("\t");
            switch (array[0]){
                case "Actor:":{
                    Actor actor = new Actor(array[1],array[2],array[3],array[4],array[5]);
                    personArrayList.add(actor);
                    break;}
                case "Director:":{
                    Director director = new Director(array[1],array[2],array[3],array[4],array[5]);
                    personArrayList.add(director);
                    break;}
                case "Writer:":{
                    Writer writer = new Writer(array[1],array[2],array[3],array[4],array[5]);
                    personArrayList.add(writer);
                    break;}
                case "ChildActor:":{
                    ChildActor childActor = new ChildActor(array[1],array[2],array[3],array[4],array[5]);
                    personArrayList.add(childActor);
                    break;}
                case "StuntPerformer:":{
                    StuntPerformer stuntPerformer= new StuntPerformer(array[1],array[2],array[3],array[4],array[5]);
                    String[] IDs = array[6].split(",");
                    stuntPerformer.setIDs(IDs);
                    personArrayList.add(stuntPerformer);
                    break;}
                case "User:":{
                    User user = new User(array[1],array[2],array[3],array[4]);
                    personArrayList.add(user);
                    break;} } }
        String[] lines2 = ReadFromFile.readFile(args[1]);
        assert lines2 != null;
        for (String line : lines2) {
            String[] array2 = line.split("\t");
            switch (array2[0]){
                case "FeatureFilm:":{
                FeatureFilm featureFilm = new FeatureFilm(array2[1],array2[2],array2[3],array2[5],array2[6],array2[9],array2[11]);
                    String[] DirectorIds = array2[4].split(",");
                    featureFilm.setDirectors(DirectorIds);
                    String[] PerformerIds = array2[7].split(",");
                    featureFilm.setCast(PerformerIds);
                    String[] Genres = array2[8].split(",");
                    featureFilm.setFilmgenre(Genres);
                    String[] WriterIds = array2[10].split(",");
                    featureFilm.setWriters(WriterIds);
                    filmsArrayList.add(featureFilm);
                    break;}
                case "Documentary:":{
                    Documentary documentary = new Documentary(array2[1],array2[2],array2[3],array2[5],array2[6],array2[8]);
                    String[] DirectorId = array2[4].split(",");
                    documentary.setDirectors(DirectorId);
                    String[] PerformerId = array2[7].split(",");
                    documentary.setCast(PerformerId);
                    filmsArrayList.add(documentary);
                    break; }
                case "ShortFilm:":{
                    ShortFilm shortFilm = new ShortFilm(array2[1],array2[2],array2[3],array2[5],array2[6],array2[9]);
                    String[] DirectorsId = array2[4].split(",");
                    shortFilm.setDirectors(DirectorsId);
                    String[] PerformersId = array2[7].split(",");
                    shortFilm.setCast(PerformersId);
                    String[] Genre = array2[8].split(",");
                    shortFilm.setGenre(Genre);
                    String[] WritIds = array2[10].split(",");
                    shortFilm.setWriters(WritIds);
                    if(!(shortFilm.getRuntime().equals("*"))){
                        filmsArrayList.add(shortFilm);
                    }

                    break;}
                case "TVSeries:":{
                    TVSeries tvSeries = new TVSeries(array2[1],array2[2],array2[3],array2[5],array2[6],array2[10],array2[11],array2[12],array2[13]);
                    String[] tvDirectorId = array2[4].split(",");
                    tvSeries.setDirectors(tvDirectorId);
                    String[] tvPerformersId = array2[7].split(",");
                    tvSeries.setCast(tvPerformersId);
                    String[] tvGenre = array2[8].split(",");
                    tvSeries.setGenreofseries(tvGenre);
                    String[] tvWriterrIds = array2[9].split(",");
                    tvSeries.setWriters(tvWriterrIds);
                    filmsArrayList.add(tvSeries);
                    break;} } }

        String[] lines3 = ReadFromFile.readFile(args[2]);
        assert lines3 != null;
        for (String line : lines3) {
            String[] array3 = line.split("\t");


            switch(array3[0]){
                case "RATE":{
                    int breakc=0;
                    fileWriter.write( "\nRATE\t"+array3[1]+"\t"+array3[2]+"\t"+array3[3]+"\n\n");
                    int i=0;
                    for(Person person : personArrayList){
                        if(array3[1].equals(person.getId()) && person.getClassName().equals("User") ){
                            for(Films film: filmsArrayList){
                                if(film.getFilmid().equals(array3[2])){
                                    Rate rate = new Rate(array3[1],array3[2],array3[3]);
                                    if(person.isExist(rate)){
                                        fileWriter.write("This film was earlier rated"+"\n"+"\n-------------------------------------------------------------------------------");
                                    breakc++;
                                    break;}
                                    else{
                                        if(!(rate.getRatingPoint().equals("*"))){
                                    person.addRateList(rate);
                                    fileWriter.write("Film rated successfully\nFilm type: "+film.getClassName()+"\nFilm title: "+film.getFilmtitle()+"\n"+"\n-------------------------------------------------------------------------------");
                                    i++;
                                    film.increaseRateCount(array3[3]);}
                                      break;} } }} }
                    if(i==0 && breakc==0){
                        fileWriter.write("Command Failed\nUser Id: "+array3[1]+"\nFilm ID: "+array3[2]+"\n"+"\n-------------------------------------------------------------------------------"); }
                    break;}
                case "ADD":{
                    fileWriter.write( "\nADD "+array3[1]+"\t"+array3[2]+"\t"+array3[3]+"\t"+array3[4]+"\t"+array3[5]+"\t"+array3[6]+"\t"+array3[7]+"\t"+array3[8]+"\t"+array3[9]+"\t"+array3[10]+"\t"+array3[11]+"\t"+array3[12]+"\n");
                    int BreakCounter=0;
                    int DirectorCounter=0;
                    int WriterCounter = 0;
                    int PerformerCounter = 0;
                    for(Films isthere: filmsArrayList){
                        if(array3[2].equals(isthere.getFilmid())){
                            fileWriter.write("\nCommand Failed\nFilm ID: "+array3[2]+"\nFilm title: "+array3[3]+"\n"+"\n-------------------------------------------------------------------------------");
                            BreakCounter++;
                            break; }}
                    FeatureFilm newFeatureFilm = new FeatureFilm(array3[2],array3[3],array3[4],array3[6],array3[7],array3[10],array3[12]);
                    String[] DirectorIds = array3[5].split(",");
                    newFeatureFilm.setDirectors(DirectorIds);
                    String[] PerformerIds = array3[8].split(",");
                    newFeatureFilm.setCast(PerformerIds);
                    String[] Genres = array3[9].split(",");
                    newFeatureFilm.setFilmgenre(Genres);
                    String[] WriterIds = array3[11].split(",");
                    newFeatureFilm.setWriters(WriterIds);
                            for(String director: newFeatureFilm.getDirectors()){
                                for(Person person:personArrayList){
                                    if(person.getId().equals(director)){
                                        DirectorCounter++;
                                            break; } } }
                            for(String writer: newFeatureFilm.getWriters()){
                                for(Person person:personArrayList){
                                    if(person.getId().equals(writer)){
                                        WriterCounter++;
                                            break;}}}
                            for(String performer: newFeatureFilm.getCast()){
                                for(Person person:personArrayList){
                                    if(person.getId().equals(performer)){
                                        PerformerCounter++;
                                            break; }}}
                        if(BreakCounter==0 && WriterCounter==newFeatureFilm.getWriters().length && DirectorCounter==newFeatureFilm.getDirectors().length && PerformerCounter==newFeatureFilm.getCast().length) {
                            filmsArrayList.add(newFeatureFilm);
                            fileWriter.write("\nFeatureFilm added successfully\nFilm ID: "+array3[2]+"\nFilm title: "+array3[3]+"\n"+"\n-------------------------------------------------------------------------------");
                            break;}
                        else if (BreakCounter==0){
                            fileWriter.write("\nCommand Failed\nFilm ID: "+array3[2]+"\nFilm title: "+array3[3]+"\n"+"\n-------------------------------------------------------------------------------"); }
                        break; }
                case "VIEWFILM":{
                    fileWriter.write("\n"+array3[0]+"\t"+array3[1]+"\n");
                    for(Films film: filmsArrayList){
                           if(array3[1].equals(film.getFilmid())){
                                   if(film.getClassName().equals("FeatureFilm") || film.getClassName().equals("ShortFilm")){
                                       fileWriter.write("\n"+film.getFilmtitle()+" ("+film.getReleaseDate().substring(6)+")\n");
                                       for(int i=0; i<film.getGenre().length; i++){
                                           if((i+1)==film.getGenre().length){
                                               fileWriter.write(film.getGenre()[i]+"\n");}
                                           else{
                                               fileWriter.write(film.getGenre()[i]+", ");}}
                                           fileWriter.write("Writers: ");
                                           String a="";
                                                    for (String writerid: film.getWriters()){
                                                        for(Person person: personArrayList){
                                                            if(person.getId().equals(writerid)){
                                                                           a=a.concat(person.getName()+" "+person.getSurname()+", "); }}}
                                                    a=a.substring(0,(a.length()-2));
                                           fileWriter.write(a+"\nDirectors: ");
                                            String b="";
                                           for (String directorid: film.getDirectors()){
                                               for(Person person: personArrayList){
                                                   if(person.getId().equals(directorid)){
                                                       b=b.concat(person.getName()+" "+person.getSurname()+", "); }}}
                                           b=b.substring(0,(b.length()-2));
                                           fileWriter.write(b+"\nStars: ");
                                       String c="";
                                       for (String starid: film.getCast()){
                                           for(Person person: personArrayList){
                                               if(person.getId().equals(starid)){
                                                   c=c.concat(person.getName()+" "+person.getSurname()+", "); }}}
                                       c=c.substring(0,(c.length()-2));
                                       fileWriter.write(c);
                                       if(film.getRateCount()!=0){
                                           fileWriter.write("\nRatings: "+film.getAverage()+"/10 from "+film.getRateCount()+" users");}
                                       break; }
                                   else if(film.getClassName().equals("Documentary")){
                                       fileWriter.write("\n"+film.getFilmtitle()+" ("+film.getReleaseDate().substring(6)+")\n");
                                       fileWriter.write("Directors: ");
                                       String d="";
                                       for (String directorid: film.getDirectors()){
                                           for(Person person: personArrayList){
                                               if(person.getId().equals(directorid)){
                                                   d=d.concat(person.getName()+" "+person.getSurname()+", "); }}}
                                       d=d.substring(0,(d.length()-2));
                                       fileWriter.write(d+"\nStars: ");
                                       String e="";
                                       for (String starid: film.getCast()){
                                           for(Person person: personArrayList){
                                               if(person.getId().equals(starid)){
                                                   e=e.concat(person.getName()+" "+person.getSurname()+", "); }}}
                                       e=e.substring(0,(e.length()-2));
                                       fileWriter.write(e);
                                       if(film.getRateCount()!=0){
                                           fileWriter.write("\nRatings: "+film.getAverage()+"/10 from "+film.getRateCount()+" users");}
                                       break; }
                                   else if(film.getClassName().equals("TVSeries")){
                                       fileWriter.write("\n"+film.getFilmtitle()+" ("+film.getStartdate().substring(6)+"-"+film.getEnddate().substring(6)+")\n");
                                       fileWriter.write(film.getNumberofseasons()+" sesons, "+film.getNumberofepisodes()+" episodes\n");
                                       for(int i=0; i<film.getGenre().length; i++){
                                           if((i+1)==film.getGenre().length){
                                               fileWriter.write(film.getGenre()[i]+"\n");}
                                           else{
                                               fileWriter.write(film.getGenre()[i]+", ");}}
                                       fileWriter.write("Writers: ");
                                       String f="";
                                       for (String writerid: film.getWriters()){
                                           for(Person person: personArrayList){
                                               if(person.getId().equals(writerid)){
                                                   f=f.concat(person.getName()+" "+person.getSurname()+", "); }}}
                                       f=f.substring(0,(f.length()-2));
                                       fileWriter.write(f+"\nDirectors: ");
                                       String g="";
                                       for (String directorid: film.getDirectors()){
                                           for(Person person: personArrayList){
                                               if(person.getId().equals(directorid)){
                                                   g=g.concat(person.getName()+" "+person.getSurname()+", "); }}}
                                       g=g.substring(0,(g.length()-2));
                                       fileWriter.write(g+"\nStars: ");
                                       String h="";
                                       for (String starid: film.getCast()){
                                           for(Person person: personArrayList){
                                               if(person.getId().equals(starid)){
                                                   h=h.concat(person.getName()+" "+person.getSurname()+", "); }}}
                                       h=h.substring(0,(h.length()-2));
                                       fileWriter.write(h);
                                       if(film.getRateCount()!=0){
                                       fileWriter.write("\nRatings: "+film.getAverage()+"/10 from "+film.getRateCount()+" users");}
                                       break; } }
                    }
                    for(Films film: filmsArrayList){
                        if(array3[1].equals(film.getFilmid())){
                        if(film.getRateCount()==0){
                            fileWriter.write("\nAwaiting for votes"); }} }
                    fileWriter.write("\n\n-------------------------------------------------------------------------------");
                    break;}
                case "LIST":{
                    int personNotFoundCount=0;
                    if(array3[1].equals("USER") && array3[3].equals("RATES")){
                        fileWriter.write("\n"+array3[0]+"\t"+array3[1]+"\t"+array3[2]+"\t"+array3[3]+"\n");
                        for(Person person: personArrayList){
                            if(person.getId().equals(array3[2]) && person.getClassName().equals("User")) {
                                if(person.getRateList().isEmpty()){
                                    fileWriter.write("There is not any ratings so far");
                                    fileWriter.write("\n\n-------------------------------------------------------------------------------");
                                break;}
                            else{
                                    fileWriter.write("\n");
                                for(Rate rate: person.getRateList()){
                                    for(Films film: filmsArrayList){
                                        if(film.getFilmid().equals(rate.getFilmid())){
                                    fileWriter.write(film.getFilmtitle()+": "+rate.getRatingPoint()+"\n");
                                    }}}
                                    fileWriter.write("\n-------------------------------------------------------------------------------");
                                break; } }
                            else{
                               personNotFoundCount++; }}
                        if (personNotFoundCount==personArrayList.size()){
                            fileWriter.write("\nCommand Failed\nUser ID: "+array3[2]);
                            fileWriter.write("\n\n-------------------------------------------------------------------------------"); } }
                    else if (array3[1].equals("FILM") && array3[2].equals("SERIES")) {
                        fileWriter.write("\n"+array3[0]+"\t"+array3[1]+"\t"+array3[2]+"\n");
                        int tvSeriesCounter=0;
                        for(Films films:filmsArrayList){
                            if (films.getClassName().equals("TVSeries")){
                                tvSeriesCounter++;
                                fileWriter.write("\n"+films.getFilmtitle()+" ("+films.getStartdate().substring(6)+"-"+films.getEnddate().substring(6)+")");
                                fileWriter.write("\n"+films.getNumberofseasons()+" seasons and "+films.getNumberofepisodes()+" episodes\n"); } }
                        if(tvSeriesCounter==0){
                            fileWriter.write("No result\n");
                            fileWriter.write("\n\n-------------------------------------------------------------------------------");
                            break;}
                        fileWriter.write("\n-------------------------------------------------------------------------------"); }
                    else if(array3[1].equals("FILMS") && array3[3].equals("COUNTRY")){
                        int filmAcCountrCounter=0;
                    fileWriter.write("\n"+array3[0]+"\t"+array3[1]+"\t"+array3[2]+"\t"+array3[3]+"\t"+array3[4]+"\n");
                    for (Films films:filmsArrayList){
                        if(films.getCountry().equals(array3[4])){
                            filmAcCountrCounter++;
                            fileWriter.write("\nFilm title: "+films.getFilmtitle()+"\n"+films.getRuntime()+" min\nLanguage: "+films.getLanguage()+"\n"); } }
                    if(filmAcCountrCounter==0){
                        fileWriter.write("\nNo result\n"); }
                        fileWriter.write("\n-------------------------------------------------------------------------------"); }
                    else if(array3[1].equals("FEATUREFILMS") && array3[2].equals("BEFORE")){
                        int filmYearCount=0;
                        fileWriter.write("\n"+array3[0]+"\t"+array3[1]+"\t"+array3[2]+"\t"+array3[3]+"\n");
                        for(Films films:filmsArrayList){
                            if(films.getClassName().equals("FeatureFilm")){
                            int year = Integer.parseInt(films.getReleaseDate().substring(6));
                            if( year < Integer.parseInt(array3[3])){
                                filmYearCount++;
                                fileWriter.write("\nFilm title: "+films.getFilmtitle()+" ("+films.getReleaseDate().substring(6)+")\n"+films.getRuntime()+" min\nLanguage: "+films.getLanguage()+"\n"); } }}
                    if(filmYearCount==0){
                        fileWriter.write("\nNo result\n"); }
                        fileWriter.write("\n-------------------------------------------------------------------------------"); }
                    else if(array3[1].equals("FEATUREFILMS") && array3[2].equals("AFTER")){
                        int filmYearCount=0;
                        fileWriter.write("\n"+array3[0]+"\t"+array3[1]+"\t"+array3[2]+"\t"+array3[3]+"\n");
                        for(Films films:filmsArrayList){
                            if(films.getClassName().equals("FeatureFilm")){
                                int year = Integer.parseInt(films.getReleaseDate().substring(6));
                                if( year >= Integer.parseInt(array3[3])){
                                    filmYearCount++;
                                    fileWriter.write("\nFilm title: "+films.getFilmtitle()+" ("+films.getReleaseDate().substring(6)+")\n"+films.getRuntime()+" min\nLanguage: "+films.getLanguage()+"\n"); } }}
                        if(filmYearCount==0){
                            fileWriter.write("\nNo result\n"); }
                        fileWriter.write("\n-------------------------------------------------------------------------------"); }
                    else if(array3[1].equals("FILMS") && array3[2].equals("BY") && array3[3].equals("RATE")){
                        fileWriter.write("\n"+array3[0]+"\t"+array3[1]+"\t"+array3[2]+"\t"+array3[3]+ "\t"+array3[4]+"\n");
                        ArrayList<Films> featureFilmArrayList = new ArrayList<>();
                        ArrayList<Films> shortFilmArrayList = new ArrayList<>();
                        ArrayList<Films> DocArrayList = new ArrayList<>();
                        ArrayList<Films> TVSeriesArrayList = new ArrayList<>();
                        for(Films films: filmsArrayList){
                            if(films.getClassName().equals("FeatureFilm")){
                                featureFilmArrayList.add(films); }
                            else if(films.getClassName().equals("ShortFilm")){
                                shortFilmArrayList.add(films); }
                            else if(films.getClassName().equals("TVSeries")){
                                TVSeriesArrayList.add(films); }
                            else if(films.getClassName().equals("Documentary")){
                                DocArrayList.add(films); } }
                        featureFilmArrayList.sort(new RateSORTER().reversed());
                        shortFilmArrayList.sort(new RateSORTER().reversed());
                        DocArrayList.sort(new RateSORTER().reversed());
                        TVSeriesArrayList.sort(new RateSORTER().reversed());
                        fileWriter.write("\nFeatureFilm: \n");
                        if(featureFilmArrayList.size()!=0) {
                            for (Films films : featureFilmArrayList) {
                                fileWriter.write(films.getFilmtitle() + " (" + films.getReleaseDate().substring(6) + ") " + "Ratings: " + films.getAverage() + "/10 from " + films.getRateCount() + " users\n"); }
                        }else{ fileWriter.write("No result\n"); }
                        fileWriter.write("\nShortFilm: \n");
                        if(shortFilmArrayList.size()!=0) {
                            for (Films films : shortFilmArrayList) {
                                fileWriter.write(films.getFilmtitle() + " (" + films.getReleaseDate().substring(6) + ") " + "Ratings: " + films.getAverage() + "/10 from " + films.getRateCount() + " users\n"); }
                        }else{ fileWriter.write("No result\n"); }
                        fileWriter.write("\nDocumentary: \n");
                        if(DocArrayList.size()!=0) {
                            for (Films films : DocArrayList) {
                                fileWriter.write(films.getFilmtitle() + " (" + films.getReleaseDate().substring(6) + ") " + "Ratings: " + films.getAverage() + "/10 from " + films.getRateCount() + " users\n"); }
                        }else{ fileWriter.write("No result\n"); }
                        fileWriter.write("\nTVSeries: \n");
                        if(featureFilmArrayList.size()!=0) {
                            for (Films films : TVSeriesArrayList) {
                                fileWriter.write(films.getFilmtitle() + " (" + films.getStartdate().substring(6) +"-"+films.getEnddate()+ ") " + "Ratings: " + films.getAverage() + "/10 from " + films.getRateCount() + " users\n"); }
                        }else{ fileWriter.write("No result\n"); }
                        fileWriter.write("\n\n-------------------------------------------------------------------------------"); }
                    else if (array3[1].equals("ARTISTS") && array3[2].equals("FROM")){
                        int directorcounter =0;
                        int writercounter =0;
                        int actorcounter =0;
                        int chilactorcounter =0;
                        int stpercounter =0;
                        fileWriter.write("\n"+array3[0]+"\t"+array3[1]+"\t"+array3[2]+"\t"+array3[3]+"\n");
                        fileWriter.write("\nDirectors:\n");
                        for(Person person:personArrayList){
                            if(person.getCountry().equals(array3[3]) && person.getClassName().equals("Director")){
                                fileWriter.write(person.getName()+" "+person.getSurname()+" "+person.getAgent()+"\n");
                            directorcounter++; } }
                        if(directorcounter==0){
                            fileWriter.write("No result\n"); }
                        fileWriter.write("\nWriters:\n");
                        for(Person person:personArrayList){
                            if(person.getCountry().equals(array3[3]) && person.getClassName().equals("Writer")){
                                fileWriter.write(person.getName()+" "+person.getSurname()+" "+person.getWritingType()+"\n");
                                writercounter++; } }
                        if(writercounter==0){
                            fileWriter.write("No result\n"); }
                        fileWriter.write("\nActors:\n");
                        for(Person person:personArrayList){
                            if(person.getCountry().equals(array3[3]) && person.getClassName().equals("Actor")){
                                fileWriter.write(person.getName()+" "+person.getSurname()+" "+person.getHeight()+" cm\n");
                                actorcounter++; } }
                        if(actorcounter==0){
                            fileWriter.write("No result\n"); }
                        fileWriter.write("\nChildActors:\n");
                        for(Person person:personArrayList){
                            if(person.getCountry().equals(array3[3]) && person.getClassName().equals("ChildActor")){
                                fileWriter.write(person.getName()+" "+person.getSurname()+" "+person.getAge()+"\n");
                                chilactorcounter++; } }
                        if(chilactorcounter==0){
                            fileWriter.write("No result\n"); }
                        fileWriter.write("\nStuntPerformers:\n");
                        for(Person person:personArrayList){
                            if(person.getCountry().equals(array3[3]) && person.getClassName().equals("StuntPerformer")){
                                fileWriter.write(person.getName()+" "+person.getSurname()+" "+person.getHeight()+" cm\n");
                                stpercounter++; } }
                        if(stpercounter==0){
                            fileWriter.write("No result\n"); }
                        fileWriter.write("\n-------------------------------------------------------------------------------"); }
                    break; }
                case "EDIT":{
                    int personNotFoundC=0;
                    int ratecount=0;
                    int filmcount=0;
                    //EDIT<tab>1RATE<tab><2USERID><tab><3FILMID><tab><4NEWRATINGPOINT>
                    fileWriter.write("\n"+array3[0]+"\t"+array3[1]+"\t"+array3[2]+"\t"+array3[3]+"\t"+array3[4]+"\n");
                    ArrayList<Rate> rateContemp = new ArrayList<>();
                    for(Person person:personArrayList) {
                        if (person.getId().equals(array3[2]) && person.getClassName().equals("User")) {
                            for (Rate rate : person.getRateList()) {
                                if (rate.getFilmid().equals(array3[3])) {
                                    Rate ratenew = new Rate(array3[2], array3[3], array3[4]);
                                    rateContemp.add(ratenew);
                                    fileWriter.write("\nNew ratings done successfully\nFilm title: "); }
                                else {
                                    rateContemp.add(rate);
                                    ratecount++; }}
                                person.setRateList(rateContemp);
                                if (ratecount == person.getRateList().size()) {
                                    fileWriter.write("\nCommand filed\nUser ID: " + array3[2] + "\nFilm ID: " +array3[3]+"\n" + "\n-------------------------------------------------------------------------------");
                                    filmcount++;
                                    filmcount++;
                                    personNotFoundC++;
                                    personNotFoundC++;
                                    break; }
                                else{ person.setRateList(rateContemp);
                                    for (Films film : filmsArrayList) {
                                        if (film.getFilmid().equals(array3[3])) {
                                            for (Rate rate : person.getRateList()) {
                                                if (rate.getFilmid().equals(array3[3])) {
                                                    film.decreaseRateCount(rate.getRatingPoint());
                                                }}
                                            film.increaseRateCount(array3[4]);
                                            fileWriter.write(film.getFilmtitle() + "\nYour rating: " + array3[4] + "\n\n-------------------------------------------------------------------------------");
                                            break;} }
                                    break; } }
                        else { personNotFoundC++;} }
                        if(personNotFoundC==personArrayList.size()){filmcount++;
                            fileWriter.write("\nCommand filed\nUser ID: " + array3[2] + "\nFilm ID: " +array3[3]+"\n" + "\n-------------------------------------------------------------------------------");
                            break; }
                    for (Films film : filmsArrayList) {
                        if (!(film.getFilmid().equals(array3[3]))){filmcount++;} }
                    if (filmcount==filmsArrayList.size()){
                        fileWriter.write("\nCommand filed\nUser ID: " + array3[2] + "\nFilm ID: " +array3[3]+"\n" + "\n-------------------------------------------------------------------------------");
                        break; }
                    break; }
                case "REMOVE":{
                    int personcounter=0;
                    int ratecount=0;
                    int succescounter = 0;
                    int filmcounter=0;
                    ArrayList<Rate> rate2 = new ArrayList<>();
                     fileWriter.write("\n"+array3[0]+"\t"+array3[1]+"\t"+array3[2]+"\t"+array3[3]+"\n");
                    for(Person person:personArrayList){
                       if (person.getId().equals(array3[2]) && person.getClassName().equals("User")){
                            for(Rate rate:person.getRateList()){
                                if(rate.getFilmid().equals(array3[3])){
                                    for(Rate rate1:person.getRateList()){
                                        if(!(rate1.getFilmid().equals(array3[3]))){
                                            rate2.add(rate1); }
                                        else{ succescounter++;
                                            for (Films film : filmsArrayList) {
                                                if (film.getFilmid().equals(array3[3])) {
                                                    film.decreaseRateCount(rate.getRatingPoint()); }} } }
                                    person.setRateList(rate2); }
                                else{ ratecount++; } } }
                        else{ personcounter++; } }
                    if(succescounter!=0){
                        fileWriter.write("\nYour film rating was removed successfully\nFilm title: ");
                        for(Films films:filmsArrayList){
                            if (films.getFilmid().equals(array3[3])){
                                fileWriter.write(films.getFilmtitle()+"\n\n-------------------------------------------------------------------------------"); }}
                    break;}
                    if(personcounter==personArrayList.size()){
                        fileWriter.write("\nCommand Failed\nUser ID: "+array3[2]+"\nFilm ID: "+array3[3]+"\n\n------------------------------------------------------------------------------");
                        filmcounter++;
                        break;}
                    for(Person person:personArrayList){
                        if(person.getId().equals(array3[2]) && person.getClassName().equals("User")) {
                            if (ratecount == person.getRateList().size()){
                                fileWriter.write("\nCommand Failed\nUser ID: "+array3[2]+"\nFilm ID: "+array3[3]+"\n\n-------------------------------------------------------------------------------");
                                filmcounter++;
                                break;} }}
                    for(Films films:filmsArrayList){
                        if (films.getFilmid().equals(array3[3])){
                            filmcounter++; } }
                    if(filmcounter==0 ){
                        fileWriter.write("\nCommand Failed\nUser ID: "+array3[2]+"\nFilm ID: "+array3[3]+"\n\n-------------------------------------------------------------------------------");
                    break;}
                break;} }
       }

        fileWriter.close();}}
