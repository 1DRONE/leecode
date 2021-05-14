import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test1 {
    public static void main(String[] args) {
     int a=10;
     int b=7;

     a ^=b;
     b ^=a;
     a ^=b;

        System.out.println(a);
        System.out.println(b);

    }
}
