package so;

/**
 * @author drone
 * @date 2021/5/9
 */
public class Q15 {
    public int hammingWeight(int n) {
        int result=0;
        while(n !=0){
            result += n&1;
            n>>>=1;
        }
        return result;
    }
}
