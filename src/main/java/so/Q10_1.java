package so;

/**
 * @author drone
 * @date 2021/5/11
 */
public class Q10_1 {
    public int fib(int n) {
        int p = 0, q = 1, r = 0;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = (p + q) % 1000000007;
        }
        return r;
    }
}
