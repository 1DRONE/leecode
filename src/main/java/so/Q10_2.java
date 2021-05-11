package so;

/**
 * @author drone
 * @date 2021/5/11
 */
public class Q10_2 {
    public int numWays(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = (p + q) % 1000000007;
        }
        return r;
    }
}
