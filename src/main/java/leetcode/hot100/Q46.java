package leetcode.hot100;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangyizhang01
 * @date 2021-04-20
 */

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
// 👍 1306 👎 0
class Q46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        for(Integer num:nums){
            output.add(num);
        }

        int n=nums.length;
        backtrack(n,  output,result, 0);
        return result;

    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> result, int first) {
        if(first==n){
            result.add(new ArrayList<Integer>(output));
        }

        for(int i=first; i<n;i++){
            Collections.swap(output,first,i);
            backtrack(n,  output, result, first+1);
            Collections.swap(output,first,i);
        }
    }
}
