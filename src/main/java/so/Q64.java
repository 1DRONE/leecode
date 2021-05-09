package so;

/**
 * @author drone
 * @date 2021/5/9
 */
public class Q64 {
    public int sumNums(int n) {
        boolean flag=n>0 && (n+=sumNums(n-1))>0;
        return n;
    }
}
