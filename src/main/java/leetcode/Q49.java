package leetcode;

import java.util.*;

/**
 * @author drone
 * @date 2021/6/2
 */
public class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] array=str.toCharArray();
            Arrays.sort(array);
            String key=new String(array);
            List<String> list=map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
