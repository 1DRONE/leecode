import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
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

        LinkedList<Integer> objects = new LinkedList<>();

        objects.offer(1);
        objects.offer(2);
        objects.offer(3);
        objects.offer(4);

        swap(1,2);
        System.out.println();

    }

    private static void swap(int i,int j){
        i ^=j;
        j ^=i;
        i ^=j;

        System.out.println(i+" "+j);
    }
}
