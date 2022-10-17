import java.util.Comparator;

public class RateSORTER implements Comparator<Films> {
    @Override
    public int compare(Films o1, Films o2) {
        return o1.getAverage().compareTo(o2.getAverage());
    }
}
