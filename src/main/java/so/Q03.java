package so;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyizhang01
 * @date 2021-05-01
 */
public class Q03 {
    public int findRepeatNumber(int[] nums) {
        Map map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return nums[i];
            }
            map.put(nums[i],i);
        }
        return -1;
    }

}
