import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyizhang01
 * @date 2021-04-21
 */

//生成100个整型的数组（范围30-60），找出所有两个之和为100的元素
public class Test {
    public static void main(String[] args) {
        int[] data = new int[100];
        for (int i = 0; i < 100; i++) {
            data[i] = 30 + 30 * (int) Math.random();
        }
        List<Map<Integer, Integer>> sortResult = sort(data, 100);
        for (Map<Integer, Integer> map:sortResult){
            for (Integer index:map.keySet()){
                System.out.println("下标："+index+"值"+map.get(index));
            }
            System.out.println("分组");
        }
    }

    private static List<Map<Integer, Integer>> sort(int[] data, int target) {
        List<Map<Integer, Integer>> result = new ArrayList<>();

        if (null == data || 0 == data.length) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();

        int temp;
        for (int i = 0; i < 100; i++) {
            temp = data[i];
            if (map.containsKey(target - temp)) {

                Map<Integer, Integer> itemMap = new HashMap<>();
                itemMap.put(i, temp);
                itemMap.put(map.get(target - temp), target - temp);

                result.add(itemMap);
            }
            map.put(temp, i);
        }
        return result;
    }

}
