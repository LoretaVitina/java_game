import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class ResultComparator implements Comparator {
    public int compare(Object o1, Object o2){
        Result r1 = (Result) o1;
        Result r2 = (Result) o2;

        if(r1.points == r2.points){
            if(r1.time == r2.time)
                return 0;
            else if (r1.time > r2.time)
                return -1;
            else
                return 1;
        }else if(r1.points > r2.points){
            return -1;
        }else
            return 1;
    }
}
