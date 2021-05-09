package so;

import java.util.HashMap;
import java.util.Map;

/**
 * @author drone
 * @date 2021/5/9
 */
public class Q56 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }

        for(int num:map.keySet()){
            if(1==map.get(num)){
                return num;
            }
        }
        return 0;
    }
}
