package sort;

/**
 * 快速排序
 *
 * 不稳定。序列 6，8，7，6，3，5，9，4，在经过第一次分区操作之后，两个 6 的相对先后顺序就会改变。j到3  i是第一个6
 *
 * @author drone
 * @date 2021/5/14
 */
public class QuickSort {
    public static void sort(int[] array) {
        if (null == array || 0 == array.length) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(array, p, r);

        quickSort(array, p, q - 1);
        quickSort(array, q + 1, r);
    }

    /**
     * 分区函数
     * <p>
     * 通过游标 i 把 A[p...r-1]分成两部分。A[p...i-1]的元素都是小于 pivot 的，我们暂且叫它“已处理区间”，A[i...r-1]是“未处理区间”。
     * 我们每次都从A[i...r-1]中取一个元素 A[j]，与 pivot 对比，如果小于 pivot，则将其加入到已处理区间的尾部，也就是 A[i]的位置。
     *
     * @param array
     * @param p
     * @param r
     * @return
     */
    private static int partition(int[] array, int p, int r) {
        //获取分区值  如果数量大可以使用三数取中法
        int pivot = array[r];
        int i = p;
        for (int j = i; j < r; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        //正常需要挨个移动比pivot的大的元素，但可以交换pivot和第一个元素
        swap(array, i, r);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
