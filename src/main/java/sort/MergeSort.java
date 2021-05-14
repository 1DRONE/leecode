package sort;

/**
 * 归并排序
 *
 * @author drone
 * @date 2021/5/15
 */
public class MergeSort {
    public static void sort(int[] array) {
        if (null == array || 0 == array.length) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int p, int r) {
        if (p >= r) {
            return;
        }
        // 取start到end之间的中间位置p,防止（p+r）的和超过int类型最大值
        int q = p + (r - p) / 2;
        // 分治递归
        mergeSort(array, p, q);
        mergeSort(array, q + 1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(array, p, q, r);
    }

    private static void merge(int[] array, int p, int q, int r) {
        // 初始化变量i, j, k
        int i = p;
        int j = q + 1;
        int k = 0;
        // 申请一个大小跟a[p...r]一样的临时数组
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }

        //判断哪个部分有剩余
        //上面while后i或者j已经加1了 所以不剩余的子数组为i=q+1或j=r+1
        int start = i <= q ? i : j;
        int end = i <= q ? q : r;

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = array[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        System.arraycopy(tmp, 0, array, p + 0, tmp.length);
    }

    /**
     * 合并(哨兵)
     *
     * @param arr
     * @param p
     * @param q
     * @param r
     */
    private static void mergeBySentry(int[] arr, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = arr[p + i];
        }
        // 第一个数组添加哨兵（最大值）
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = arr[q + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArr[r - q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
    }
}
