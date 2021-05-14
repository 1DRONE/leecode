package sort;

/**
 * 选择排序
 * <p>
 * 选择排序也分已排序区间和未排序区间。
 * 每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
 *
 * 5，8，5，2，9 这样一组数据，使用选择排序算法来排序的话，第一次找到最小元素 2，与第一个 5 交换位置，那第一个 5 和中间的 5 顺序就变了
 *
 * @author drone
 * @date 2021/5/15
 */
public class SelectionSort {
    public static void sort(int[] array) {
        if (null == array || 0 == array.length) {
            return;
        }
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int minValueIndex = -1;
            int minValue = Integer.MAX_VALUE;

            for (int j = i; j < length; j++) {
                if (array[j] < minValue) {
                    minValue = array[j];
                    minValueIndex = j;
                }
            }
            array[minValueIndex] = array[i];
            array[i] = minValue;
        }
    }
}
