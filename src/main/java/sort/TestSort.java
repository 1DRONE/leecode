package sort;

import java.util.Arrays;

/**
 * @author drone
 * @date 2021/5/14
 */
public class TestSort {
    public static void main(String[] args) {
        int[] array={4,5,6,8,12,3,2,1};
        System.out.println("排序前："+Arrays.toString(array));
        //冒泡
        //BubbleSort.sort(array);
        //插入
        //InsertionSort.sort(array);
        //选择
        //SelectionSort.sort(array);
        //递归
        //MergeSort.sort(array);
        //快排
        QuickSort.sort(array);

        System.out.println("排序后："+Arrays.toString(array));
    }
}
