import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFromFile {
    public static String[] readFile(String path){
        try{
            int i = 0;
            int length = Files.readAllLines(Paths.get(path)).size();
            String[] results = new String[length];
            for (String line : Files.readAllLines(Paths.get(path))){
                results[i++]= line;
            }
            return results;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }


}