package leetcode;

/**
 * @author drone
 * @date 2021/5/17
 */
public class Q498 {
    //初始化数组 result，用于存储最后结果。
    //使用一个外层循环遍历所有的对角线。第一行和最后一列的元素都是对角线的起点。
    //使用一个内层 while 循环遍历对角线上的所有元素。可以简单迭代直到索引超出范围。
    //记录每条对角线数组在结果集中的坐标 做反转

    public int[] findDiagonalOrder(int[][] mat) {
        if(null==mat || 0==mat.length){
            return new int[0];
        }

        //矩阵行数和列数
        int row=mat.length;
        int col=mat[0].length;

        int[] result=new int[row*col];
        //是否反转标识
        boolean sign=false;
        //result数组的动态索引
        int count=0;
        //row+col-1表示对角线起点数量
        for(int i=0;i<row+col-1;i++){
            //行列转换条件i<col
            int x=i<col?0:i+1-col;
            int y=i<col?i:col-1;

            //用于翻转result中新添加的一半对角线元素的起始索引
            //count在前一次遍历后已经++了  所以代表本次遍历的第一个元素坐标
            int fromIndex=count;
            while(x<row && y>=0){
                result[count++]=mat[x][y];
                x++;
                y--;
            }
            sign=!sign;
            if(sign){
                reverse(result,fromIndex,count-1);
            }
        }
        return result;
    }

    private void reverse(int[] array,int start,int end){
        while(start<end){
            int tmp=array[start];
            array[start]=array[end];
            array[end]=tmp;
            start++;
            end--;
        }
    }
}
