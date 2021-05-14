package sort;

/**
 * 插入排序
 *
 * 取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
 * 重复这个过程，直到未排序区间中元素为空，算法结束。
 *
 * @author drone
 * @date 2021/5/15
 */
public class InsertionSort {
    public static void sort(int[] array){
        if (null == array || 0 == array.length) {
            return;
        }
        int length = array.length;
        //查找插入位置
        for(int i=1;i<length;i++){
            int j=i-1;
            int value=array[i];
            for(;j>=0;j--){
                if (array[j]>value){
                    //数据移动
                    array[j+1]=array[j];
                }else {
                    break;
                }
            }
            //插入数据
            array[j+1]=value;
        }
    }
}
